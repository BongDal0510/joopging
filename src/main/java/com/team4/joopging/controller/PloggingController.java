package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/plo/*")
@RequiredArgsConstructor
public class PloggingController {

    /*플로깅 소개페이지*/
    @GetMapping("info")
    public String info(){
        return "ploggingReservation/ploInfo";
    }
}
