package com.team4.joopging.plogging.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PloAttachFileVO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
    private int ploggingNum;
}
