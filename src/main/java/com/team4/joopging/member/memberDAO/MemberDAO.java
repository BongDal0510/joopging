package com.team4.joopging.member.memberDAO;

import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.mappers.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper mapper;

    /*아이디 중복 체크*/
    public int memberIdCheck(MemberVO vo) { return mapper.idCheck(vo); }

    /*회원가입*/
    public void memberJoin(MemberVO vo){
        mapper.join(vo);
    }
    /*카카오 회원가입*/
    public void memberJoinKAKAO(MemberVO vo){
        mapper.joinKAKAO(vo);
    }
    /*카카오 회원가입*/
    public void memberJoinNAVER(MemberVO vo){
        mapper.joinNAVER(vo);
    }

    /*로그인*/
    public int memberLogin(MemberVO vo){
        return mapper.login(vo);
    }
    /*카카오로그인*/
    public int memberLoginKAKAO(MemberVO vo){
        return mapper.loginKAKAO(vo);
    }
    /*카카오로그인*/
    public int memberLoginNAVER(MemberVO vo){
        return mapper.loginNAVER(vo);
    }

    /*아이디 찾기*/
    public String memberSearchId(MemberVO vo){ return mapper.searchId(vo); }

    /*비밀번호 검색*/
    public String memberSearchPw(MemberVO vo){return mapper.searchPw(vo); }

    /*비밀번호 변경*/
    public void memberUpdatePw(MemberVO vo){ mapper.updatePw(vo); }

    /*회원정보 전체 조회*/
    public MemberVO memberAllSelect(String id){ return mapper.allSelect(id); }

    /* 출석체크 */
    public int memberAttendUpdate(String id) { return mapper.attendUpdate(id); }

    /* 출석회수 조회 */
    public int memberGetAttendCnt(String id) { return mapper.getAttendCnt(id); }

    /* 매일 0시 마다 출석상태 초기화 */
    public int memberResetAttendStatus() { return mapper.resetAttendStatus(); }

    /* 출석회수 10회일 경우 0으로 초기화 */
    public int memberResetAttendCnt() { return mapper.resetAttendCnt(); }

    /* 포인트 추가 */
    public int memberPointUpdate(MemberVO memberVO) { return mapper.pointUpdate(memberVO); }

    /*네이버 카카오 일반 회원의 이름 조회*/
    public MemberVO userName(String id){return mapper.userName(id); }
    public MemberVO userNameKAKAO(String id){return mapper.userNameKAKAO(id); }
    public MemberVO userNameNAVER(String id){return mapper.userNameNAVER(id); }

    /*로그인 시 회원 탈퇴 여부 판단*/
    public int loginStatus(String id){ return mapper.loginStatus(id); }
}
