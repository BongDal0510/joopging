package com.team4.joopging.services;



import com.team4.joopging.plogging.dao.PloggingDAO;
import com.team4.joopging.plogging.vo.PloggingCriteria;
import com.team4.joopging.plogging.vo.PloggingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PloggingService {
    private final PloggingDAO ploggingDAO;

    public void register(PloggingVO ploggingVO){
        ploggingDAO.register(ploggingVO);
    }

    public PloggingVO get(Long ploggingNum){
        return ploggingDAO.get(ploggingNum);
    }

//    public boolean modify(PloggingVO plogging){
//        return ploggingDAO.modify(plogging);
//    }

    public boolean remove(Long ploggingNum){
        return ploggingDAO.remove(ploggingNum);
    }

    public List<PloggingVO> getList(PloggingCriteria ploggingCriteria){
        return ploggingDAO.getList(ploggingCriteria);
    }

    public int getTotal(){
        return ploggingDAO.getTotal();
    }

    public void reservation(String memberId, String ploggingNum) { ploggingDAO.reservation(memberId, ploggingNum); }

    public void addPloggingPpl(int peo, String ploggingNum) { ploggingDAO.addPloggingPpl(peo, ploggingNum);}
}
