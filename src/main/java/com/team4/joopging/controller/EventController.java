package com.team4.joopging.controller;

import com.team4.joopging.event.vo.EventCriteria;
import com.team4.joopging.event.vo.EventPageDTO;
import com.team4.joopging.services.EventService;
import com.team4.joopging.services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//    프레젠테이션 계층의 구현

//    Task      URL             Method      Parameter   Form    URL 이동
//    전체 목록 /event/list      GET         없음         없음    없음
//    등록 처리 /event/register  POST        모든 항목     필요    이동
//    조회 처리 /event/read      GET         eventNum     필요    없음
//    삭제 처리 /event/remove    POST        eventNum     필요    이동
//    수정 처리 /event/modify    POST        모든 항목     필요    이동

@Controller
@Slf4j
@RequestMapping("/event/*")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final MemberService memberService;

    @PostMapping("eventlist")
    public String event(/*@RequestParam("memberId") String memberId,*/ EventCriteria eventCriteria, Model model) {
        model.addAttribute("list", eventService.getList(eventCriteria));



        model.addAttribute("member", memberService.memberAllSelect("최워너원"));
        model.addAttribute("pageMaker", new EventPageDTO(eventService.getTotal(), 10, eventCriteria));
        return "event/eventlist";
    }

    @GetMapping("joinInfo")
    public String joinInfo(String memberId, Model model) {
        model.addAttribute("member", memberService.memberAllSelect(memberId));
        log.info(memberId);
        return "event/joinInfo";
    }

    @GetMapping("attendPopup")
    public String attendPopup() {
        return "event/attendPopup";
    }

    @GetMapping("eventInfo")
    public String eventInfo(@RequestParam("memberId") String memberId, @RequestParam("eventNum") Long eventNum, Model model) {
        model.addAttribute("member", memberService.memberAllSelect(memberId));
        model.addAttribute("event", eventService.get(eventNum));
        return "event/eventInfo";
    }




    @GetMapping("eventInfo3")
    public String eventInfo3() {
        return "event/eventInfo3";
    }

    @GetMapping("eventInfo4")
    public String eventInfo4() {
        return "event/eventInfo4";
    }

    /* 위의 @RequestMapping 의 경로와 다를경우 '/' 슬래쉬를 붙여준다. */
    /* /event/pageframe/header → /pageframe/header */
    @GetMapping("/pageframe/header")
    public String header() {
        return "/pageframe/header";
    }

    @GetMapping("/pageframe/footer")
    public String footer() {
        return "/pageframe/footer";
    }
}