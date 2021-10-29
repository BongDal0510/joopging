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
    private int memberNum;
    private String memberId;
    private String memberPw;
    private String memberPhone;
    private String memberName;
    private String memberBirth;
    private int memberGender;
    private String memberEmail;
    private String memberRegidate;
    private String memberZipcode;
    private String memberAddress;
    private int memberPloggingCnt;
    private int memberPoint;
    private int memberSavedPoint;
    private int memberAttend;
    private int memberLevel;
    private int status;
}
