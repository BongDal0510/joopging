package com.team4.joopging.controller;

import com.team4.joopging.community.vo.CommuPageDTO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.services.CommuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/commu/*")
@RequiredArgsConstructor
public class CommuController {
    private final CommuService commuService;

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


    @PostMapping("communityRegister")
    public RedirectView registerCommu(CommuVO commu, RedirectAttributes rttr) {
        log.info("--------------------------------");
        log.info("register : " + commu.toString());
        log.info("--------------------------------");

        commuService.registerCommu(commu);

        //세션의 flash 영역을 이용하여 전달
        rttr.addFlashAttribute("commuBno", commu.getCommuBno());

        //  RedirectView를 사용하면 redirect 방식으로 전송이 가능하다. flash에 잠시 값을 담아두고 redirect 초기화 후에 flash에서 값을 받아온다.
        return new RedirectView("communityList");
    }

    @GetMapping({"communityRead", "communityModify"})
    public void readCommu(@RequestParam("commuBno") Long commuBno, Criteria criteria, Model model, CommuVO commuVO, HttpServletRequest request) {
        String reqURI = request.getRequestURI();
        String reqType = reqURI.substring(reqURI.indexOf(request.getContextPath()) + 7);
        //read 요청시 read 출력
        //modify 요청시 modify 출력
        log.info("--------------------------------");
        log.info(reqType + " : " + commuBno);
        log.info("viewCnt : " + commuVO.getCommuViewCnt());
        log.info("--------------------------------");
        model.addAttribute("commu", commuService.getCommu(commuBno));
        model.addAttribute("commuVO", commuService.updateCommuViewCnt(commuBno));
        model.addAttribute("criteria", criteria);
    }

//조회수 증가 /commu/communityRead POST bno

//조회 = read할때 같이 진행되야하는데
    //modify 요청을 처리할 수 있는 비지니스 로직 작성
    //수정 성공시 result에 "success"를 담아서 전달한다.
    //단위 테스트로 View에 전달할 파라미터를 조회한다.
    //      수정 처리     /board/modify        POST      모든 항목       필요            이동

    @PostMapping("communityModify")
    public RedirectView modifyCommu(CommuVO commu, RedirectAttributes rttr) {
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
    public RedirectView remove(@RequestParam("commuBno") Long commuBno, RedirectAttributes rttr) {
        log.info("--------------------------------");
        log.info("removeCommu : " + commuBno);
        log.info("--------------------------------");

        if (commuService.removeCommu(commuBno)) {
            rttr.addFlashAttribute("result", "success");
            rttr.addFlashAttribute("commuBno", commuBno);
        }else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("communityList");
    }
    //페이지 이동만 할 때..
    //여러 요청을 하나의 메소드로 받을 때에는 {}를 사용하여 콤마로 구분한다.

    @GetMapping("communityRegister")
    public void goPage(){}

    @GetMapping("header")
    public String header() {
        return "header";
    }

    @GetMapping("footer")
    public String footer() {
        return "footer";
    }


    /*꼭 지우기!!!!!!!!!!!!*/
    @GetMapping("left-sidebar")
    public String sidebar() {
        return "left-sidebar";
    }
    @GetMapping("index")
    public String index() {
        return "index";
    }
}
