package com.team4.joopging.community.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
public class InquiryReplyPageDTO {
    private int replyCnt;
    private List<InquiryReplyVO> list;

    public InquiryReplyPageDTO(){;}
}
