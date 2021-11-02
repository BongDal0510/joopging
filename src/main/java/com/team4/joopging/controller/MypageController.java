package com.team4.joopging.controller;

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
    HttpSession session;


    /*마이페이지 메인으로 이동*/
    @GetMapping("mypage")
    public String mypage(Model model, Criteria criteria) {
        if(session.getAttribute("memberId")!=null) {
            int memberNum = mypagedao.selectMemberNum((String)session.getAttribute("memberId"));

            model.addAttribute("ploRes", mypagedao.getPloResList(memberNum, criteria));
            model.addAttribute("goodsLikeList", mypagedao.getGoodsLikeList(memberNum, criteria));
            model.addAttribute("getPointList", pointdao.getPointList(memberNum, criteria));
            model.addAttribute("orderHistory", orderHistorydao.getOrderHistoryList(memberNum, criteria));
            model.addAttribute("ploResPageMaker", new CommuPageDTO(mypagedao.totalPloResCnt(memberNum), 10, criteria));
            model.addAttribute("goodsLikePageMaker", new CommuPageDTO(mypagedao.totalGoodsLikeCnt(memberNum), 10, criteria));
            model.addAttribute("orderPageMaker", new CommuPageDTO(orderHistorydao.totalOrderCnt(memberNum), 10, criteria));
            model.addAttribute("pointPageMaker", new CommuPageDTO(pointdao.totalPointCnt(memberNum), 10, criteria));
            model.addAttribute("ploResTotalCnt", mypagedao.realTotalPloResCnt(memberNum));
            model.addAttribute("goodslikeTotalCnt", mypagedao.totalGoodsLikeCnt(memberNum));
            model.addAttribute("orderTotalCnt", orderHistorydao.realTotalOrderCnt(memberNum));
            return "mypage/mypage";
        }else{
            model.addAttribute("msg","로그인 후 이용바랍니다.");
            return "mainpage/mainpage";
        }
    }

    /* */

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
