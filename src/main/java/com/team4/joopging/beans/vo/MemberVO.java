package com.team4.joopging.beans.vo;

//--------------------------필수사항
//아이디 member_id
//비밀번호 member_pw
//이름 member_name
//생년월일 member_birth
//성별 member_gender
//--------------------------선택사항
//메일 member_email_id
//우편번호 member_zipcode
//주소 member_address
//상세주소 member_address_detail
//참고항목 member_address_etc

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private String member_id;
    private String member_pw;
    private String member_name;
    private String member_birth;
    private String member_gender;
    private String member_email_id;
    private String member_zipcode;
    private String member_address;
    private String member_address_detail;
    private String member_address_etc;


}
