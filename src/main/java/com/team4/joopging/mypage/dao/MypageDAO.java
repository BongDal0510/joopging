package com.team4.joopging.mypage.dao;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mappers.MypageMapper;
import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.mypage.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MypageDAO {

    private final MypageMapper mapper;

    /*예약번호로 플로깅 찾기*/
    public TempPloResVO getPloRes(Long ploResNum){
        return mapper.getPloRes(ploResNum);
    };

    /*플로깅 내역 출력*/
    public List<TempPloResVO> getPloResList(int memberNum, Criteria criteria){
        return mapper.getPloResList(memberNum, criteria);
    }

    /*플로깅 내역 토탈*/
    public int totalPloResCnt(int memberNum){
        return mapper.totalPloResCnt(memberNum);
    }

    /*플로깅 현재 예약 건수*/
    public int realTotalPloResCnt(int memberNum){
        return mapper.realTotalPloResCnt(memberNum);
    }

    /*찜목록 출력*/
    public List<TempGoodsLikeListVO> getGoodsLikeList(int memberNum, Criteria criteria){
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

    /*찜목록 삭제*/
    public boolean deleteGoodsLike(int goodsLikeNum){
         return mapper.deleteGoodsLike(goodsLikeNum)==1;
    };

    /*회원정보 수정*/
    public boolean updateMember(MemberVO vo){
        return mapper.updateMember(vo) == 1;
    }

    /*회원정보 탈퇴*/
    public boolean deleteMember(String memberId, String memberPw){
        return mapper.deleteMember(memberId, memberPw) == 1;
    }

    /*내 게시글*/
    public List<CommuVO> getMemberCommuList(String memberId, Criteria criteria){
        return mapper.getMemberCommuList(memberId, criteria);
    };

    /*아이디로 회원 번호 가져오기*/
    public int selectMemberNum(String memberId){ return mapper.selectMemberNum(memberId);
    }
}