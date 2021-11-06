package com.team4.joopging.mypage.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TempPloResVO {
    /*예약번호*/
    private Long ploResNum;
    /*멤버번호(FK)*/
    private String memberId;
    /*플로깅번호(FK)*/
    private int ploggingNum;
    /*플로깅명*/
    private String ploResTitle;
    /*예약한 장소*/
    private String ploResLocation;
    /*예약한 날짜*/
    private String ploResDate;
    /*예약한 시간*/
    private String ploResTime;
    /*플로깅 예약 취소 등에 상태 변경*/
    private int ploResStatus;
}
