package com.team4.joopging.services;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.point.vo.PointVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PointService {

    /*포인트 내역 출력(넘버로)*/
    public List<PointVO> getPointList(String memberId, Criteria criteria);

    /*포인트 전체 개수(내역 페이지 이동에 사용)*/
    public int totalPointCnt(String memberId);

    /*포인트 추가*/
    public boolean addPoint(PointVO vo);

}