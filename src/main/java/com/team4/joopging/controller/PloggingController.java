package com.team4.joopging.controller;

import com.team4.joopging.plogging.dao.PloAttachFileDAO;
import com.team4.joopging.plogging.vo.PloAttachFileVO;
import com.team4.joopging.plogging.vo.PloggingCriteria;
import com.team4.joopging.plogging.vo.PloggingDTO;
import com.team4.joopging.plogging.vo.PloggingVO;
import com.team4.joopging.services.PloggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/plo/*")
@RequiredArgsConstructor
public class PloggingController {

    private final PloggingService ploggingService;
    private final PloAttachFileDAO ploAttachFileDAO;

    /*플로깅 소개페이지*/
    @GetMapping("info")
    public String info(){
        return "ploggingReservation/ploInfo";
    }

    /*플로깅 목록 페이지*/
    @GetMapping("ploreslist")
    public String ploreslist(PloggingCriteria ploggingCriteria, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        /*테스트용 세션 생성*/
//        session.setAttribute("memberId", "테스트세션");

        List<PloggingVO> listVO = ploggingService.getList(ploggingCriteria);
        PloggingVO vo = new PloggingVO();

        for(int i=0; i<listVO.size(); i++){
            listVO.get(i).setFileName("/images/ploggingReservation/"+ ploggingService.getFileNames(listVO.get(i).getPloggingNum()));
        }
        System.out.println(listVO.toString());

//        for (PloggingVO img : listVO) { //for 자료형 참조변수 : 담을 배열이름
//            vo.setFileName("/images/ploggingReservation/"+ ploggingService.getFileNames(img.getPloggingNum()));
//            System.out.println("/images/ploggingReservation/"+ ploggingService.getFileNames(vo.getPloggingNum()));
//        }
//        ploggingService.getFileNames(listVO)

        model.addAttribute("list", listVO);
//        model.addAttribute("file", vo);
        model.addAttribute("pageMaker", new PloggingDTO(ploggingService.getTotal(), 10, ploggingCriteria));
        return "ploggingReservation/ploResList";
    }

    /*플로깅 상세페이지*/
    @GetMapping("ploresinfo")
    public String ploResInfo(@RequestParam("ploggingNum") int ploggingNum, Model model){
//        HttpSession session = req.getSession();
//        model.addAttribute("img", ploAttachFileDAO.getFileName(ploggingNum));

        /*이미지 가져오기*/
        PloAttachFileVO vo = ploggingService.getAttachList(ploggingNum).get(0);
        log.info(vo.getUuid() + "_" + vo.getFileName());
        model.addAttribute("img", "/images/ploggingReservation/" + vo.getFileName());

        /*게시글 정보 가져오기*/
        model.addAttribute("plogging", ploggingService.get(ploggingNum));
        return "/ploggingReservation/ploResInfo";
    }

    /*플로깅 결제 팝업 창*/
    @GetMapping("payment")
    public String payMent(){ return "ploggingReservation/payMent"; }

    /*플로깅 글쓰기 창*/
    @GetMapping("ploWritePop")
    public String plowritePop(PloggingVO vo){ return "ploggingReservation/ploggingWrite"; }

    /*플로깅 글쓰기 완료 후 디비 저장*/
    @PostMapping("ploWrite")
    public RedirectView ploWrite(PloggingVO vo, RedirectAttributes rttr){
        if(vo.getAttachList() != null){
            vo.getAttachList().forEach(attach -> log.info(attach.toString()));
        }
        ploggingService.register(vo);
        rttr.addFlashAttribute("plogging", vo.getPloggingNum());

        return new RedirectView("writeSuccess");
    }

    //  삭제
    @PostMapping("removePlogging")
    public RedirectView remove(@RequestParam("ploggingNum") int ploggingNum, RedirectAttributes rttr) {
        log.info("-------------------------------");
        log.info("remove : " + ploggingNum);
        log.info("-------------------------------");

        List<PloAttachFileVO> attachList = ploggingService.getAttachList(ploggingNum);

        if (ploggingService.remove(ploggingNum)) {
            deleteFiles(attachList);
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("writeSuccess");
    }


    //파일삭제
    private void deleteFiles(List<PloAttachFileVO> attachList){
        if(attachList == null || attachList.size() == 0){
            return;
        }

        log.info("delete attach files...........");
        log.info(attachList.toString());

        attachList.forEach(attach -> {
            try {
                Path file = Paths.get("C:/upload/plogging/" + attach.getUploadPath() + "/" + attach.getUuid() + "_" + attach.getFileName());
                Files.delete(file);

                if(Files.probeContentType(file).startsWith("image")){
                    Path thumbnail = Paths.get("C:/upload/plogging/" + attach.getUploadPath() + "/s_" + attach.getUuid() + "_" + attach.getFileName());
                    Files.delete(thumbnail);
                }
            } catch (Exception e) {
                log.error("delete file error " + e.getMessage());
            }
        });


    }

    //    게시글 첨부파일
    @GetMapping(value = "getAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getAttachList(int ploggingNum){
        log.info("getAttachList " + ploggingNum);
        PloAttachFileVO vo = ploggingService.getAttachList(ploggingNum).get(0);

        System.out.println(vo.getFileName());
        System.out.println(vo.getUuid());
        return vo.getUuid() + "_" + vo.getFileName();
    }

    /*플로깅 예약*/
    @PostMapping("reservation")
    public String reservation(String memberId, String ploggingNum, int peo){

        log.info("----------------------------");
        log.info("플로깅 넘버 :" + ploggingNum);
        log.info("플로깅 신청 인원 :" + peo);
        log.info("----------------------------");
        ploggingService.reservation(memberId, ploggingNum);
        ploggingService.addPloggingPpl(peo, ploggingNum);

        log.info("디비 저장 성공");
        return "/main/mainpage";
    }

    /*테스트 버튼*/
    @GetMapping("writeSuccess")
    public String writeSuccess(){
        return "ploggingReservation/button";
    }
}
