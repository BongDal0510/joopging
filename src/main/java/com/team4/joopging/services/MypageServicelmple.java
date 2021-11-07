package com.team4.joopging.services;

import com.team4.joopging.beans.vo.ShopVO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.member.memberVO.MemberVO;
import com.team4.joopging.mypage.dao.MypageDAO;
import com.team4.joopging.mypage.dao.OrderHistoryDAO;
import com.team4.joopging.mypage.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MypageServicelmple implements MypageService{

    private final MypageDAO mDAO;
    private final OrderHistoryDAO oDAO;


    @Override
    public TempPloResVO getPloRes(Long ploResNum) {
        return mDAO.getPloRes(ploResNum);
    }

    @Override
    public List<TempPloResVO> getPloResList(String memberId){
        return mDAO.getPloResList(memberId);
    }

    @Override
    public int totalPloResCnt(String memberId) {
        return mDAO.totalPloResCnt(memberId);
    }

    @Override
    public int realTotalPloResCnt(String memberId) {
        return mDAO.realTotalPloResCnt(memberId);
    }

    @Override
    public List<ShopVO> getGoodsLikeList(String memberId) {
        return mDAO.getGoodsLikeList(memberId);
    }

    @Override
    public int totalGoodsLikeCnt(String memberId) {
        return mDAO.totalGoodsLikeCnt(memberId);
    }

    @Override
    public boolean deletePloRes(Long ploResNum) {
        return mDAO.deletePloRes(ploResNum);
    }

    @Override
    public boolean deleteGoodsLike(int goodsLikeNum) {
        return mDAO.deleteGoodsLike(goodsLikeNum);
    }

    @Override
    public boolean updateMember(MemberVO vo) {
        return mDAO.updateMember(vo);
    }

    @Override
    public boolean deleteMember(String memberId, String memberPw) {
        return mDAO.deleteMember(memberId, memberPw);
    }

    @Override
    public List<CommuVO> getMemberCommuList(String memberId) {
        return mDAO.getMemberCommuList(memberId);
    }

    @Override
    public int totalMemberCommuCnt(String memberId) {
        return mDAO.totalMemberCommuCnt(memberId);
    }

    @Override
    public int selectMemberNum(String memberId) {
        return mDAO.selectMemberNum(memberId);
    }

    @Override
    public List<TempOrderHistoryVO> getOrderHistoryList(String memberId) {
        return oDAO.getOrderHistoryList(memberId);
    }

    @Override
    public TempOrderHistoryVO getOrderHistory(int orderNum) {
        return oDAO.getOrderHistory(orderNum);
    }

    @Override
    public int totalOrderCnt(String memberId) {
        return oDAO.totalOrderCnt(memberId);
    }

    @Override
    public int realTotalOrderCnt(String memberId) {
        return oDAO.realTotalOrderCnt(memberId);
    }

    @Override
    public TempParcelVO getParcel(int orderNum) {
        return oDAO.getParcel(orderNum);
    }

    @Override
    public boolean deleteGoodsOrder(int orderNum) {
        return oDAO.deleteGoodsOrder(orderNum);
    }

    @Override
    public List<TempOrderHistoryVO> deletOrderList() {
        return oDAO.deletOrderList();
    }

    @Override
    public List<TempPloggingVO> getPloggingList() {
       return mDAO.getPloggingList();
    }
}
