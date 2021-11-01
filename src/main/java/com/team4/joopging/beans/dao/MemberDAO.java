package com.team4.joopging.beans.dao;

import com.team4.joopging.beans.vo.MemberVO;
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

    /*로그인*/
    public int memberLogin(MemberVO vo){
        return mapper.login(vo);
    }
    /*카카오로그인*/
    public int memberLoginKAKAO(MemberVO vo){
        return mapper.loginKAKAO(vo);
    }

    /*아이디 찾기*/
    public String memberSearchId(MemberVO vo){ return mapper.searchId(vo); }

    /*비밀번호 검색*/
    public String memberSearchPw(MemberVO vo){return mapper.searchPw(vo); }

    /*비밀번호 변경*/
    public void memberUpdatePw(MemberVO vo){ mapper.updatePw(vo); }

    /*회원정보 전체 조회*/
    public MemberVO memberAllSelect(MemberVO vo){ return mapper.allSelect(vo); }
}
