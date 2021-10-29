package com.team4.joopging.mappers;

import com.team4.joopging.point.vo.PointVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PointMapper {
    /*포인트 목록*/
    public List<PointVO> getPointList(int memberNum);
    /*포인트 추가*/
    public void addPoint(PointVO vo);
}
