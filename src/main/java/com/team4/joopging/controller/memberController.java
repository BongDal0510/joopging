package com.team4.joopging.controller;

//import net.nurigo.java_sdk.api.Message;
//import net.nurigo.java_sdk.exceptions.CoolsmsException;
//import org.json.simple.JSONObject;
import com.team4.joopging.beans.vo.MemberVO;
import com.team4.joopging.services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Random;

/*성윤 : 회원 관련 기능 컨트롤러*/
@Controller
@Slf4j
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class memberController {

    private final MemberService memberService;


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

    /*아이디 중복 체크*/
    @PostMapping("checkId")
    @ResponseBody
    public int checkId(@RequestParam("id") String id){
        MemberVO vo = new MemberVO();
        vo.setMemberId(id);
        int result = memberService.memberIdCheck(vo);
        return result;
    }

    /*로그인하기 : 회원정보 조회 연산 필요*/
    @PostMapping("login")
    public String loginAction(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr){
        HttpSession session = req.getSession();
        /*연산 작업*/
        if(memberService.memberLogin(vo) != 0){
            /*로그인 성공*/
            String id = vo.getMemberId();
            session.setAttribute("memberId",id);
            return "/mainpage";
        }else{
            /*로그인 실패*/
            return "member/loginFail";
        }
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

    /*카카오 로그인하기 : 회원정보 조회 연산 필요*/
    @PostMapping("loginKAKAO")
    public String loginKAKAOAction(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr){
        HttpSession session = req.getSession();
        String id = vo.getMemberId();

        /*연산 작업*/
        if(memberService.memberLoginKAKAO(vo) != 0){
            /*로그인 성공*/
            session.setAttribute("memberId",id);
            return "/mainpage";
        }else{
            /*로그인 실패시 디비 입력 후 성공*/
            memberService.memberJoinKAKAO(vo);
            session.setAttribute("memberId",id);
            return "/mainpage";
        }
    }

    /*로그인 페이지에서 회원가입 버튼 누르기*/
    @GetMapping("join")
    public String join() {
        return "member/join";
    }

    /*회원 가입*/
    @PostMapping("memberJoin")
    public String memberjoin(MemberVO vo, String memberEmailSite, String memberAddressDetail){
        /*디비에 회원정보 저장*/
        vo.setMemberEmail(vo.getMemberEmail()+ "@" + memberEmailSite);
        vo.setMemberAddress(vo.getMemberAddress() + " " + memberAddressDetail);
        memberService.memberJoin(vo);
        /*회원 가입 후 로그인 페이지 이동*/
        return "member/login";
    }

    /*아이디 찾기 버튼 클릭*/
    @GetMapping("findId")
    public String findId() {
        return "member/findId";
    }

    /*아이디 찾기 SMS 인증 페이지*/
    @PostMapping("searchId")
    public String searchId(MemberVO vo, Model model) {
        /*난수 메소드 사용*/
        String str = random();
        /*모델에 난수 담아주기*/
        model.addAttribute("random", str);

        /*데이터베이스 조회*/
        if(memberService.memberSearchId(vo) == null){
            model.addAttribute("result", "회원가입되지 않은 사용자입니다.");
        }else{
            model.addAttribute("result", memberService.memberSearchId(vo));
        }

//      내돈 20원.......
//      SMS보내기 메소드 주석풀면 돈나감
//      SendSMS(str, phone);

        return "member/searchId";
    }

    /*아이디 결과 띄워주기(연산)*/
    @GetMapping("resultFindId")
    public String resultFindId(String result, Model model){
        model.addAttribute("result", result);
        return "member/resultFindId";
    }

    @GetMapping("findPw")
    public String findPw() {
        return "member/findPw";
    }

    @PostMapping("searchPw")
    public String searchPw(MemberVO vo, Model model){
        /*난수 메소드 사용*/
        String str = random();
        /*모델에 난수 담아주기*/
        model.addAttribute("random", str);

        /*데이터베이스 조회*/
        if(memberService.memberSearchId(vo) == null){
            model.addAttribute("result", "fail");
        }else{
            model.addAttribute("result", memberService.memberSearchPw(vo));
        }

        return "member/searchPw";
    }

    @PostMapping("resultRePw")
    public String resultRePw(MemberVO vo, Model model){
        model.addAttribute("result", vo.getMemberId());
        return "member/resultRePw";
    }

    @PostMapping("rePassWordResult")
    public String rePassWordResult(MemberVO vo, Model model){
        /*비밀번호 수정 쿼리문*/
        try {
            memberService.memberUpdatePw(vo);
            model.addAttribute("result", "success");
        } catch (Exception e) {
            model.addAttribute("result", "fail");
        }
        return "member/rePassWordResult";
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

    /*랜덤 난수 6자리 생성*/
    private String random(){
        Random rand = new Random();
        String str = ""; //난수가 저장될 변수

        for(int i=0;i<6;i++) {
            String ran = Integer.toString(rand.nextInt(10));
            str += ran;
        }
        return str;
    }

//    특정 회원 전체 정보 조회
    @PostMapping("allSelect")
    public void allSelect(MemberVO vo){
        vo = memberService.memberAllSelect(vo);
        log.info(vo.toString());
    }

//    여기부터 플로깅 예약 관련 컨트롤러
    @GetMapping("ploggingReservationList")
    public String ploggingReservationList(){
        return "ploggingReservation/ploggingReservationList";
    }

    @GetMapping("ploggingReservationInfo")
    public String ploggingReservationInfo(){
        return "ploggingReservation/ploggingReservationInfo";
    }

}
