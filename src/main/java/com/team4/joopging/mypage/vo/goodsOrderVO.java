package com.team4.joopging.mypage.vo;

public class goodsOrderVO {
    /*구매한 상품 주문번호(PK)*/
    private int orderNum;
    /*맴버번호(FK)*/
    private int memberNum;
    /*상품번호(FK)*/
    private int goodsNum;
    /*구매 상품 개수*/
    private int goodsCnt;
    /*상품 옵션(색상)*/
    private String goodsColor;
    /*상품 옵션(사이즈)*/
    private String goodsSize;
    /*상품 구매 날짜*/
    private String orderDate;
    /*상품 취소/환불 등의 상태*/
    private int orderStatus;
}