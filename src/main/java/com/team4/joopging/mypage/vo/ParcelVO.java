package com.team4.joopging.mypage.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ParcelVO {
    /*운송장 번호*/
    private String parcelNum;
    /*택배사*/
    private String parcelCode;
    /*구매한 상품 예약 번호(FK)*/
    private int orderNum;
}
