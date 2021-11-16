package com.team4.joopging.community.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InquiryVO {
    private Long inquiryNum;
    private String inquiryTitle;
    private String inquiryContent;
    private String memberId;
    private String inquiryRegDate;
    private int inquiryStatus;
}
