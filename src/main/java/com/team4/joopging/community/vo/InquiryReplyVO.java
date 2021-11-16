package com.team4.joopging.community.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InquiryReplyVO {
    private Long inquiryRno;
    private Long inquiryNum;
    private String inquiryReply;
    private String inquiryReplier;
    private String inquiryReplyDate;
    private String inquiryReplyUpdateDate;
}
