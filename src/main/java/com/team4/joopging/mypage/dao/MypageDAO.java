package com.team4.joopging.mypage.dao;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mappers.MypageMapper;
import com.team4.joopging.mypage.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MypageDAO {

    private final MypageMapper mapper;

    /*플로깅 내역 출력*/
    public List<PloResVO> getPloResList(int memberNum, Criteria criteria){
        return mapper.getPloResList(memberNum, criteria);
    }

    /*플로깅 내역 토탈*/
    public int totalPloResCnt(int memberNum){
        return mapper.totalPloResCnt(memberNum);
    }

    /*찜목록 출력*/
    public List<GoodsLikeListVO> getGoodsLikeList(int memberNum, Criteria criteria){
        return mapper.getGoodsLikeList(memberNum, criteria);
    }

    /*찜목록 토탈*/
    public int totalGoodsLikeCnt(int memberNum){
        return mapper.totalGoodsLikeCnt(memberNum);
    }

    /*플로깅 취소(예약 번호로)*/
    public boolean deletePloRes(Long ploResNum){
        return mapper.deletePloRes(ploResNum) == 1;
    }

    /*회원정보 수정*/
    public boolean updateMember(TempMemberVO vo){
        return mapper.updateMember(vo) == 1;
    }

    /*회원정보 탈퇴*/
    public boolean deleteMember(String memberId, String memberPw){
        return mapper.deleteMember(memberId, memberPw) == 1;
    }

    /*아이디로 회원 번호 가져오기*/
    public int selectMemberNum(String memberId){ return mapper.selectMemberNum(memberId);
    }
}
