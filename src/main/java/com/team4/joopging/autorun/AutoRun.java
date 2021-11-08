package com.team4.joopging.autorun;

import com.team4.joopging.member.memberDAO.MemberDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AutoRun {
//    Quartz format
//    [Seconds] [Minutes] [Hours] [Day-of-Month] [Month] [Day-of-Week] [Year-생략가능]
//    - Seconds : 0 ~ 59
//    - Minutes : 0 ~ 59
//    - Hours : 0 ~ 23
//    - Day of Month : 0 ~ 31
//    - Month : 1 ~ 12
//    - Day of Week : 1(Sunday) ~ 7(Saturday)

//    *     모든 수를 나타낸다
//    -     값의 사이를 지정한다.    "* 10-13 * * * *"       10, 11, 12, 13분에 동작한다.
//    ,     특정 값을 지정한다.     "* 10,11,13 * * * *"     10, 11, 13분에 동작한다.
//    /     값의 증가를 표현한다.    "* 0/5 * * * *"         0분부터 5분마다 동작
//    ?     특별한 값이 없음을 나타낸다.    day-of-month, day-of-week 필드만 사용 가능, 일자, 요일에 하나만 설정할 때 나머지에 지정한다.
//    L     마지막 날을 나타낸다.    day-of-month, day-of-week 필드만 사용 가능, 일자 필드에 사용되면 이달의 마지막 일자이다.
//                                day-of-month : L-3 : 이달의 마지막날 3일 전부터 마지막 날까지
//                                day-of-week  : L-3 : 목요일부터 토요일까지를 나타낸다.
//                                day-of-week  : 6L or FRIL
//    W     주어진 날로부터 가장 가까운 평일(월~금)을 나타낸다.
//    #     이달의 n번째 x요일을 나타낸다. 6#3 or FRIL은 이달의 세 번째 금요일을 나타낸다.

    //    매 분 0초마다  : 0 * * * * * *
//    매 1초 간격    : 0/1 * * * * ?
//    매 1분 간격   : 0 0/1 * * * ?
//    매 5분 간격   : 0 0/5 * ?
//    매 1시간 간격 : 0 0 0/1 * * ?
//    매일 0시 마다 : 0 0 0 * * ?
//    매월 1일 마다 : 0 0 0 1 * ?
/*

    @Autowired
    private MemberDAO memberDAO;

    */
/* 매일 0시 마다 출석상태 초기화 + 출석회수 10일 경우 0으로 초기화 *//*

    @Scheduled(cron = "0 0/1 * * * ?") //현재 시범용 1분간격
    public void resetAttendStatus(){
        log.info("========================================");
        log.info("출석상태 초기화");
        log.info("========================================");
        memberDAO.memberResetAttendStatus();
        memberDAO.memberResetAttendCnt();
    }

    */
/* 매월 1일 마다 멤버레벨 승급 *//*

    @Scheduled(cron = "0 0/1 * * * ?") //현재 시범용 1분간격
    public void updateLevel(){
        log.info("========================================");
        log.info("멤버레벨 승급");
        log.info("========================================");
        memberDAO.memberUpdateLevelAmateur();
        memberDAO.memberUpdateLevelVeteran();
        memberDAO.memberUpdateLevelMaster();
    }
*/
}

