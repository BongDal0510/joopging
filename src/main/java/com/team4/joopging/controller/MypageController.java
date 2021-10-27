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

    @GetMapping("mypage")
    public String mypage(){
        return "mypage/mypage";
    }

    @GetMapping("orderInfo")
    public String orderInfo(){ return "mypage/orderInfo"; }

    @GetMapping("goodsRefund")
    public String goodsRefund(){ return "mypage/goodsRefund"; }

    @GetMapping("ploggingRefund")
    public String ploggingRefund(){ return "mypage/ploggingRefund"; }

    @GetMapping("deliveryTracking")
    public String deliveryTracking(){ return "mypage/deliveryTracking"; }

    @GetMapping("/pageframe/header")
    public String header() {
        return "/pageframe/header";
    }

    @GetMapping("/pageframe/footer")
    public String footer() {
        return "/pageframe/footer";
    }

}
