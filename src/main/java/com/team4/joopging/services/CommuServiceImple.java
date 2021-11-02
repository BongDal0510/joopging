package com.team4.joopging.services;

import com.team4.joopging.community.dao.AttachFileDAO;
import com.team4.joopging.community.dao.CommuDAO;
import com.team4.joopging.community.vo.AttachFileVO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommuServiceImple implements CommuService{

    private final CommuDAO commuDAO;
    private final AttachFileDAO attachFileDAO;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void registerCommu(CommuVO commu) {

        commuDAO.registerCommu(commu);


        if(commu.getAttachList() == null || commu.getAttachList().size() == 0){
            return;
        }

        commu.getAttachList().forEach(attach -> {
            attach.setCommuBno(commu.getCommuBno());
            attachFileDAO.insert(attach);
        });
    }
    @Override
    public CommuVO getCommu(Long commuBno) {
        return commuDAO.getCommu(commuBno);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean modifyCommu(CommuVO commu) {

        boolean modifyCommuResult = false;

        attachFileDAO.deleteAll(commu.getCommuBno());
        modifyCommuResult = commuDAO.modifyCommu(commu);

        if(modifyCommuResult && commu.getAttachList() != null && commu.getAttachList().size() != 0){
            commu.getAttachList().forEach(attach -> {
                attach.setCommuBno(commu.getCommuBno());
                attachFileDAO.insert(attach);
            });
        }
        return modifyCommuResult;
    }

    @Override
    public boolean removeCommu(Long commuBno) {
        return commuDAO.removeCommu(commuBno);
    }

    @Override
    public List<CommuVO> getCommuList(Criteria criteria) {
        return commuDAO.getCommuList(criteria);
    }

    @Override
    public int getCommuTotal(Criteria criteria) { return commuDAO.getCommuTotal(criteria); }

    @Override
    public boolean updateCommuViewCnt(Long commuBno) { return commuDAO.updateCommuViewCnt(commuBno); }

    @Override
    public List<CommuVO> getAnnounceList(int commuBoardStatus) {
        return commuDAO.getAnnounceList(commuBoardStatus);
    }

    @Override
    public List<AttachFileVO> getAttachList(Long commuBno) {
        return attachFileDAO.findByBno(commuBno);
    }

}
