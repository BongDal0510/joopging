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
    //게시글 가져올 때 첨부파일도 가져올 수 있도록 변수 선언
    private List<AttachFileVO> attachList;
}
