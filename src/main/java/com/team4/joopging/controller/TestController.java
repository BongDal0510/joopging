package com.team4.joopging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/test/*")
public class TestController {

    @GetMapping("eventWrite")
    public String eventWrite(){
        return "eventWrite";
    }

    @GetMapping("ploggingWrite")
    public String ploggingWrite(){
        return "ploggingWrite";
    }

    @GetMapping("gotest")
    public String gotest(){
        return "test";
    }


}
