package com.team4.joopging.services;

import com.team4.joopging.member.memberDAO.MemberDAO;
import com.team4.joopging.member.memberVO.MemberVO;
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
    public void memberJoinKAKAO(MemberVO vo) {
        memberDAO.memberJoinKAKAO(vo);
    }

    @Override
    public void memberJoinNAVER(MemberVO vo) {
        memberDAO.memberJoinNAVER(vo);
    }

    @Override
    public int memberLogin(MemberVO vo) {
        return memberDAO.memberLogin(vo);
    }

    @Override
    public int memberLoginKAKAO(MemberVO vo) {
        return memberDAO.memberLoginKAKAO(vo);
    }

    @Override
    public int memberLoginNAVER(MemberVO vo) {
        return memberDAO.memberLoginNAVER(vo);
    }

    @Override
    public String memberSearchId(MemberVO vo) {
        return memberDAO.memberSearchId(vo);
    }

    @Override
    public String memberSearchPw(MemberVO vo) {
        return memberDAO.memberSearchPw(vo);
    }

    @Override
    public void memberUpdatePw(MemberVO vo) {
        memberDAO.memberUpdatePw(vo);
    }

    @Override
    public MemberVO memberAllSelect(String id) {
        return memberDAO.memberAllSelect(id);
    }

    /*아이디로 이름 조회하기 : 카카오, 네이버, 일반 회원 모두 사용 가능*/
    @Override
    public MemberVO memberInfo(String id) {
        /*아이디의 길이가 16자 이상일 때*/
        if(id.length() > 16){
            return memberDAO.userNameNAVER(id);
        }
        /*아이디의 길이가 10자 일 때*/
        if(id.length()==10){
            return memberDAO.userNameKAKAO(id);
        }else if(memberDAO.userNameKAKAO(id) == null){ //카카오 검색 실패했을 때
            return memberDAO.userName(id);
        }else{
            /*에러*/
            return null;
        }
    }
}
