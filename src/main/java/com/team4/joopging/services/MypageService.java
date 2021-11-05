package com.team4.joopging.services;

import com.team4.joopging.beans.vo.ShopVO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.mypage.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MypageService {
    /*넘버로 예약한 플로깅 찾기*/
    public TempPloResVO getPloRes(Long ploResNum);

    /*내 플로깅 내역 출력*/
    public List<TempPloResVO> getPloResList(int memberNum, Criteria criteria);

    /*내 플로깅 내역 토탈 개수*/
    public int totalPloResCnt(int memberNum);

    /*내 플로깅 현재 예약 건수*/
    public int realTotalPloResCnt(int memberNum);

    /*찜목록 출력*/
    public List<ShopVO> getGoodsLikeList(int memberNum, Criteria criteria);

    /*찜목록 토탈*/
    public int totalGoodsLikeCnt(int memberNum);

    /*플로깅 취소(예약 번호로)*/
    public boolean deletePloRes(Long ploResNum);

    /*찜목록 삭제*/
    public boolean deleteGoodsLike(int goodsLikeNum);

    /*회원정보 수정*/
    public boolean updateMember(MemberVO vo);

    /*회원정보 탈퇴*/
    public boolean deleteMember(String memberId, String memberPw);

    /*내 게시글*/
    public List<CommuVO> getMemberCommuList(String memberId, Criteria criteria);

    /*내 게시글 개수*/
    public int totalMemberCommuCnt(String memberId);

    /*아이디로 회원번호 가져오기*/
    public int selectMemberNum(String memberId);

    /*구매 상품 내역 출력(아이디로)*/
    public List<TempOrderHistoryVO> getOrderHistoryList(int memberNum, Criteria criteria);

    /*구매 상품 정보*/
    public TempOrderHistoryVO getOrderHistory(int orderNum);

    /*구매한 상품 토탈*/
    public int totalOrderCnt(int memberNum);

    /*구매한 상품 토탈*/
    public int realTotalOrderCnt(int memberNum);

    /*택배 정보 출력(구매상품번호로)*/
    public TempParcelVO getParcel(int orderNum);

    /*구매 상품 취소(상품 번호로)*/
    public boolean deleteGoodsOrder(int orderNum);

    /*구매취소된 상품 불러오기*/
    public List<TempOrderHistoryVO> deletOrderList();
}
