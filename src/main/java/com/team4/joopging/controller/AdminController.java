package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {

    @GetMapping("admin")
    public String adminMain(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession();
        String memberId = (String) session.getAttribute("memberId");

        if (session.getAttribute("memberId") == "admin") {
            return "/admin/admin";
        } else {
           model.addAttribute("msg", "notadmin");
           return "main/mainpage";
        }
    }

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
