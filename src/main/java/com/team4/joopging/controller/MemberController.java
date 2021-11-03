package com.team4.joopging.controller;

/*쿨 SMS*/
//import net.nurigo.java_sdk.api.Message;
//import net.nurigo.java_sdk.exceptions.CoolsmsException;
//import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.services.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/*성윤 : 회원 관련 기능 컨트롤러*/
@Controller
@Slf4j
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /*헤더, 푸터*/
    @GetMapping("/pageframe/header")
    public String header() {
        return "/pageframe/header";
    }

    @GetMapping("/pageframe/footer")
    public String footer() {
        return "/pageframe/footer";
    }

    /*플로깅 소개 페이지*/
    @GetMapping("ploggingInfo")
    public String ploggingInfo() {
        return "ploggingReservation/ploggingInfo";
    }

    /*이용약관 페이지*/
    @GetMapping("terms")
    public String terms() {
        return "member/terms";
    }

    /*이용약관 페이지*/
    @GetMapping("privacy")
    public String privacy() {
        return "member/privacy";
    }

    /*아무 연산 없이 로그인 페이지로 이동*/
    @GetMapping("login")
    public String login() {
        return "member/login";
    }

    /*아이디 중복 체크*/
    @PostMapping("checkId")
    @ResponseBody
    public int checkId(@RequestParam("id") String id) {
        MemberVO vo = new MemberVO();
        vo.setMemberId(id);
        int result = memberService.memberIdCheck(vo);
        return result;
    }

    /*로그인하기 : 회원정보 조회 연산 필요*/
    @PostMapping("login")
    public String loginAction(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) {
        HttpSession session = req.getSession();
        /*연산 작업*/
        if (memberService.memberLogin(vo) != 0) {
            /*로그인 성공*/
            String id = vo.getMemberId();
            session.setAttribute("memberId", id);
            return "/mainpage";
        } else {
            /*로그인 실패*/
            return "member/loginFail";
        }
    }

    /*로그아웃*/
    @GetMapping("logout")
    public RedirectView logout(HttpSession session) {
        session.invalidate();
        return new RedirectView("mainpage");
    }

    @GetMapping("mainpage")
    public String mainpage() {
        return "/mainpage";
    }

    /*카카오 로그인하기 : 회원정보 조회 연산 필요*/
    @PostMapping("loginKAKAO")
    public String loginKAKAOAction(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) {
        HttpSession session = req.getSession();
        String id = vo.getMemberId();

        /*연산 작업*/
        if (memberService.memberLoginKAKAO(vo) != 0) {
            /*로그인 성공*/
            session.setAttribute("memberId", id);
            return "/mainpage";
        } else {
            /*로그인 실패시 디비 입력 후 성공*/
            memberService.memberJoinKAKAO(vo);
            session.setAttribute("memberId", id);
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
    public String memberjoin(MemberVO vo, String memberEmailSite, String memberAddressDetail) {
        /*디비에 회원정보 저장*/
        vo.setMemberEmail(vo.getMemberEmail() + "@" + memberEmailSite);
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
        if (memberService.memberSearchId(vo) == null) {
            model.addAttribute("result", "회원가입되지 않은 사용자입니다.");
        } else {
            model.addAttribute("result", memberService.memberSearchId(vo));
        }

//      내돈 20원.......
//      SMS보내기 메소드 주석풀면 돈나감
//      SendSMS(str, phone);

        return "/member/searchId";
    }

    /*아이디 결과 띄워주기(연산)*/
    @GetMapping("resultFindId")
    public String resultFindId(String result, Model model) {
        model.addAttribute("result", result);
        return "member/resultFindId";
    }

    /*비밀번호 찾기*/
    @GetMapping("findPw")
    public String findPw() {
        return "member/findPw";
    }

    /*비밀번호 찾기 sms인증*/
    @PostMapping("searchPw")
    public String searchPw(MemberVO vo, Model model) {
        /*난수 메소드 사용*/
        String str = random();
        /*모델에 난수 담아주기*/
        model.addAttribute("random", str);

        /*데이터베이스 조회*/
        if (memberService.memberSearchId(vo) == null) {
            model.addAttribute("result", "fail");
        } else {
            model.addAttribute("result", memberService.memberSearchPw(vo));
        }

        return "member/searchPw";
    }

    /*비밀번호 재설정 입력*/
    @PostMapping("resultRePw")
    public String resultRePw(MemberVO vo, Model model) {
        model.addAttribute("result", vo.getMemberId());
        return "member/resultRePw";
    }

    /*비밀번호 재설정 쿼리문*/
    @PostMapping("rePassWordResult")
    public String rePassWordResult(MemberVO vo, Model model) {
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
    private String random() {
        Random rand = new Random();
        String str = ""; //난수가 저장될 변수

        for (int i = 0; i < 6; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            str += ran;
        }
        return str;
    }

    /*로그인 창에서 네이버 로그인 진행*/
    /*login.html에서 요청*/
    @GetMapping("callback")
    public String callback() {
        return "/member/callback";
    }

    /*네이버 로그인 및 회원가입*/
    /*callback.html에서 요청*/
    /*네이버에서 총 4개의 메소드를 제공해주며 그중 메인메소드를 SpringBoot에 맞게 변경시켰다.*/
    @PostMapping("naverlogin")
    public String naverlogin(String token, MemberVO vo, String memberDay, HttpServletRequest req, RedirectAttributes rttr) throws ParseException {
        /*세션 객체 생성*/
        HttpSession session = req.getSession();

//        각 매개변수 출력
//        System.out.println(token);
//        System.out.println(vo.toString());
//        System.out.println(memberDay);

        String ACCESS_TOKEN = token; // 네이버 로그인 접근 토큰;
        String header = "Bearer " + ACCESS_TOKEN; // Bearer 다음에 공백 추가

        /*요청 URI 형식*/
        String apiURL = "https://openapi.naver.com/v1/nid/me";

        /*요청 양식에 맞게 변수에 값을 넣고*/
        /*get() 메소드(REST)를 통해 JSON형태의 String 값을 받는다.*/
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", header);
        String responseBody = get(apiURL, requestHeaders);

        /*String타입으로 전달받았기 때문에*/
        /*값을 사용하기 위해서 JSON 파싱이 필요하다.*/
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(responseBody);
        /*JSON안에 JSON을 접근하기 위해 한번 더 접근해주었다.*/
        JSONObject jsonObj = (JSONObject)obj;
        JSONObject jsonObj2 = (JSONObject)jsonObj.get("response");

        /*줍깅에서 필요한 데이터 테스트 출력*/
//        System.out.println(jsonObj2.get("id"));
//        System.out.println(jsonObj2.get("name"));
//        System.out.println(jsonObj2.get("email"));
//        System.out.println(jsonObj2.get("mobile"));
//        System.out.println(jsonObj2.get("gender"));
//        System.out.println(jsonObj2.get("birthyear")+"-"+jsonObj2.get("birthday"));

        /*???*/
//        vo.setMemberEmail(jsonObj2.get("email"));
//        System.out.println(jsonObj2.get("id"));

        /*연산 작업*/
        /*로그인의 경우, 카카오 혹은 네이버에서 로그인 성공을 하였기 때문에*/
        /*줍깅 페이지에서 로그인 실패의 처리는 없다.*/
        /*다만, 가입이 안된 상태일때 상대방이 정보 제공 동의를 한 상태이기 때문에*/
        /*해당 정보를 수집하고 데이터베이스에 저장해주기만 하면 된다.*/
        if(memberService.memberLoginNAVER(vo) != 0) {
            /*로그인 성공*/
            /*세션 생성*/
            session.setAttribute("memberId", jsonObj2.get("id"));
            return "/mainpage";
        } else {
            /*로그인 실패시 디비 입력 후 성공*/
            memberService.memberJoinNAVER(vo);
            /*세션 생성*/
            session.setAttribute("memberId", jsonObj2.get("id"));
            return "/mainpage";
        }
    }

    /*JSON 형식으로 되어있는 String 데이터 리턴*/
    private static String get(String apiUrl, Map<String, String> requestHeaders) {
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    /*내가 입력한 url의 유효성 검사*/
    private static HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    /*설정 메소드*/
    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}