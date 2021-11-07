package com.team4.joopging.controller;

import com.team4.joopging.admin.vo.ReportCriteria;
import com.team4.joopging.admin.vo.ReportPageDTO;
import com.team4.joopging.admin.vo.ReportVO;
import com.team4.joopging.community.vo.CommuAttachFileVO;
import com.team4.joopging.community.vo.CommuPageDTO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.services.CommuService;
import com.team4.joopging.services.AdminService;
import com.team4.joopging.services.MemberService;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/report/*")
@RequiredArgsConstructor
public class ReportController {

    private final AdminService adminService;
    private final CommuService commuService;
    private final MemberService memberService;


    //###############################################사용자가 신고 등록하는 페이지#####################################################
    //report 팝업으로 페이지 이동
    @GetMapping("report")
    public String reportPop(@RequestParam("commuBno") Long commuBno, Model model, HttpServletRequest req) {
        //1. read에서 commuBno 가져옴.
        log.info("--------------------------------");
        log.info("신고할 게시글 번호 :" + commuService.getCommu(commuBno));
        log.info("--------------------------------");

        //2. sessionId 받아오고 싶어여
        HttpSession session = req.getSession();
        if(session.getAttribute("memberId")!= null){
            String memberId = (String)session.getAttribute("memberId");
            model.addAttribute("member", memberService.memberAllSelect(memberId));
        }
        //3. 신고일 연산 -- 메소드 따로 만들기
        //4. reportPurpose

        // commuboard에 있는 commuTitle
        model.addAttribute("commu", commuService.getCommu(commuBno));
       /* model.addAttribute("reporter", reportService.commuToReported());*/

        return "/report/report";
    }


    //report 등록
    @PostMapping("report")                                  //앞에서 받아오는 값
    public void insertReport(ReportVO report, Model model) {
        log.info("--------------------------------");
        log.info("register : " + report.toString());
        log.info("--------------------------------");
        adminService.insertReport(report);
        //세션의 flash 영역을 이용하여 전달
        //  RedirectView를 사용하면 redirect 방식으로 전송이 가능하다. flash에 잠시 값을 담아두고 redirect 초기화 후에 flash에서 값을 받아온다.
    }

    //###############################################관리자 창에서 띄워주는 페이지#####################################################
    //커뮤니티 전체목록 + 페이징
    @GetMapping("reportList")
    public String reportList(ReportCriteria reportCriteria, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        //로그인 되어있는 상태 알림 + 현재 아이디 담기
        if(session.getAttribute("memberId")!= null){
            String memberId = (String)session.getAttribute("memberId");
//            model.addAttribute("member", memberService.memberAllSelect(memberId));
        }
        log.info("------------------");
        log.info("reportList");
        log.info("------------------");

        model.addAttribute("reportList", adminService.getReportList(reportCriteria));
        model.addAttribute("pageMaker", new ReportPageDTO(adminService.getReportTotal(reportCriteria), 20, reportCriteria));
        return "report/reportList";
    }

    //신고하기 글 읽기 + 경로 이동 전 페이지 기억하기
    @GetMapping("reportRead")
    public String readReport(@RequestParam("reportNum") Long reportNum, ReportCriteria reportCriteria, Model model, ReportVO reportVO, HttpServletRequest req) {
        HttpSession session = req.getSession();
        //로그인 되어있는 상태 알림 + 현재 아이디 담기
        String memberId = (String)session.getAttribute("memberId");
//        model.addAttribute("member", memberService.memberAllSelect(memberId));


        log.info("--------------------------------");
        log.info(" read : " + reportNum);
        log.info("--------------------------------");
        log.info("read" +adminService.readReport(reportNum));
        model.addAttribute("admin", adminService.readReport(reportNum));
//        model.addAttribute("criteria", reportCriteria);

        return "report/reportRead";
    }

    //  삭제
    @PostMapping("removeReport")
    public RedirectView removeReport(@RequestParam("reportNum") Long reportNum, RedirectAttributes rttr) {
        log.info("-------------------");
        log.info("remove : " + reportNum);
        log.info("------------------");

        if (adminService.removeReport(reportNum)) {
            rttr.addFlashAttribute("result", "success");
        } else {
            rttr.addFlashAttribute("result", "fail");
        }
        return new RedirectView("reportList");
    }

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

}