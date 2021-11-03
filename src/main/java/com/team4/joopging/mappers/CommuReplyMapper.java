package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuReplyVO;
import com.team4.joopging.community.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommuReplyMapper {

    //댓글 등록
    public int insertCommuReply(CommuReplyVO commuReplyVO);

    //댓글 1개 조회
    public CommuReplyVO readCommuReply(Long commuRno);

    //댓글 삭제
    public int deleteCommuReply(Long commuRno);

    //댓글 수정
    public int updateCommuReply(CommuReplyVO commuReplyVO);

    //댓글 목록
    public List<CommuReplyVO> getCommuReplyPagingList(@Param("commuBno")Long commuBno, @Param("criteria") Criteria criteria);

    //댓글 개수
    public int getCommuReplyTotal(Long commuBno);
}
