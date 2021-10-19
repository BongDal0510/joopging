package com.team4.joopging.services;

import com.team4.joopging.community.dao.CommuReplyDAO;
import com.team4.joopging.community.vo.CommuReplyPageDTO;
import com.team4.joopging.community.vo.CommuReplyVO;
import com.team4.joopging.community.vo.Criteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommuReplyService {

    private final CommuReplyDAO commuReplyDAO;

    /*댓글 등록*/
    public int registerCommuReply(CommuReplyVO commuReplyVO) {
        log.info("register--------------");
        return commuReplyDAO.registerCommuReply(commuReplyVO);
    }

    /*댓글 읽기*/
    public CommuReplyVO getCommuReply(Long commuRno) {
        log.info("register--------------");
        return commuReplyDAO.getCommuReply(commuRno);
    }

    /*댓글 삭제*/
    public int removeCommuReply(Long commuRno) {
        log.info("register--------------");
        return commuReplyDAO.removeCommuReply(commuRno);
    }

    /*댓글 수정*/
    public int modifyCommuReply(CommuReplyVO commuReplyVO) {
        log.info("register--------------");
        return commuReplyDAO.modifyCommuReply(commuReplyVO);
    }

    /*댓글 목록*/
    public CommuReplyPageDTO getCommuReplyList(Long commuBno, Criteria criteria) {
        log.info("getList..............");
        return new CommuReplyPageDTO(commuReplyDAO.getCommuReplyTotal(commuBno), commuReplyDAO.getCommuReplyList(commuBno, criteria));
    }
}