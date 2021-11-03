package com.team4.joopging.point.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PointVO {
        /*포인트 번호*/
        private int pointNum;
        /*멤버 번호(FK)*/
        private int memberNum;
        /*내역*/
        private String history;
        /*포인트 금액*/
        private Long point;
        /*입력 날짜*/
        private String pointDate;
        /*적립/사용/취소*/
        private String pointStatus;
}
