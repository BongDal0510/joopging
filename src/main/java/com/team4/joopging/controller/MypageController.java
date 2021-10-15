package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/mainpage/*")
@RequiredArgsConstructor
public class MypageController {

    @GetMapping("mainpage")
    public String mainpage(){
        return "mainpage";
    }
}
