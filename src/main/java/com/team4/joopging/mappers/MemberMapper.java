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
    /* 출석체크 */
    public int attendUpdate(String id);
    /* 출석회수 조회 */
    public int getAttendCnt(String id);
    /* 매일 0시 마다 출석상태 초기화 */
    public void resetAttendStatus();
    /* 출석회수 10회일 경우 0으로 초기화 */
    public void resetAttendCnt();
    /* 매월 1일 마다 멤버레벨 승급 */
    public void updateLevelAmateur();
    public void updateLevelVeteran();
    public void updateLevelMaster();
    /* 포인트 추가 */
    public int pointUpdate(MemberVO memberVO);
    /*네이버 카카오 일반 회원의 이름 조회*/
    public MemberVO userName(String id);
    public MemberVO userNameKAKAO(String id);
    public MemberVO userNameNAVER(String id);
    /*로그인 시 회원 탈퇴 여부 판단*/
    public int loginStatus(String id);
}
