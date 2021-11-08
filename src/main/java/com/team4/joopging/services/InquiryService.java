package com.team4.joopging.services;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.community.vo.InquiryVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InquiryService {
    //문의 등록
    public void register(InquiryVO inquiryVO);
    //특정 문의 정보
    public InquiryVO get(Long inquiryNum);
    //문의 삭제
    public boolean remove(Long inquiryNum);
    //문의 목록
    public List<InquiryVO> getList(Criteria criteria);
    //총 문의 개수
    public int getTotal(Criteria criteria);
}
