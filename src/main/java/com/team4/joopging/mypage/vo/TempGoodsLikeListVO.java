package com.team4.joopging.mypage.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TempGoodsLikeListVO {
    /*찜번호(PK)*/
    private int goodsLikeNum;
    /*맴버번호(FK)*/
    private String memberId;
    /*상품번호(FK)*/
    private int goodsNum;
    /*상품 명*/
    private String GoodsName;
    /*상품 가격*/
    private String GoodsPrice;
}
