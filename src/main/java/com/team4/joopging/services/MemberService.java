package com.team4.joopging.services;

import com.team4.joopging.member.memberVO.MemberVO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    /*아이디 중복 체크*/
    public int memberIdCheck(MemberVO vo);
    /*회원 가입*/
    public void memberJoin(MemberVO vo);
    /*카카오 회원 가입*/
    public void memberJoinKAKAO(MemberVO vo);
    /*네이버 회원 가입*/
    public void memberJoinNAVER(MemberVO vo);
    /*로그인*/
    public int memberLogin(MemberVO vo);
    /*카카오로그인*/
    public int memberLoginKAKAO(MemberVO vo);
    /*네이버로그인*/
    public int memberLoginNAVER(MemberVO vo);
    /*아이디 찾기*/
    public String memberSearchId(MemberVO vo);
    /*비밀번호 검색*/
    public String memberSearchPw(MemberVO vo);
    /*비밀번호 변경*/
    public void memberUpdatePw(MemberVO vo);
    /*회원정보 전체 조회*/
    public MemberVO memberAllSelect(String id);
    /*네이버 카카오 일반 회원의 이름 조회*/
    public MemberVO memberInfo(String id);
}
