package com.team4.joopging.beans.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GoodsOptionVO {
    private String goodsNum;
    private String goodsOptionNum;
    private String goodsSize;
    private String goodsColor;
}
