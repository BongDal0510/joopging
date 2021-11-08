package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.community.vo.InquiryVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InquiryMapper {
    //    문의글 목록
    public List<InquiryVO> getList(Criteria criteria);

    //    문의글 추가(PK가져오기)
    public void insertSelectKey_num(InquiryVO inquiryVO);

    //    문의글 상세보기(특정 게시글 정보)
    public InquiryVO read(Long inquiryNum);

    //    문의글 삭제
    public int delete(Long inquiryNum);

    //    문의글 전체 개수
    public int getTotal(Criteria criteria);
}
