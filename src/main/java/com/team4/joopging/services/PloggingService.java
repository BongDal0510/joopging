package com.team4.joopging.services;



import com.team4.joopging.plogging.dao.PloAttachFileDAO;
import com.team4.joopging.plogging.dao.PloggingDAO;
import com.team4.joopging.plogging.vo.PloAttachFileVO;
import com.team4.joopging.plogging.vo.PloggingCriteria;
import com.team4.joopging.plogging.vo.PloggingVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PloggingService {
    private final PloggingDAO ploggingDAO;
    private final PloAttachFileDAO ploAttachFileDAO;

    @Transactional(rollbackFor = Exception.class)
    public void register(PloggingVO vo) {
        ploggingDAO.register(vo);
        if(vo.getAttachList() == null || vo.getAttachList().size() == 0){
            log.info("리턴 실행");
            return;
        }
        vo.getAttachList().forEach(attach -> {
            log.info("파일 저장 실행");
            attach.setPloggingNum(vo.getPloggingNum());
            ploAttachFileDAO.insert(attach);
            log.info("파일 저장 성공");
        });
    }

    public PloggingVO get(int ploggingNum){
        return ploggingDAO.get(ploggingNum);
    }

    public String getFileName(int ploggingNum){ return ploAttachFileDAO.getFileName(ploggingNum);}

//    public boolean modify(PloggingVO plogging){
//        return ploggingDAO.modify(plogging);
//    }

    public boolean remove(int ploggingNum){
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

    public List<PloAttachFileVO> getAttachList(int ploggingNum) {
        return ploAttachFileDAO.findByBno(ploggingNum);
    }

    public String getFileNames(int ploggingNum){ return ploggingDAO.getFileName(ploggingNum);}

}