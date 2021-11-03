package com.team4.joopging.controller;

import com.team4.joopging.community.dao.CommuDAO;
import com.team4.joopging.community.vo.CommuPageDTO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mypage.dao.MypageDAO;
import com.team4.joopging.mypage.dao.OrderHistoryDAO;
import com.team4.joopging.mypage.vo.TempMemberVO;
import com.team4.joopging.point.dao.PointDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("mypage/*")
@RequiredArgsConstructor
public class MypageController {

    private final MypageDAO mypagedao;
    private final PointDAO pointdao;
    private final OrderHistoryDAO orderHistorydao;
    private final TempMemberVO membervo;
    private final CommuDAO commudao;
    HttpSession session;


    /*마이페이지 메인으로 이동*/
    @GetMapping("mypageMain")
    public String mypageMain(Model model, Criteria criteria) {
        if(session.getAttribute("memberId")!=null) {
            String memberId = (String)session.getAttribute("memberId");
            int memberNum = mypagedao.selectMemberNum(memberId);

            model.addAttribute("ploRes", mypagedao.getPloResList(memberNum, criteria));

            return "mypage/mypage";
        }else{
            model.addAttribute("msg","로그인 후 이용바랍니다.");
            return "mainpage/mainpage";
        }
    }

    /*마이 페이지 플로깅 예약으로 이동*/
    @GetMapping("mypageploRes")
    public String mypageploRes(Model model, Criteria criteria) {
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypagedao.selectMemberNum(memberId);

        model.addAttribute("ploRes", mypagedao.getPloResList(memberNum, criteria));
        model.addAttribute("ploResPageMaker", new CommuPageDTO(mypagedao.totalPloResCnt(memberNum), 10, criteria));

        return "mypage/mypage";
    }
    /*마이 페이지 포인트로 이동*/
    @GetMapping("mypagePoint")
    public String mypagePoint(Model model, Criteria criteria) {
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypagedao.selectMemberNum(memberId);

        model.addAttribute("pointPageMaker", new CommuPageDTO(pointdao.totalPointCnt(memberNum), 10, criteria));
        model.addAttribute("getPointList", pointdao.getPointList(memberNum, criteria));

        return "mypage/mypage";
    }
    /*마이 페이지 구매상품으로 이동*/
    @GetMapping("mypageOrderHistory")
    public String mypageOrderHistory(Model model, Criteria criteria) {
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypagedao.selectMemberNum(memberId);

        model.addAttribute("orderPageMaker", new CommuPageDTO(orderHistorydao.totalOrderCnt(memberNum), 10, criteria));
        model.addAttribute("orderTotalCnt", orderHistorydao.realTotalOrderCnt(memberNum));
        model.addAttribute("orderHistory", orderHistorydao.getOrderHistoryList(memberNum, criteria));

        return "mypage/mypage";
    }
    /*마이 페이지 찜으로 이동*/
    @GetMapping("mypageGoodsLike")
    public String mypageGoodsLike(Model model, Criteria criteria) {
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypagedao.selectMemberNum(memberId);

        model.addAttribute("goodsLikePageMaker", new CommuPageDTO(mypagedao.totalGoodsLikeCnt(memberNum), 10, criteria));
        model.addAttribute("goodslikeTotalCnt", mypagedao.totalGoodsLikeCnt(memberNum));
        model.addAttribute("goodsLikeList", mypagedao.getGoodsLikeList(memberNum, criteria));

        return "mypage/mypage";
    }
    /*마이 페이지 내 게시글로 이동*/
    @GetMapping("mypageCommu")
    public String mypageCommu(Model model, Criteria criteria) {
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypagedao.selectMemberNum(memberId);

        model.addAttribute("memberCommu", mypagedao.getMemberCommuList(memberId, criteria));

        return "mypage/mypage";
    }
    /*마이 페이지 1:1문의사항으로 이동*/
    @GetMapping("mypageQue")
    public String mypageQue(Model model, Criteria criteria) {
        String memberId = (String)session.getAttribute("memberId");
        int memberNum = mypagedao.selectMemberNum(memberId);

        return "mypage/mypage";
    }

    /*회원 탈퇴*/
    @PostMapping("removeMember")
    public RedirectView removeMember(String memberId, String memberPw, RedirectAttributes rttr){
        if(mypagedao.deleteMember(memberId, memberPw)){
            rttr.addFlashAttribute("msg", "회원 탈퇴가 성공적으로 이루어졌습니다.");
            return new RedirectView("mainpage/mainpage");
        }else{
            rttr.addFlashAttribute("msg", "회원탈퇴에 실패하였습니다.");
            return new RedirectView("mypage/mypage");
        }
    }

    /*회원 정보 수정*/
    @PostMapping("updateMember")
    public RedirectView updateMember(TempMemberVO vo, RedirectAttributes rttr){
        if(mypagedao.updateMember(vo)){
            rttr.addFlashAttribute("msg", "회원 정보가 변경되었습니다.");
        }else{
            rttr.addFlashAttribute("msg", "회원 정보 변경에 실패하였습니다.");
        }
        return new RedirectView("mypage");
    }

    /*플로깅 취소(파업창)- 천천히 해결합세*/
    @RequestMapping(value = "/ploggingRefundPage", method = RequestMethod.GET)
    public String ploggingRefundPage(Model model, @RequestParam("ploResNum") Long ploResNum) throws IOException {
        model.addAttribute("ploRes", mypagedao.getPloRes(ploResNum));
        return "/mypage/ploggingRefund";
    }

    /*플로깅 취소하기*/
    @PostMapping("ploggingRefund")
    public void ploggingRefund(Model model, @RequestParam("ploResNum") Long ploResNum){
        if(mypagedao.deletePloRes(ploResNum)){
            model.addAttribute("result", "success");
        }else{
            model.addAttribute("result", "fail");
        }
        return;
    }

    /*찜 삭제*/
    @PostMapping("deleteGoodsLike")
    public void deleteGoodsLike(Model model, @RequestParam("goodsLikeNum") int goodsLikeNum){
        if(mypagedao.deleteGoodsLike(goodsLikeNum)){
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
