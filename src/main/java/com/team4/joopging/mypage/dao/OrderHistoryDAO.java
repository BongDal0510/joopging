package com.team4.joopging.mypage.dao;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mappers.OrderHistoryMapper;
import com.team4.joopging.mypage.vo.TempOrderHistoryVO;
import com.team4.joopging.mypage.vo.TempParcelVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderHistoryDAO {

    private final OrderHistoryMapper mapper;

    /*구매 상품 내역 출력(아이디로)*/
    public List<TempOrderHistoryVO> getOrderHistoryList(int memberNum, Criteria criteria){
        return mapper.getOrderHistoryList(memberNum, criteria);
    }

    /*구매한 상품 토탈*/
    public int totalOrderCnt(int memberNum){
        return mapper.totalOrderCnt(memberNum);
    }
    /*구매한 상품 토탈*/
    public int realTotalOrderCnt(int memberNum){
        return mapper.realTotalOrderCnt(memberNum);
    }

    /*택배 정보 출력(구매상품번호로)*/
    public TempParcelVO getParcel(int orderNum){return mapper.getParcel(orderNum);}

    /*구매 상품 취소(상품 번호로)*/
    public boolean deleteGoodsOrder(int orderNum){return mapper.deleteOrderHistory(orderNum) == 1;}

    /*구매취소된 상품 불러오기*/
    public List<TempOrderHistoryVO> deletOrderList(){return mapper.deletOrderList();}

}