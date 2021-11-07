package com.team4.joopging.mappers;

import com.team4.joopging.beans.vo.ShopVO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.mypage.vo.TempGoodsLikeListVO;
import com.team4.joopging.mypage.vo.TempPloResVO;
import com.team4.joopging.mypage.vo.TempPloggingVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MypageMapper {

    /*예약번호로 플로깅 찾기*/
    public TempPloResVO getPloRes(Long ploResNum);
    /*플로깅 예약 목록*/
    public List<TempPloResVO> getPloResList(String memberId);
    /*플로깅 내역 토탈*/
    public int totalPloResCnt(String memberId);
    /*플로깅 내역 개수*/
    public int realTotalPloResCnt(String memberId);
    /*찜 목록*/
    public List<ShopVO> getGoodsLikeList(String memberId);
    /*찜목록 토탈*/
    public int totalGoodsLikeCnt(String memberId);
    /*내가 작성한 게시판 목록*/
    public List<CommuVO> getMemberCommuList(String memberId);
    /*내 게시글 전체 개수*/
    public int totalMemberCommuCnt(String memberId);
    /*내가 작성한 1:1문의 목록*/
    public List<CommuVO> getMyQueList(String memberId);
    /*플로깅 예약 취소*/
    public int deletePloRes(Long ploResNum);
    /*찜목록 삭제*/
    public int deleteGoodsLike(int goodsLikeNum);
    /*세션 아이디로 세션 넘 찿기*/
    public int selectMemberNum(String id);
    /*회원정보 수정*/
    public int updateMember(MemberVO vo);
    /*회원정보 탈퇴*/
    public int deleteMember(String memberId, String memberPw);
    /*플로깅 리스트*/
    public List<TempPloggingVO> getPloggingList();

}