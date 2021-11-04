package com.team4.joopging.community.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommuAttachFileVO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
    private Long commuBno;
}