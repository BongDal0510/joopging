package com.team4.joopging.report.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReportVO {
    private Long reportNum;
    private Long commuBno;
    private String sessionId;
    private String commuWriter;
    private String purpose;
    private String commuTitle;
    private String reportDate;
    private Long reportStatus;
}
