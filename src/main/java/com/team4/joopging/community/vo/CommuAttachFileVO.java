package com.team4.joopging.community.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommuAttachFileVO {
    private String commuFileName;
    private String commuUploadPath;
    private String commuUuid;
    private boolean commuImage;
    private Long commuBno;
}
