package com.team4.joopging.controller;

import com.team4.joopging.mypage.dao.MypageDAO;
import com.team4.joopging.mypage.dao.OrderHistoryDAO;
import com.team4.joopging.point.dao.PointDAO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("mypage/*")
@RequiredArgsConstructor
public class MypageController {

    private final MypageDAO mypagedao;
    private final PointDAO pointdao;
    private final OrderHistoryDAO orderHistorydao;

    /*마이페이지로 이동*/
    @PostMapping("mypage")
    public String mypage(String memberId, Model model) {
        int memberNum = mypagedao.selectMemberNum(memberId);
        model.addAttribute("ploRes", mypagedao.getPloResList(memberNum));
        model.addAttribute("goodsLikeList",mypagedao.getGoodsLikeList(memberNum));
        model.addAttribute("getPointList",pointdao.getPointList(memberNum));
        model.addAttribute("orderHistory", orderHistorydao.getOrderHistoryList(memberNum));

        return "mypage/mypage";
    }

    /*플로깅 취소(파업창)- 천천히 해결합세*/
//    @RequestMapping(value = "/ploggingRefund", method = RequestMethod.GET)
//    public String ploggingRefund(Model model, @RequestParam(Value = "ploggingRefund", defaultValue = "") Long ploResNum) throws IOException {
//        model.addAttribute("ploggingRefund", dao.deletePloRes(ploResNum));
//    }

    /*해더*/
    @GetMapping("/pageframe/header")
    public String header() {return "/pageframe/header";}

    /*푸터*/
    @GetMapping("/pageframe/footer")
    public String footer() {return "/pageframe/footer";}
}
