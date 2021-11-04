package com.team4.joopging.controller;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.services.MemberService;
import com.team4.joopging.services.MypageService;
import com.team4.joopging.services.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
@Slf4j
@RequestMapping("orderhistory/*")
@RequiredArgsConstructor
public class OrderHistoryController {

    private final MypageService mypageSVC;
    private final PointService pointSVC;
    private final MemberService memberSVC;

    /*구매 상품 상세보기 이동*/
    @GetMapping("orderInfo")
    public String orderInfo(@RequestParam("orderNum") int orderNum, Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");

        model.addAttribute("order", mypageSVC.getOrderHistory(orderNum));
        model.addAttribute("member",memberSVC.memberAllSelect(memberId));
//        model.addAttribute("parcel",mypageSVC.getParcel(orderNum));

        return "mypage/orderInfo";
    }

    /*택배 내역(파업창)*/
    @PostMapping("deliveryTracking")
    public String deliveryTracking(){ return "mypage/deliveryTracking"; }

    /*상품 환불(파업창)*/
    @GetMapping("goodsRefund")
    public String goodsRefund(){ return "mypage/goodsRefund"; }

    /*해더*/
    @GetMapping("/pageframe/header")
    public String header() {return "/pageframe/header";}

    /*푸터*/
    @GetMapping("/pageframe/footer")
    public String footer() {return "/pageframe/footer";}

}
