package com.team4.joopging.controller;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.mappers.CommuMapper;
import com.team4.joopging.report.vo.ReportVO;
import com.team4.joopging.services.CommuService;
import com.team4.joopging.services.ReportService;
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

@Controller
@Slf4j
@RequestMapping("/report/*")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final CommuService commuService;
    //report 팝업으로 페이지 이동
    @GetMapping("report")
    public String reportPop(@RequestParam("commuBno") Long commuBno, Model model) {
        //1. read에서 commuBno 가져옴.
        log.info("--------------------------------");
        log.info("commuInfo :" + commuService.getCommu(commuBno));
        log.info("--------------------------------");

        model.addAttribute("commu", commuService.getCommu(commuBno));
        model.addAttribute("reporter", reportService.commuToReported());

        return "/report/report";
    }

    //report 등록
    @PostMapping("report")                                  //앞에서 받아오는 값
    public String insertReport(ReportVO report, Model model) {
        log.info("--------------------------------");
        log.info("register : " + report.toString());
        log.info("--------------------------------");

        //1. commuboard에 있는 commuTitle을 가져오고 싶어요
        //2. sessionId 받아오고 싶어여
        //3. reportVo 있는 신고일 sysdate 여기 넣고싶어는
        //4. reportPurpose

        reportService.insertReport(report);
        //세션의 flash 영역을 이용하여 전달



/*        model.addAttribute("commu", commu.getCommuTitle());
        rttr.addFlashAttribute("commuBno", report.getCommuBno());*/

        //  RedirectView를 사용하면 redirect 방식으로 전송이 가능하다. flash에 잠시 값을 담아두고 redirect 초기화 후에 flash에서 값을 받아온다.
        return "communityList";
    }


}
