package com.team4.joopging.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
// 상품번호
// 상품이름
// 상품카테고리
// 상품설명
// 상품가격

@Component
@Data
public class ShopVO {

    private Long goodsNum;
    private String goodsName;
    private String goodsCategory;
    private String goodsPrice;
    private String goodsContent;
}
