package com.team4.joopging.event.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EventFileVO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
    private int eventNum;
}
