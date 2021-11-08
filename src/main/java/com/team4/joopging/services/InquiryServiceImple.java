package com.team4.joopging.services;

import com.team4.joopging.community.dao.InquiryDAO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.community.vo.InquiryVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryServiceImple implements InquiryService {

    private final InquiryDAO inquiryDAO;

    @Override
    public void register(InquiryVO inquiryVO){
        inquiryDAO.register(inquiryVO);
    }

    @Override
    public InquiryVO get(Long inquiryNum) {
        return inquiryDAO.get(inquiryNum);
    }

    @Override
    public boolean remove(Long inquiryNum) {
        return inquiryDAO.remove(inquiryNum);
    }

    @Override
    public List<InquiryVO> getList(Criteria criteria) {
//        날짜에서 시간제거
        List<InquiryVO> list = inquiryDAO.getList(criteria);
        for (InquiryVO vo:list) {
            vo.setInquiryRegDate(vo.getInquiryRegDate().split(" ")[0]);
        }
        return list;
    }

    @Override
    public int getTotal(Criteria criteria) {
        return inquiryDAO.getTotal(criteria);
    }

}
