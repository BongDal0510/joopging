package com.team4.joopging.mypage.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class reservationVO {
    /*예약번호*/
    private int reservation;
     /*멤버번호(FK)*/
    private int memberNum;
     /*플로깅번호(FK)*/
    private int ploggingNum;
     /*예약한 날짜*/
    private String ploggingDate;
     /*예약한 시간*/
    private String ploggingTime;
}