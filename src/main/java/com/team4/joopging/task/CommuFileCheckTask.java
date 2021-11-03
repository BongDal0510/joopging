package com.team4.joopging.task;


import com.team4.joopging.community.dao.CommuAttachFileDAO;
import com.team4.joopging.community.vo.CommuAttachFileVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CommuFileCheckTask {


    @Autowired
    private CommuAttachFileDAO commuAttachFileDAO;

    @Scheduled(cron = "* * 2 * * *")
    public void checkFiles() {
        log.warn("File check task run...............");
        log.warn("----------------------------------");

        //어제 첨부파일 목록
        List<CommuAttachFileVO> fileVOList = commuAttachFileDAO.getOldFiles();

        //원본 경로
        List<Path> fileListPaths = fileVOList.stream().map(attach ->
                Paths.get("C:/upload/commu/", attach.getUploadPath(), attach.getUuid() + "_" + attach.getFileName())
        ).collect(Collectors.toList());

        //썸네일 경로를 원본 경로 List에 추가
        fileVOList.stream().filter(attach -> attach.isImage()).map(attach ->
                Paths.get("C:/upload/commu/", attach.getUploadPath(), "s_" + attach.getUuid() + "_" + attach.getFileName()))
                .forEach(path -> fileListPaths.add(path));

        //어제 업로드 된 폴더의 경로
        File dir = Paths.get("C:/upload/commu/", getFolderYesterday()).toFile();

        //DB에 있는 파일 경로와 실제 경로의 파일을 비교하여 일치하지 않는 것만 removeFiles에 담아준다.
        File[] removeFiles = dir.listFiles(file -> !fileListPaths.contains(file.toPath()));

        for(File file : removeFiles){
            log.warn(file.getPath() + " deleted");
            file.delete();
        }
    }

    private String getFolderYesterday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        //현재 날짜에서 -1은 하루 전날을 의미한다.
        cal.add(Calendar.DATE, -1);
        String str = sdf.format(cal.getTime());

        return str.replace("-", "/");
    }
}
