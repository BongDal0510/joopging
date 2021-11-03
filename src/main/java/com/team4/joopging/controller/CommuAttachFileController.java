package com.team4.joopging.controller;

import com.google.gson.JsonObject;
import com.team4.joopging.community.vo.CommuAttachFileVO;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/commuupload/*")


/*업로드 되는 첨부파일들이 저장될 폴더 경로 설정을 위한 컨트롤러
* upload 경로:
* "C:/upload/commu/";*/
public class CommuAttachFileController {

    @PostMapping(value = "uploadAjaxAction", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CommuAttachFileVO> uploadAjaxAction(MultipartFile[] uploadFiles){
        log.info("upload ajax action...........");
        List<CommuAttachFileVO> fileList = new ArrayList<>();

        String uploadFolder = "C:/upload/commu/";
        String uploadFolderPath = getFolder();

//        년/월/일 폴더 생성
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if(!uploadPath.exists()) {uploadPath.mkdirs();}
        log.info("upload path : " + uploadPath);

        for(MultipartFile multipartFile : uploadFiles){
            log.info("-------------------------");
            log.info("Upload File Name : " + multipartFile.getOriginalFilename());
            log.info("Upload File Size : " + multipartFile.getSize());

            CommuAttachFileVO commuAttachFileVO = new CommuAttachFileVO();

            String uploadFileName = multipartFile.getOriginalFilename();

//            UUID
//            네트워크 상에서 각각의 개체들을 식별하기 위하여 사용되었다.
//            중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
            UUID uuid = UUID.randomUUID();
            uploadFileName = uuid.toString() + "_" + uploadFileName;
            //IE에서는 파일 이름을 포함한 전체 경로가 나오기 때문에 잘라야한다.
            uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
            log.info("file name : " + uploadFileName);

            commuAttachFileVO.setFileName(uploadFileName);

            try {
                File saveFile = new File(uploadPath,uploadFileName);
                multipartFile.transferTo(saveFile);
                InputStream in = new FileInputStream(saveFile);

                commuAttachFileVO.setUuid(uuid.toString());
                commuAttachFileVO.setUploadPath(uploadFolderPath);

                if(checkImageType(saveFile)) {
                    commuAttachFileVO.setImage(true);
                    FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                    Thumbnailator.createThumbnail(in, thumbnail, 100, 100);
                    thumbnail.close();
                }
                in.close();

                //가비지 컬렉터 호출
                System.gc();
                //가비지 컬렉터가 포착한 해제 필드들을 모두 즉시 해제
                System.runFinalization();

                fileList.add(commuAttachFileVO);//파일 리스트에 가져온 파일 정보 추가
            } catch (IOException e) {
                log.error(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e){
                log.info("GIF 파일의 용량이 큽니다.");
            }
        }
        return fileList;
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String now = sdf.format(date);

//        - 대신 각 디렉토리의 경로를 구분할 수 있도록 하기 위해서
//        replace()를 사용한다.
        return now.replace("-", "/");
    }

//    서버에 업로드된 파일은 시간이 걸리더라도 파일 자체가 이미지인지를 정확하게 체크한 뒤 저장해야 한다.
    private boolean checkImageType(File file){
        try {
            String contentType = Files.probeContentType(file.toPath());
            return contentType.startsWith("image");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @GetMapping("display")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileName){
        File file = new File("C:/upload/commu/" + fileName);
        log.info("file : " + file);
        HttpHeaders header = new HttpHeaders();
        ResponseEntity<byte[]> result = null;
        try {
            //png 파일이면 image/png타입, jpeg파일이면 image/jpeg 타입으로 설정
            header.add("Content-Type", Files.probeContentType(file.toPath()));
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(String fileName){
        log.info("download file : " + fileName);
        Resource resource = new FileSystemResource("C:/upload/commu/" + fileName);
        log.info("resource : " + resource);
        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();
//        UUID 제거
        assert resourceName != null;
        String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
        try {
            headers.add("Content-Disposition", "attachment; filename=" + new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("deleteFile")
    @ResponseBody
    public ResponseEntity<String> deleteFile(String fileName, String type){
        log.info("deleteFile : " + fileName);
        try {
            fileName = URLDecoder.decode(fileName, "UTF-8");
            File file = new File("C:/upload/commu/" + fileName);
            file.delete();
            if(type.equals("image")){
                //원본 삭제
                new File(file.getPath().replace("s_", "")).delete();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
/*##############################################썸머노트 작성툴 이미지 업로드#####################################################*/
    @PostMapping(value="/uploadSummernoteImageFile", produces = "application/json")
    @ResponseBody
    public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile) {

        JsonObject jsonObject = new JsonObject();

        String fileRoot = "C:\\upload\\summernote\\";	//저장될 외부 파일 경로
        String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자

        String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명

        File targetFile = new File(fileRoot + savedFileName);

        try {
            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
            jsonObject.addProperty("url", "/summernoteImage/"+savedFileName);
            jsonObject.addProperty("responseCode", "success");

        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();
        }

        return jsonObject;
    }

}

















