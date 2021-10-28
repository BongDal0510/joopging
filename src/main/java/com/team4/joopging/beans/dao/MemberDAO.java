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

    /*로그인*/
    public int memberLogin(MemberVO vo){
        return mapper.login(vo);
    }
}
