package com.team4.joopging.community.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommuVO {
    private Long commuBno;
    private String commuTitle;
    private String commuContent;
    private String commuWriter;
    private String commuRegDate;
    private String commuUpdateDate;
    private Long commuViewCnt;
    private int commuBoardStatus;
}
