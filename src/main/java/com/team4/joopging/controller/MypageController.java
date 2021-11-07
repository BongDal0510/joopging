package com.team4.joopging.controller;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.services.CommuService;
import com.team4.joopging.services.MemberService;
import com.team4.joopging.services.MypageService;
import com.team4.joopging.services.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

////import org.json.simple.JSONArray;
//import org.springframework.boot.configurationprocessor.json.JSONArray;

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

            model.addAttribute("plogging", mypageSVC.getPloggingList());
            model.addAttribute("member", memberSVC.memberAllSelect(memberId));
            model.addAttribute("ploRes", mypageSVC.getPloResList(memberId));
            model.addAttribute("getPointList", pointSVC.getPointList(memberId, criteria));
            model.addAttribute("orderHistory", mypageSVC.getOrderHistoryList(memberId));
            model.addAttribute("memberCommu", mypageSVC.getMemberCommuList(memberId));
            model.addAttribute("goodsLikeList", mypageSVC.getGoodsLikeList(memberId));

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
        log.info(membervo.getMemberAddress());
        log.info(membervo.getMemberEmail());
        log.info(membervo.getMemberName());
        log.info(membervo.getMemberId());
        log.info(membervo.getMemberZipcode());
        log.info(membervo.getMemberBirth());
        log.info(membervo.getMemberPw());

        if(vo.getMemberEmail()!=null && memberEmailSite!=null){
            membervo.setMemberEmail(vo.getMemberEmail() + "@" + memberEmailSite);
        }

        if(vo.getMemberAddress()!=null){
            membervo.setMemberAddress(vo.getMemberAddress());
        }

        if(vo.getMemberAddress()!=null && memberAddressDetail!=null){
            membervo.setMemberAddress(vo.getMemberAddress() + " " + memberAddressDetail);
        }

        if(vo.getMemberZipcode()!=null){
            membervo.setMemberZipcode(vo.getMemberZipcode());
        }

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
        model.addAttribute("plogging", mypageSVC.getPloggingList());
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
    @PostMapping("deleteGoodsLike")
    public String deleteGoodsLike(@RequestParam("result") String result, Model model) throws Exception {
        JSONParser jsonPar = new JSONParser();
            JSONObject jsonOj = (JSONObject) jsonPar.parse(result);
            List<String> goodsLikeNums = (List<String>) jsonOj.get("deleteGoodsLike");
        boolean check = false;
            for (int i = 0; i < goodsLikeNums.size(); i++) {
                int goodsLikeNum = Integer.parseInt(goodsLikeNums.get(i));
                if (mypageSVC.deleteGoodsLike(goodsLikeNum)) {
                    check = true;
                } else {
                    check = false;
                };
            }
            if (check) {
                model.addAttribute("msg", "daleteGoodsLike");
            } else {
                model.addAttribute("msg", "notDeleteGoodsLike");
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
