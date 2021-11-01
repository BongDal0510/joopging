package com.team4.joopging.services;

import com.team4.joopging.point.vo.PointVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PointService {

    /*포인트 내역 출력(넘버로)*/
    public List<PointVO> getPointList(int memberNum);

    /*포인트 추가*/
    public void addPoint(PointVO vo);

}