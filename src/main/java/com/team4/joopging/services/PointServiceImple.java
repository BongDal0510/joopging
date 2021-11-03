package com.team4.joopging.services;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.point.dao.PointDAO;
import com.team4.joopging.point.vo.PointVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointServiceImple implements PointService {

    private final PointDAO dao;

    @Override
    public List<PointVO> getPointList(int memberNum, Criteria criteria) {
        return dao.getPointList(memberNum,criteria);
    }

    @Override
    public int totalPointCnt(int memberNum) {
        return dao.totalPointCnt(memberNum);
    }

    @Override
    public boolean addPoint(PointVO vo) {
        return dao.addPoint(vo);
    }
}
