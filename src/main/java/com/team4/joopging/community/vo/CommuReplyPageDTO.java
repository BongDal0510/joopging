package com.team4.joopging.community.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
public class CommuReplyPageDTO {
    private int replyCnt;
    private List<CommuReplyVO> list;

    public CommuReplyPageDTO(){;}
}
