package com.team4.joopging.point.dao;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mappers.PointMapper;
import com.team4.joopging.point.vo.PointVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PointDAO {

    private final PointMapper mapper;

    /*포인트 내역 출력(넘버로)*/
    public List<PointVO> getPointList(int memberNum, Criteria criteria){
        return mapper.getPointList(memberNum, criteria);
    }

    /*포인트 전체 개수*/
    public int totalPointCnt(int memberNum){
        return totalPointCnt(memberNum);
    };

    /*포인트 추가*/
    public boolean addPoint(PointVO vo){
        return mapper.addPoint(vo) == 1;
    }

    /*구매 상품 취소()*/
    public boolean removeOrder(PointVO vo){
        return mapper.removeOrder(vo)==1;
    }


}
