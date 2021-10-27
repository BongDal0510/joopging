package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.mypage.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageMapper {
    /*플로깅 예약 목록*/
    public List<reservationVO> getReservationList();
    /*포인트 목록*/
    public List<pointVO> getPointList();
    /*구매 상품 목록*/
    public List<goodsOrderVO> getGoodsOrderList();
    /*상품의 택배*/
    public parcelVO getParcel();
    /*찜 목록*/
    public List<goodsLikeListVO> getGoodsLikeList();
    /*내가 작성한 게시판 목록*/
    public List<CommuVO> getMyCommuList();
    /*내가 작성한 1:1문의 목록*/
    public List<CommuVO> getMyQuestionList();
    /*플로깅 예약 취소*/
    public int deleteReservation();
    /*상품 구매 취소*/
    public int deleteGoodsOrder();
}