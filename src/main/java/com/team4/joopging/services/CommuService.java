package com.team4.joopging.services;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommuService {
    public void registerCommu(CommuVO commu);
    public CommuVO getCommu(Long commuBno);
    public boolean modifyCommu(CommuVO commu);
    public boolean removeCommu(Long commuBno);
    public List<CommuVO> getCommuList(Criteria criteria);
    public int getCommuTotal(Criteria criteria);
    public boolean updateCommuViewCnt(Long commuBno);
    public List<CommuVO> getAnnounceList(int commuBoardStatus);
}