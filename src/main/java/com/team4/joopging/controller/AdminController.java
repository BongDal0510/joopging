package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("admin")
    public String adminMain() { return "/admin/admin"; }

    //헤더
    @GetMapping("/pageframe/header")
    public String header() {
        return "/pageframe/header";
    }

    //푸터
    @GetMapping("/pageframe/footer")
    public String footer() {
        return "/pageframe/footer";
    }


}