package com.team4.joopging.controller;

import com.team4.joopging.community.vo.CommuPageDTO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.member.memberVO.MemberVO;
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

@Controller
@Slf4j
@RequestMapping("mypage/*")
@RequiredArgsConstructor
public class MypageController {

    private final MypageService mypageSVC;
    private final PointService pointSVC;
    private final MemberService memberSVC;

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
            model.addAttribute("msg","로그인 후 이용바랍니다.");
            return "/mainpage";
        }
    }

    /*마이 페이지 플로깅 예약으로 이동*/
    @RequestMapping(value = "mypagePloRes", method = RequestMethod.POST)
    public RedirectView mypagePloRes(Criteria criteria, HttpServletRequest req, RedirectAttributes rttr) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypageSVC.selectMemberNum(memberId);

        if(mypageSVC.getPloResList(memberNum,criteria).size()!=0) {
            rttr.addAttribute("ploResAll", mypageSVC.getPloResList(memberNum, criteria));
//            rttr.addAttribute("bno", boardVO.getBno());
        }
        return new RedirectView("mypage");
    }

//    @GetMapping("mypagePloRes")
//    public void mypagePloRes(Model model, Criteria criteria, HttpServletRequest req) {
//        HttpSession session = req.getSession();
//        String memberId = (String)session.getAttribute("memberId");
//        int memberNum = mypageSVC.selectMemberNum(memberId);
//
//        model.addAttribute("ploResAll", mypageSVC.getPloResList(memberNum, criteria));
//        model.addAttribute("ploResPageMaker", new CommuPageDTO(mypageSVC.totalPloResCnt(memberNum), 10, criteria));
//
//        return;
//    }

    /*마이 페이지 포인트로 이동*/
    @GetMapping("mypagePoint")
    public String mypagePoint(Model model, Criteria criteria, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");

        int memberNum = mypageSVC.selectMemberNum(memberId);

        model.addAttribute("pointPageMaker", new CommuPageDTO(pointSVC.totalPointCnt(memberNum), 10, criteria));
        model.addAttribute("getPointList", pointSVC.getPointList(memberNum, criteria));

        return "mypage/mypage";
    }

    /*비밀번호 수정하는 곳으로 이동*/
    @PostMapping("resultRePw")
    public String resultRePw(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");
        model.addAttribute("result", memberId);
        return "member/resultRePw";
    }

    /*마이 페이지 구매상품으로 이동*/
    @GetMapping("mypageOrderHistory")
    public String mypageOrderHistory(Model model, Criteria criteria, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypageSVC.selectMemberNum(memberId);

        model.addAttribute("orderPageMaker", new CommuPageDTO(mypageSVC.totalOrderCnt(memberNum), 10, criteria));
        model.addAttribute("orderTotalCnt", mypageSVC.realTotalOrderCnt(memberNum));
        model.addAttribute("orderHistory", mypageSVC.getOrderHistoryList(memberNum, criteria));

        return "mypage/mypage";
    }
    /*마이 페이지 찜으로 이동*/
    @GetMapping("mypageGoodsLike")
    public String mypageGoodsLike(Model model, Criteria criteria, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypageSVC.selectMemberNum(memberId);

        model.addAttribute("goodsLikePageMaker", new CommuPageDTO(mypageSVC.totalGoodsLikeCnt(memberNum), 10, criteria));
        model.addAttribute("goodslikeTotalCnt", mypageSVC.totalGoodsLikeCnt(memberNum));
        model.addAttribute("goodsLikeList", mypageSVC.getGoodsLikeList(memberNum, criteria));

        return "mypage/mypage";
    }
    /*마이 페이지 내 게시글로 이동*/
    @GetMapping("mypageCommu")
    public String mypageCommu(Model model, Criteria criteria, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypageSVC.selectMemberNum(memberId);

        model.addAttribute("memberCommu", mypageSVC.getMemberCommuList(memberId, criteria));

        return "mypage/mypage";
    }
    /*마이 페이지 1:1문의사항으로 이동*/
    @GetMapping("mypageQue")
    public String mypageQue(Model model, Criteria criteria, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypageSVC.selectMemberNum(memberId);

        return "mypage/mypage";
    }

    /*회원 탈퇴*/
    @PostMapping("removeMember")
    public RedirectView removeMember(String memberId, String memberPw, RedirectAttributes rttr){
        if(mypageSVC.deleteMember(memberId,memberPw)){
            rttr.addFlashAttribute("msg", "회원 탈퇴가 성공적으로 이루어졌습니다.");
            return new RedirectView("mainpage/mainpage");
        }else{
            rttr.addFlashAttribute("msg", "회원탈퇴에 실패하였습니다.");
            return new RedirectView("mypage/mypage");
        }
    }

    /*회원 수정*/
    @PostMapping("updateMember")
    public String updateMember(MemberVO vo, String memberEmailSite, String memberAddressDetail) {
        /*디비에 회원정보 저장*/
        vo.setMemberEmail(vo.getMemberEmail() + "@" + memberEmailSite);
        vo.setMemberAddress(vo.getMemberAddress() + " " + memberAddressDetail);
        mypageSVC.updateMember(vo);
        return "/mainpage";
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
            model.addAttribute("msg", "플로깅 취소가 완료되었습니다.");
        }else{
            model.addAttribute("msg", "플로깅 취소에 실패하였습니다.");
        }
        return "mypage/close";
    }

    /*찜 삭제*/
    @PostMapping("deleteGoodsLike")
    public void deleteGoodsLike(Model model, @RequestParam("goodsLikeNum") int goodsLikeNum){
        if(mypageSVC.deleteGoodsLike(goodsLikeNum)){
            model.addAttribute("msg","해당 상품에 찜을 삭제하였습니다.");
        }else{
            model.addAttribute("msg","찜 삭제에 실패하였습니다.");
        }
        return;
    }


    /*해더*/
    @GetMapping("/pageframe/header")
    public String header() {return "/pageframe/header";}

    /*푸터*/
    @GetMapping("/pageframe/footer")
    public String footer() {return "/pageframe/footer";}
}
