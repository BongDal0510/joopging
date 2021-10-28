package com.team4.joopging.services;

import com.team4.joopging.beans.dao.MemberDAO;
import com.team4.joopging.beans.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImple implements MemberService{
    private final MemberDAO memberDAO;

    @Override
    public int memberIdCheck(MemberVO vo) {
        return memberDAO.memberIdCheck(vo);
    }

    @Override
    public void memberJoin(MemberVO vo) {
        memberDAO.memberJoin(vo);
    }

    @Override
    public int memberLogin(MemberVO vo) {
        return memberDAO.memberLogin(vo);
    }
}
