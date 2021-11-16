package com.team4.joopging.mypage.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TempPloggingVO {
    private int ploggingNum;//
    private String ploggingTitle;//
    private String ploggingContent;//
    private int ploggingPpl;//
    private int ploggingPplLimit;//
    private Long ploggingPoint;//
    private String ploggingDate;//
    private String ploggingRegDate;//
}