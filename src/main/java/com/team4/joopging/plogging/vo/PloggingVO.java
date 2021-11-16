package com.team4.joopging.plogging.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class PloggingVO {
    private int ploggingNum;
    private String ploggingTitle;
    private String ploggingContent;
    private String ploResDate;
    private int ploggingPpl;
    private int ploggingPplLimit;
    private Long ploggingPoint;
    private String ploggingRegDate;
    private List<PloAttachFileVO> attachList;
    private String fileName;
}