package com.team4.joopging.community.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

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

    //input 태그의 name에
    //attachList[i].fileName...
    //방식으로 submit하면 자동으로 List에 add할 수 있게 된다.
    private List<AttachFileVO> attachList;
}
