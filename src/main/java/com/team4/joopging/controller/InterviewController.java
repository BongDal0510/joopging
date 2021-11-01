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
    @GetMapping("interviewMain")
    public String main() { return "/interview/interviewMain"; }

    @GetMapping("interviewRead")
    public String read() { return "/interview/interviewRead";}

    /*admin 계정일 경우에만 등록가능*/
    @GetMapping("interviewRegister")
    public String eventRegister() { return "/interview/interviewRegister"; }

    /*admin 계정일 경우에만 수정가능*/
    @GetMapping("interviewModify")
    public String eventModify() { return "/interview/interviewModify"; }


    @GetMapping("inquiry")
    public String inquiry() { return "/inquiry/inquiry";}

    @GetMapping("/pageframe/header")
    public String header() {
        return "/pageframe/header";
    }

    @GetMapping("/pageframe/footer")
    public String footer() {
        return "/pageframe/footer";
    }

}
