package com.team4.joopging.controller;

import com.team4.joopging.community.vo.CommuAttachFileVO;
import com.team4.joopging.community.vo.CommuPageDTO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.services.CommuService;
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
@RequestMapping("/commu/*")
@RequiredArgsConstructor
public class CommuController {
    private final CommuService commuService;

    //커뮤니티 전체목록 + 페이징
    @GetMapping("communityList")
    public String commuList(Criteria criteria, Model model) {
        log.info("--------------------------------");
        log.info("communityList");
        log.info("--------------------------------");

        model.addAttribute("announceList", commuService.getAnnounceList(2));
        model.addAttribute("commuList", commuService.getCommuList(criteria));
        model.addAttribute("pageMaker", new CommuPageDTO(commuService.getCommuTotal(criteria), 10, criteria));
        return "commu/communityList";
    }

    //커뮤니티 글쓰기
    @PostMapping("communityRegister")
    public RedirectView registerCommu(CommuVO commu, RedirectAttributes rttr, HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        log.info("--------------------------------");
        log.info("register : " + commu.toString());
        log.info("--------------------------------");

        model.addAttribute("commuWriter", session.getAttribute("memberId"));

        if(commu.getAttachList() != null){
            commu.getAttachList().forEach(attach -> log.info(attach.toString()));
        }

        commuService.registerCommu(commu);
        //세션의 flash 영역을 이용하여 전달
        rttr.addFlashAttribute("commuBno", commu.getCommuBno());

        //  RedirectView를 사용하면 redirect 방식으로 전송이 가능하다. flash에 잠시 값을 담아두고 redirect 초기화 후에 flash에서 값을 받아온다.
        return new RedirectView("communityList");
    }

    //커뮤니티 글 읽기/수정하기 경로이동 + 경로 이동 전 페이지 기억하기
    @GetMapping({"communityRead", "communityModify"})
    public void readCommu(@RequestParam("commuBno") Long commuBno, Criteria criteria, Model model, HttpServletRequest req, CommuVO commuVO, HttpServletRequest request) {
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        HttpSession session = req.getSession();
        //read 요청시 read 출력
        //modify 요청시 modify 출력
        log.info("--------------------------------");
        log.info(reqType + " : " + commuBno);
        log.info("viewCnt : " + commuVO.getCommuViewCnt());
        log.info("viewCnt : " + commuVO.getCommuRegDate());
        log.info("viewCnt : " + commuVO.getCommuUpdateDate());
        log.info("--------------------------------");

        model.addAttribute("commu", commuService.getCommu(commuBno));
        model.addAttribute("commuVO", commuService.updateCommuViewCnt(commuBno));
        model.addAttribute("criteria", criteria);
    }

    //커뮤니티 수정하기
    @PostMapping("communityModify")
    public RedirectView modifyCommu(CommuVO commu, RedirectAttributes rttr, HttpServletRequest req) {
        HttpSession session = req.getSession();
        log.info("--------------------------------");
        log.info("modify : " + commu.toString());
        log.info("--------------------------------");

        if(commuService.modifyCommu(commu)){
            rttr.addAttribute("result", "success");
            rttr.addAttribute("commuBno", commu.getCommuBno());
        }
        return new RedirectView("communityRead");
    }

    //  삭제
    @PostMapping("removeCommu")
    public RedirectView removeCommu(@RequestParam("commuBno") Long commuBno, RedirectAttributes rttr, HttpServletRequest req) {

        log.info("-------------------------------");
        log.info("remove : " + commuBno);
        log.info("-------------------------------");

        List<CommuAttachFileVO> attachList = commuService.getAttachList(commuBno);

        if (commuService.removeCommu(commuBno)) {
            deleteFiles(attachList);
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("communityList");
    }


    //파일삭제
    private void deleteFiles(List<CommuAttachFileVO> attachList){
        if(attachList == null || attachList.size() == 0){
            return;
        }

        log.info("delete attach files...........");
        log.info(attachList.toString());

        attachList.forEach(attach -> {
            try {
                Path file = Paths.get("C:/upload/commu/" + attach.getUploadPath() + "/" + attach.getUuid() + "_" + attach.getFileName());
                Files.delete(file);

                if(Files.probeContentType(file).startsWith("image")){
                    Path thumbnail = Paths.get("C:/upload/commu/" + attach.getUploadPath() + "/s_" + attach.getUuid() + "_" + attach.getFileName());
                    Files.delete(thumbnail);
                }
            } catch (Exception e) {
                log.error("delete file error " + e.getMessage());
            }
        });


    }


    @GetMapping("communityRegister")
    public void register(){}


    //헤더
    @GetMapping("/pageframe/header")
    public String header() {
        return "/pageframe/header";
    }

    //푸터
    @GetMapping("/pageframe/footer")
    public String footer() {
        return "/pageframe/footer";
    }


    //    게시글 첨부파일
    @GetMapping(value = "getCommuAttachList", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<CommuAttachFileVO> getCommuAttachList(Long commuBno){
        log.info("getCommuAttachList " + commuBno);
        return commuService.getAttachList(commuBno);
    }
}