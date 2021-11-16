package com.team4.joopging.beans.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class GoodsLikeVO {
    /*찜번호(PK)*/
    private int goodsLikeNum;
    /*맴버번호(FK)*/
    private String memberId;
    /*상품번호(FK)*/
    private Long goodsNum;
    /*상품 명*/
    private String GoodsName;
    /*상품 가격*/
    private String GoodsPrice;
}