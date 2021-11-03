package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("orderhistory/*")
@RequiredArgsConstructor
public class OrderHistoryController {

    /*구매 상품 상세보기 이동*/
    @PostMapping("orderInfo")
    public String orderInfo(){ return "mypage/orderInfo"; }

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
