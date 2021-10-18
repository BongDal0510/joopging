package com.team4.joopging.services;

import com.team4.joopging.community.dao.CommuDAO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommuServiceImple implements CommuService{

    private final CommuDAO commuDAO;

    @Override
    public void registerCommu(CommuVO commu) {
        commuDAO.registerCommu(commu);
    }

    @Override
    public CommuVO getCommu(Long commuBno) {
        return commuDAO.getCommu(commuBno);
    }

    @Override
    public boolean modifyCommu(CommuVO commu) {
        return commuDAO.modifyCommu(commu);
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
}
