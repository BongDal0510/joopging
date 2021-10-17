package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*성윤 : 회원 관련 기능 컨트롤러*/
@Controller
@Slf4j
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class memberController {

    /*아무 연산 없이 로그인 페이지로 이동*/
    @GetMapping("login")
    public String login(){
        return "login";
    }

    /*로그인 페이지에서 회원가입 버튼 누르기*/
    @PostMapping("join")
    public String join(){
        return "join";
    }

    @GetMapping("header")
    public String header() {
        return "header";
    }

    @GetMapping("footer")
    public String footer() {
        return "footer";
    }

    @GetMapping("findId")
    public String findId(){
        return "findId";
    }

    @GetMapping("findPw")
    public String findPw(){
        return "findPw";
    }

    @GetMapping("searchId")
    public String searchId(){
        return "searchId";
    }
}
