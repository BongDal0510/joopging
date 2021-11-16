package com.team4.joopging.mappers;


import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.community.vo.InquiryReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InquiryReplyMapper {

    //댓글 등록
    public int insertInquiryReply(InquiryReplyVO inquiryReplyVO);

    //댓글 1개 조회
    public InquiryReplyVO readInquiryReply(Long inquiryRno);

    //댓글 삭제
    public int deleteInquiryReply(Long inquiryRno);

    //댓글 수정
    public int updateInquiryReply(InquiryReplyVO inquiryReplyVO);

    //댓글 목록
    public List<InquiryReplyVO> getInquiryReplyPagingList(@Param("inquiryNum")Long inquiryNum, @Param("criteria") Criteria criteria);

    //댓글 개수
    public int getInquiryReplyTotal(Long inquiryNum);
}
