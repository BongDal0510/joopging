package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("mypage/*")
@RequiredArgsConstructor
public class MypageController {

//    private final MypageDAO mypagedao;
//    private final PointDAO pointdao;
//    private final OrderHistoryDAO orderHistorydao;
//    private final MemberVO membervo;


    /*마이페이지로 이동*/
    @GetMapping("mypage")
    public String mypage(/*String memberId, Model model*/) {
//
//        int memberNum = mypagedao.selectMemberNum(memberId);
//
//        model.addAttribute("ploRes", mypagedao.getPloResList(memberNum));
//        model.addAttribute("goodsLikeList",mypagedao.getGoodsLikeList(memberNum));
//        model.addAttribute("getPointList",pointdao.getPointList(memberNum));
//        model.addAttribute("orderHistory", orderHistorydao.getOrderHistoryList(memberNum));
        return "mypage/mypage";
    }
//
//    /*회원 탈퇴*/
//    @PostMapping("removeMember")
//    public RedirectView removeMember(String memberId, String memberPw, RedirectAttributes rttr){
//        if(mypagedao.deleteMember(memberId, memberPw)){
//            rttr.addFlashAttribute("result", "success");
//            return new RedirectView("mainpage/mainpage");
//        }else{
//            rttr.addFlashAttribute("result", "fail");
//            return new RedirectView("mypage");
//        }
//    }
//
//    /*회원 정보 수정*/
//    @PostMapping("updateMember")
//    public RedirectView updateMember(MemberVO vo, RedirectAttributes rttr){
//        if(mypagedao.updateMember(vo)){
//            rttr.addFlashAttribute("result", "success");
//        }else{
//            rttr.addFlashAttribute("result", "fail");
//        }
//        return new RedirectView("mypage");
//    }
//
//    /*플로깅 취소(파업창)- 천천히 해결합세*/
////    @RequestMapping(value = "/ploggingRefund", method = RequestMethod.GET)
////    public String ploggingRefund(Model model, @RequestParam(Value = "ploggingRefund", defaultValue = "") Long ploResNum) throws IOException {
////        model.addAttribute("ploggingRefund", dao.deletePloRes(ploResNum));
////    }

    /*해더*/
    @GetMapping("/pageframe/header")
    public String header() {return "/pageframe/header";}

    /*푸터*/
    @GetMapping("/pageframe/footer")
    public String footer() {return "/pageframe/footer";}
}
