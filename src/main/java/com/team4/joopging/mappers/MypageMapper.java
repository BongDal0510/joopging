package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mypage.vo.GoodsLikeListVO;
import com.team4.joopging.mypage.vo.TempMemberVO;
import com.team4.joopging.mypage.vo.PloResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {

    /*예약번호로 플로깅 찾기*/
    public PloResVO getPloRes(Long ploResNum);
    /*플로깅 예약 목록*/
    public List<PloResVO> getPloResList(int memberNum, Criteria criteria);
    /*플로깅 내역 토탈*/
    public int totalPloResCnt(int memberNum);
    /*플로깅 내역 개수*/
    public int realTotalPloResCnt(int memberNum);
    /*찜 목록*/
    public List<GoodsLikeListVO> getGoodsLikeList(int memberNum, Criteria criteria);
    /*찜목록 토탈*/
    public int totalGoodsLikeCnt(int memberNum);
    /*내가 작성한 게시판 목록*/
    public List<CommuVO> getMemberCommuList(String memberId, Criteria criteria);
    /*내가 작성한 1:1문의 목록*/
    public List<CommuVO> getMyQueList(int memberNum, Criteria criteria);
    /*플로깅 예약 취소*/
    public int deletePloRes(Long ploResNum);
    /*찜목록 삭제*/
    public int deleteGoodsLike(int goodsLikeNum);
    /*세션 아이디로 세션 넘 찿기*/
    public int selectMemberNum(String id);
    /*회원정보 수정*/
    public int updateMember(TempMemberVO vo);
    /*회원정보 탈퇴*/
    public int deleteMember(String memberId, String memberPw);
}