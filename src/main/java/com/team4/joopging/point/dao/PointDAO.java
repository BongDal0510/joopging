package com.team4.joopging.point.dao;

import com.team4.joopging.mappers.MypageMapper;
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
    public List<PointVO> getPointList(int memberNum){
        return mapper.getPointList(memberNum);
    }

    /*포인트 추가*/
    public void addPoint(PointVO vo){
        mapper.addPoint(vo);
    }

}
