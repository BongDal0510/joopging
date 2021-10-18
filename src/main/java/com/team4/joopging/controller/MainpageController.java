package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainpageController {

    @GetMapping("mainpage")
    public String mainpage() {
        return "mainpage";
    }

    @GetMapping("header")
    public String header() {
        return "header";
    }

    @GetMapping("footer")
    public String footer() {
        return "footer";
    }

    @GetMapping("event")
    public String event() {
        return "event";
    }

    @GetMapping("cs")
    public String cs() {
        return "cs";
    }

    @GetMapping("eventInfo")
    public String eventInfo() {
        return "eventInfo";
    }
}