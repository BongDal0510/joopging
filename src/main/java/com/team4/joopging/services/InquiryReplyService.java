package com.team4.joopging.services;


import com.team4.joopging.community.dao.InquiryReplyDAO;
import com.team4.joopging.community.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InquiryReplyService {

    private final InquiryReplyDAO inquiryReplyDAO;

    /*댓글 등록*/
    public int registerInquiryReply(InquiryReplyVO inquiryReplyVO) {
        log.info("register--------------");
        return inquiryReplyDAO.registerInquiryReply(inquiryReplyVO);
    }

    /*댓글 읽기*/
    public InquiryReplyVO getInquiryReply(Long inquiryRno) {
        log.info("register--------------");
        return inquiryReplyDAO.getInquiryReply(inquiryRno);
    }

    /*댓글 삭제*/
    public int removeInquiryReply(Long inquiryRno) {
        log.info("register--------------");
        return inquiryReplyDAO.removeInquiryReply(inquiryRno);
    }

    /*댓글 수정*/
    public int modifyInquiryReply(InquiryReplyVO inquiryReplyVO) {
        log.info("register--------------");
        return inquiryReplyDAO.modifyInquiryReply(inquiryReplyVO);
    }

    /*댓글 목록*/
    public InquiryReplyPageDTO getInquiryReplyPagingList(Long inquiryNum, Criteria criteria) {
        log.info("getList..............");
        return new InquiryReplyPageDTO(inquiryReplyDAO.getInquiryReplyTotal(inquiryNum), inquiryReplyDAO.getInquiryReplyPagingList(inquiryNum, criteria));
    }
}