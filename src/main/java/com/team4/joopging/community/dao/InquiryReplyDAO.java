package com.team4.joopging.community.dao;


import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.community.vo.InquiryReplyVO;
import com.team4.joopging.mappers.InquiryReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
@Slf4j
public class InquiryReplyDAO {

    private final InquiryReplyMapper inquiryReplyMapper;

    /*댓글 등록*/
    public int registerInquiryReply(InquiryReplyVO inquiryReplyVO){
        log.info("register--------------");
        return inquiryReplyMapper.insertInquiryReply(inquiryReplyVO);
    }

    /*댓글 읽기*/
    public InquiryReplyVO getInquiryReply(Long inquiryRno){
        log.info("read--------------");
        return inquiryReplyMapper.readInquiryReply(inquiryRno);
    }

    /*댓글 삭제*/
    public int removeInquiryReply(Long inquiryRno){
        log.info("remove--------------");
        return inquiryReplyMapper.deleteInquiryReply(inquiryRno);
    }

    /*댓글 수정*/
    public int modifyInquiryReply(InquiryReplyVO inquiryReplyVO){
        log.info("modify--------------");
        return inquiryReplyMapper.updateInquiryReply(inquiryReplyVO);
    }

    /*댓글 목록*/
    public List<InquiryReplyVO> getInquiryReplyPagingList(Long inquiryNum, Criteria criteria){
        log.info("list--------------");
        return inquiryReplyMapper.getInquiryReplyPagingList(inquiryNum, criteria);
    }

    /*총 댓글 개수*/
    public int getInquiryReplyTotal(Long inquiryNum){
        log.info("getTotal...............");
        return inquiryReplyMapper.getInquiryReplyTotal(inquiryNum);
    }
}
