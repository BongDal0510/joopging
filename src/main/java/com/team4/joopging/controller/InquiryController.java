package com.team4.joopging.controller;

import com.team4.joopging.community.vo.CommuPageDTO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.community.vo.InquiryVO;
import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.services.InquiryService;
import com.team4.joopging.services.MemberService;
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


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/inquiry/*")
public class InquiryController {
        
    private final MemberService memberService;
    private final InquiryService inquiryService;
    //문의글 목록
    @GetMapping("inquiry")
    public String inquiry(Criteria criteria, Model model, HttpServletRequest r) {
      /*  String memberId = (String) r.getSession().getAttribute("memberId");
        MemberVO member = memberService.memberAllSelect(memberId);
*/
        model.addAttribute("list", inquiryService.getList(criteria));
        model.addAttribute("pageMaker", new CommuPageDTO(inquiryService.getTotal(criteria), 10, criteria));
        return "inquiry/inquiry";
    }

    //문의글 작성
    @PostMapping("inquiryWrite")
    public RedirectView inquiryWrite(InquiryVO inquiryVO, RedirectAttributes rttr) {
        inquiryService.register(inquiryVO);

        rttr.addFlashAttribute("num", inquiryVO.getInquiryNum());
        return new RedirectView("inquiry");
    }

    @GetMapping("inquiryWrite")
    public void inquiryWrite(){}

    //문의글 상세보기
    @GetMapping("inquiryRead")
    public void inquiryRead(@RequestParam("inquiryNum") Long inquiryNum, Criteria criteria, Model model) {
        model.addAttribute("inquiry", inquiryService.get(inquiryNum));
        model.addAttribute("criteria", criteria);
    }

    //문의글 삭제
    @PostMapping("remove")
    public RedirectView remove(@RequestParam("inquiryNum") Long inquiryNum, RedirectAttributes rttr, HttpServletRequest req){
        String id = (String)req.getSession().getAttribute("memberId");
        if(inquiryService.remove(inquiryNum)){
            rttr.addFlashAttribute("result", "success");
        } else{
            rttr.addFlashAttribute("result", "fail");
        }
        if(id.equals("admin")) {
            return new RedirectView("inquiryAdmin");
        }
        return new RedirectView("inquiry");
    }

    //1:1문의 목록 - 관리자
    @GetMapping("inquiryAdmin")
    public String inquiryAdmin(Criteria criteria, Model model) {

        model.addAttribute("list", inquiryService.getList(criteria));
        model.addAttribute("pageMaker", new CommuPageDTO(inquiryService.getTotal(criteria), 10, criteria));
        return "inquiry/inquiryAdmin";
    }
}
