package com.team4.joopging.services;

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
    public List<TempPloResVO> getPloResList(int memberNum, Criteria criteria) {
        return mDAO.getPloResList(memberNum, criteria);
    }

    @Override
    public int totalPloResCnt(int memberNum) {
        return mDAO.totalPloResCnt(memberNum);
    }

    @Override
    public int realTotalPloResCnt(int memberNum) {
        return mDAO.realTotalPloResCnt(memberNum);
    }

    @Override
    public List<TempGoodsLikeListVO> getGoodsLikeList(int memberNum, Criteria criteria) {
        return mDAO.getGoodsLikeList(memberNum,criteria);
    }

    @Override
    public int totalGoodsLikeCnt(int memberNum) {
        return mDAO.totalGoodsLikeCnt(memberNum);
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
        return mDAO.deleteMember(memberId,memberId);
    }

    @Override
    public List<CommuVO> getMemberCommuList(String memberId, Criteria criteria) {
        return mDAO.getMemberCommuList(memberId,criteria);
    }

    @Override
    public int selectMemberNum(String memberId) {
        return mDAO.selectMemberNum(memberId);
    }

    @Override
    public List<TempOrderHistoryVO> getOrderHistoryList(int memberNum, Criteria criteria) {
        return oDAO.getOrderHistoryList(memberNum,criteria);
    }

    @Override
    public int totalOrderCnt(int memberNum) {
        return oDAO.totalOrderCnt(memberNum);
    }

    @Override
    public int realTotalOrderCnt(int memberNum) {
        return oDAO.realTotalOrderCnt(memberNum);
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
}
