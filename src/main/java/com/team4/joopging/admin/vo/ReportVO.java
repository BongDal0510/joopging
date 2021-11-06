package com.team4.joopging.admin.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ReportVO {
    private Long reportNum;
    private Long commuBno;
    private String sessionId;
    private String reportContent;
    private String reportDetail;
    private String commuTitle;
    private String reportDate;
    private String extraDetails;
    private Long reportStatus;
}
