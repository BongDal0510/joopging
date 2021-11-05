package com.team4.joopging.controller;

import com.team4.joopging.community.vo.CommuPageDTO;
import com.team4.joopging.community.vo.CommuReplyPageDTO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.services.CommuService;
import com.team4.joopging.services.MemberService;
import com.team4.joopging.services.MypageService;
import com.team4.joopging.services.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("mypage/*")
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageSVC;
    private final PointService pointSVC;
    private final MemberService memberSVC;
    private final CommuService commuSVC;

    /*마이페이지 메인으로 이동*/
    @GetMapping("mypage")
    public String mypage(Model model, HttpServletRequest req, Criteria criteria) {

        HttpSession session = req.getSession();

        if(session.getAttribute("memberId")!=null) {
            String memberId = (String)session.getAttribute("memberId");
            int memberNum = mypageSVC.selectMemberNum(memberId);

            model.addAttribute("member", memberSVC.memberAllSelect(memberId));
            model.addAttribute("ploRes", mypageSVC.getPloResList(memberNum, criteria));
            model.addAttribute("getPointList", pointSVC.getPointList(memberNum, criteria));
            model.addAttribute("orderHistory", mypageSVC.getOrderHistoryList(memberNum, criteria));
            model.addAttribute("memberCommu", mypageSVC.getMemberCommuList(memberId, criteria));
            model.addAttribute("goodsLikeList", mypageSVC.getGoodsLikeList(memberNum, criteria));

            return "mypage/mypage";
        }else{
            model.addAttribute("msg","notLogin");
            return "mypage/resultpage";
        }
    }

    /*비밀번호 수정하는 곳으로 이동*/
    @PostMapping("resultRePw")
    public String resultRePw(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");
        model.addAttribute("result", memberId);
        return "member/resultRePw";
    }

    /*회원 탈퇴*/
    @PostMapping("removeMember")
    public String removeMember(@RequestParam("deleteMemberPw") String memberPw, HttpServletRequest req,Model model){
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");
        if(mypageSVC.deleteMember(memberId,memberPw)){
            model.addAttribute("msg", "deleteMember");
        }else{
            model.addAttribute("msg", "notDeleteMember");
        }
        return "mypage/resultpage";
    }

    /*회원 수정*/
    @PostMapping("updateMember")
    public String updateMember(MemberVO vo,Model model, @RequestParam("memberEmailSite") String memberEmailSite, @RequestParam("memberAddressDetail") String memberAddressDetail, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");

        MemberVO membervo = memberSVC.memberAllSelect(memberId);

        membervo.setMemberEmail(vo.getMemberEmail() + "@" + memberEmailSite);
        membervo.setMemberAddress(vo.getMemberAddress() + " " + memberAddressDetail);
        membervo.setMemberZipcode(vo.getMemberZipcode());

        log.info("=========================================");
        log.info(membervo.getMemberId());
        log.info(membervo.getMemberName());
        log.info(membervo.getMemberEmail());
        log.info(membervo.getMemberAddress());
        log.info("=========================================");
        /*디비에 회원정보 저장*/
        if(mypageSVC.updateMember(membervo)){
            model.addAttribute("msg","updateMember");
        }else{
            model.addAttribute("msg","notUpdateMember");
        };
        return "mypage/resultpage";
    }

    /*플로깅 취소(파업창)- 천천히 해결합세*/
    @RequestMapping(value = "/ploggingRefundPage", method = RequestMethod.GET)
    public String ploggingRefundPage(Model model, @RequestParam("ploResNum") Long ploResNum) throws IOException {
        Long num = ploResNum;
        log.info(String.valueOf(ploResNum));
        model.addAttribute("ploRes", mypageSVC.getPloRes(num));
        return "/mypage/ploggingRefund";
    }

    /*플로깅 취소하기*/
    @PostMapping("ploggingRefund")
    public String ploggingRefund(Model model, @RequestParam("ploResNum") Long ploResNum){
        if(mypageSVC.deletePloRes(ploResNum)){
            model.addAttribute("msg", "refundPlogging");
        }else{
            model.addAttribute("msg", "notRefundPlogging");
        }
        return "mypage/resultpage";
    }


    /*찜 삭제*/
    @RequestMapping("deleteGoodsLike")
    public String deleteGoodsLike(Model model, @RequestParam("goodsLikeNums") List goodsLikeNums){
        boolean check = false;
        for (int i = 0; i < goodsLikeNums.size(); i++) {
            int goodsLikeNum = goodsLikeNums.indexOf(i);
            if(mypageSVC.deleteGoodsLike(goodsLikeNum)){
                log.info("====================================");
                log.info(i+"번째 삭제 된 찜번호 : "+String.valueOf(goodsLikeNum));
                log.info("====================================");
                check = true;
            }else {
                log.info("====================================");
                log.info(i+"번째 삭제 실패한 찜번호 : "+String.valueOf(goodsLikeNum));
                log.info("====================================");
                check = false;
            };
        }
        if(check){
            model.addAttribute("msg","daleteGoodsLike");
        }else{
            model.addAttribute("msg","notDeleteGoodsLike");
        }
        return "mypage/resultpage";
    }

    /*해더*/
    @GetMapping("/pageframe/header")
    public String header() {return "/pageframe/header";}

    /*푸터*/
    @GetMapping("/pageframe/footer")
    public String footer() {return "/pageframe/footer";}
}
