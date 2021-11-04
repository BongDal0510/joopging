package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mypage.vo.TempOrderHistoryVO;
import com.team4.joopging.mypage.vo.TempParcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderHistoryMapper {

    /*구매 상품 목록*/
    public List<TempOrderHistoryVO> getOrderHistoryList(@Param("memberNum") int memberNum,@Param("criteria") Criteria criteria);
    /*구매 상품 목록*/
    public TempOrderHistoryVO getOrderHistory(int orderNum);
    /*구매한 상품 내역 개수*/
    public int totalOrderCnt(int memberNum);
    /*구매한 상품 전체 개수*/
    public int realTotalOrderCnt(int memberNum);
    /*상품의 택배*/
    public TempParcelVO getParcel(int orderNum);
    /*상품 구매 취소*/
    public int deleteOrderHistory(int orderNum);
    /*구매취소된 상품 불러오기*/
    public List<TempOrderHistoryVO> deletOrderList();
}
