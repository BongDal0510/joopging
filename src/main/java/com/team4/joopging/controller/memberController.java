package com.team4.joopging.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import net.nurigo.java_sdk.api.Message;
//import net.nurigo.java_sdk.exceptions.CoolsmsException;
//import org.json.simple.JSONObject;
import org.apache.logging.log4j.message.Message;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/*성윤 : 회원 관련 기능 컨트롤러*/
@Controller
@Slf4j
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class memberController {
    /*헤더, 푸터*/
    @GetMapping("header")
    public String header() {
        return "header";
    }
    @GetMapping("footer")
    public String footer() {
        return "footer";
    }

    /*플로깅 소개 페이지*/
    @GetMapping("ploggingInfo")
    public String ploggingInfo(){
        return "ploggingReservation/ploggingInfo";
    }

    /*이용약관 페이지*/
    @GetMapping("terms")
    public String terms(){
        return "member/terms";
    }

    /*아무 연산 없이 로그인 페이지로 이동*/
    @GetMapping("login")
    public String login() {
        return "member/login";
    }

    /*로그인하기 : 회원정보 조회 연산 필요*/
    @PostMapping("login")
    public String loginAction(){
        /*연산 작업*/

        return "/mainpage";
    }

    /*로그인 페이지에서 회원가입 버튼 누르기*/
    @GetMapping("join")
    public String join() {
        return "member/join";
    }

    /*아이디 찾기 버튼 클릭*/
    @GetMapping("findId")
    public String findId() {
        return "member/findId";
    }

    /*아이디 찾기 SMS 인증 페이지*/
    @PostMapping("searchId")
    public String searchId(@RequestParam("memberPhone") String phone, Model model) {
      String str = "123456";

      log.info(phone);

//      내돈 20원.......
//      SMS보내기 메소드 주석풀면 돈나감
//      SendSMS(str, phone);
        
	  model.addAttribute("random", str);

      return "member/searchId";
    }

    /*아이디 결과 띄워주기(연산)*/
    @GetMapping("resultFindId")
    public String resultFindId(){
        return "member/resultFindId";
    }

    @GetMapping("findPw")
    public String findPw() {
        return "member/findPw";
    }





    /*쿨 SMS API*/
    private void SendSMS(String str, String phone) {
        String api_key = "NCSDZERXIZUFDHUU";
        String api_secret = "IOM3ZQSFYIDMEQIBWFBB5OOHNIEXITWQ";
//        Message coolsms = new Message(api_key, api_secret) {
//        };

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", phone);
        params.put("from", "01064718102");
        params.put("type", "SMS");
        params.put("text", str);
        params.put("app_version", "test app 1.2"); // application name and version

//        try {
//            JSONObject obj = (JSONObject) coolsms.send(params);
//            System.out.println(obj.toString());
//        } catch(CoolsmsException e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.getCode());
//        }
    }
}
