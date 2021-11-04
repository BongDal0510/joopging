package com.team4.joopging.mypage.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TempOrderHistoryVO {
    /*구매한 상품 주문번호(PK)*/
    private int orderNum;
    /*맴버번호(FK)*/
    private int memberNum;
    /*상품번호(FK)*/
    private int goodsNum;
    /*상품 명*/
    private String goodsName;
    /*결제 총액*/
    private String goodsTotalCost;
    /*구매 상품 개수*/
    private int goodsCnt;
    /*상품 옵션(색상)*/
    private String goodsColor;
    /*상품 옵션(사이즈)*/
    private String goodsSize;
    /*상품 구매 날짜*/
    private String orderDate;
    /*수령인 이름*/
    private String recipient;
    /*수령인 전화번호*/
    private String recipientPhone;
    /*수령인 집코드*/
    private String recipientZipCode;
    /*수령인 주소*/
    private String recipientAddress;
    /*수령인 주소 상세*/
    private String recipientAddressEtc;
    /*택배 메세지*/
    private String parcelMessage;
    /*사용된 포인트*/
    private int usePoint;
    /*상품 상태-취소시 사용할 예정임*/
    private int orderStatus;
}
