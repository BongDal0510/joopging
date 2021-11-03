package com.team4.joopging.event.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EventVO {
    private Long eventNum;
    private String eventTitle;
    private String eventSubtitle;
    private String eventContent;
    private String eventDate;
    private String eventRegDate;
}
