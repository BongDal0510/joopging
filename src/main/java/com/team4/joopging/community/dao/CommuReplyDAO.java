package com.team4.joopging.community.dao;

import com.team4.joopging.community.vo.CommuReplyVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mappers.CommuReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CommuReplyDAO {
    private final CommuReplyMapper commuReplyMapper;

    /*댓글 등록*/
    public int registerCommuReply(CommuReplyVO commuReplyVO){
        log.info("register--------------");
        return commuReplyMapper.insertCommuReply(commuReplyVO);
    }

    /*댓글 읽기*/
    public CommuReplyVO getCommuReply(Long commuRno){
        log.info("read--------------");
        return commuReplyMapper.readCommuReply(commuRno);
    }

    /*댓글 삭제*/
    public int removeCommuReply(Long commuRno){
        log.info("remove--------------");
        return commuReplyMapper.deleteCommuReply(commuRno);
    }

    /*댓글 수정*/
    public int modifyCommuReply(CommuReplyVO commuReplyVO){
        log.info("modify--------------");
        return commuReplyMapper.updateCommuReply(commuReplyVO);
    }

    /*댓글 목록*/
    public List<CommuReplyVO> getCommuReplyList(Long commuBno, Criteria criteria){
        log.info("list--------------");
        return commuReplyMapper.getCommuReplyListWithPaging(commuBno, criteria);
    }

    /*총 댓글 개수*/
    public int getCommuReplyTotal(Long commuBno){
        log.info("getTotal...............");
        return commuReplyMapper.getCommuReplyTotal(commuBno);
    }
}
