package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/interview/*")
@RequiredArgsConstructor
public class InterviewController {
    @GetMapping("main")
    public String main() { return "interview/main";
    }

    @GetMapping("read")
    public String read() {
        return "interview/read";
    }

    @GetMapping("adminModify")
    public String adminModify() {
        return "interview/adminModify";
    }

    @GetMapping("adminRegister")
    public String adminRegister() {
        return "interview/adminRegister";
    }

    @GetMapping("admin")
    public String admin() {
        return "interview/admin";
    }
}
