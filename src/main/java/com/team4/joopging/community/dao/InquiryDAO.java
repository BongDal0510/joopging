package com.team4.joopging.community.dao;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.community.vo.InquiryVO;
import com.team4.joopging.mappers.InquiryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InquiryDAO {

    private final InquiryMapper inquiryMapper;

    public void register(InquiryVO inquiryVO){inquiryMapper.insertSelectKey_num(inquiryVO);}

    public InquiryVO get(Long inquiryNum){
        return inquiryMapper.read(inquiryNum);
    }

    public boolean remove(Long inquiryNum){
        return inquiryMapper.delete(inquiryNum) == 1;
    }

    public List<InquiryVO> getList(Criteria criteria){return inquiryMapper.getList(criteria);}

    public int getTotal(Criteria criteria){return inquiryMapper.getTotal(criteria);}
}
