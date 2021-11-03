package com.team4.joopging.mappers;

import com.team4.joopging.member.memberVO.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    /*아이디 중복 체크*/
    public int idCheck(MemberVO memberVO);
    /*회원 가입*/
    public void join(MemberVO memberVO);
    /*카카오 회원 가입*/
    public void joinKAKAO(MemberVO memberVO);
    /*네이버 회원 가입*/
    public void joinNAVER(MemberVO memberVO);
    /*로그인*/
    public int login(MemberVO memberVO);
    /*카카오로그인*/
    public int loginKAKAO(MemberVO memberVO);
    /*네이버로그인*/
    public int loginNAVER(MemberVO memberVO);
    /*아이디 찾기*/
    public String searchId(MemberVO memberVO);
    /*비밀번호 검색*/
    public String searchPw(MemberVO memberVO);
    /*비밀번호 변경*/
    public void updatePw(MemberVO memberVO);
    /*회원정보 전체 조회*/
    public MemberVO allSelect(String id);
}
