package com.team4.joopging.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/shop/*")
@RequiredArgsConstructor
public class shopController {


    /*아무 연산 없이 샵 페이지로 이동*/
    @GetMapping("shop")
    public String shop(){
        return "shop";
    }

    @GetMapping("shopEnroll")
    public String shopEnroll(){
        return "shopEnroll";
    }

    @GetMapping("shopDetail")
    public String shopDetail() {return "shopDetail";}

    @GetMapping("successPayment")
    public String successPayment() {return "successPayment";}

    @GetMapping("failPayment")
    public String failPayment() {return "failPayment";}

    @GetMapping("/pageframe/header")
    public String header() {
        return "/pageframe/header";
    }

    @GetMapping("/pageframe/footer")
    public String footer() {
        return "/pageframe/footer";
    }





}



