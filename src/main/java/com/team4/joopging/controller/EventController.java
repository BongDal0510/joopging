package com.team4.joopging.controller;

import com.team4.joopging.event.vo.EventCriteria;
import com.team4.joopging.event.vo.EventPageDTO;
import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.point.vo.PointVO;
import com.team4.joopging.services.EventService;
import com.team4.joopging.services.MemberService;
import com.team4.joopging.services.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    private final PointService pointService;

    @GetMapping("eventlist")
    public String event(HttpServletRequest req, EventCriteria eventCriteria, Model model) {

        HttpSession session = req.getSession();

        /* 세션이 담겨있을 때 회원정보 가져오기 */
        if(session.getAttribute("memberId")!= null){
            String memberId = (String)session.getAttribute("memberId");
            model.addAttribute("member", memberService.memberAllSelect(memberId));
        }

        model.addAttribute("list", eventService.getList(eventCriteria));
        model.addAttribute("pageMaker", new EventPageDTO(eventService.getTotal(), 10, eventCriteria));

        return "event/eventlist";
    }


    @PostMapping("attendUpdate")
    @ResponseBody
    public MemberVO attendUpdate(HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");

        /* 멤버 출석체크 */
        memberService.memberAttendUpdate(memberId);

        /* 멤버 테이블 포인트 추가 */
        MemberVO memberVO = new MemberVO();

        memberVO.setMemberId(memberId);
        memberService.memberPointUpdate(memberVO);

        /* 포인트 테이블 포인트내역 추가 */
        PointVO pointVo = new PointVO();

        pointVo.setHistory("출석");
        pointVo.setPointStatus("적립");


        return memberService.memberAllSelect(memberId);
    }


    @GetMapping("joinInfo")
    public String joinInfo(HttpServletRequest req, Model model) {

        HttpSession session = req.getSession();

        /* 세션이 담겨있을 때 회원정보 가져오기 */
        if(session.getAttribute("memberId")!=null){
            String memberId = (String)session.getAttribute("memberId");
            model.addAttribute("member", memberService.memberAllSelect(memberId));
        }

        return "event/joinInfo";
    }

    @GetMapping("eventInfo")
    public String eventInfo(HttpServletRequest req, @RequestParam("eventNum") Long eventNum, Model model) {

        HttpSession session = req.getSession();

        /* 세션이 담겨있을 때 회원정보 가져오기 */
        if(session.getAttribute("memberId")!=null){
            String memberId = (String)session.getAttribute("memberId");
            model.addAttribute("member", memberService.memberAllSelect(memberId));
        }

        model.addAttribute("event", eventService.get(eventNum));
        return "event/eventInfo";
    }

    @GetMapping("attendPopup")
    public String attendPopup() {
        return "event/attendPopup";
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