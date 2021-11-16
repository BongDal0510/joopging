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

    @GetMapping("/mainpage")
    public String mainpage() {
        return "/main/mainpage";
    }

    @GetMapping("cs")
    public String cs() {
        return "/main/cs";
    }

    @GetMapping("/pageframe/header")
    public String header() {
        return "/pageframe/header";
    }

    @GetMapping("/pageframe/footer")
    public String footer() {
        return "/pageframe/footer";
    }

    @GetMapping("/terms")
    public String terms() {
        return "/pageframe/terms";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "/pageframe/privacy";
    }

}