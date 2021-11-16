package com.team4.joopging.community.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CommuReplyVO {
    private Long commuRno;
    private Long commuBno;
    private String commuReply;
    private String commuReplier;
    private String commuReplyDate;
    private String commuReplyUpdateDate;
}
