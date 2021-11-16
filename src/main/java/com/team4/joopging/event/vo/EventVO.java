package com.team4.joopging.event.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class EventVO {
    private int eventNum;
    private String eventTitle;
    private String eventSubtitle;
    private String eventContent;
    private String eventDate;
    private String eventRegDate;
    private String fileName;

    //게시글 가져올 때 첨부파일도 가져올 수 있도록 변수 선언
    private List<EventFileVO> attachList;
}
