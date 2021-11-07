package com.team4.joopging.mypage.dao;

import com.team4.joopging.beans.vo.ShopVO;
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
    public List<TempPloResVO> getPloResList(String memberId){
        return mapper.getPloResList(memberId);
    }

    /*플로깅 내역 토탈*/
    public int totalPloResCnt(String memberId){
        return mapper.totalPloResCnt(memberId);
    }

    /*플로깅 현재 예약 건수*/
    public int realTotalPloResCnt(String memberId){
        return mapper.realTotalPloResCnt(memberId);
    }

    /*찜목록 출력*/
    public List<ShopVO> getGoodsLikeList(String memberId){
        return mapper.getGoodsLikeList(memberId);
    }

    /*찜목록 토탈*/
    public int totalGoodsLikeCnt(String memberId){
        return mapper.totalGoodsLikeCnt(memberId);
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
        return mapper.deleteMember(memberId,memberPw) == 1;
    }

    /*내 게시글*/
    public List<CommuVO> getMemberCommuList(String memberId){
        return mapper.getMemberCommuList(memberId);
    };
    /*내 게시글 전체 개수*/
    public int totalMemberCommuCnt(String memberId){
        return mapper.totalMemberCommuCnt(memberId);
    };

    /*아이디로 회원 번호 가져오기*/
    public int selectMemberNum(String memberId){ return mapper.selectMemberNum(memberId);
    }
    /*플로깅 리스트 가져오기-플로깅 생기면 지워!*/
    public List<TempPloggingVO> getPloggingList(){
        return mapper.getPloggingList();
    }
}
