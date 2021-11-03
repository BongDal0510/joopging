package com.team4.joopging.mypage.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TempPloggingVO {
    private int ploggingNum;
    private String ploggingTitle;
    private String ploggingPlace;
    private String ploggingTime;
    private String ploggingContent;
    private int ploggingPpl;
    private int ploggingPplLimit;
    private String ploggingDate;
}