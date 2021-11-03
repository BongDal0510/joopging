package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.point.vo.PointVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointMapper {
    /*포인트 목록*/
    public List<PointVO> getPointList(@Param("memberNum")int memberNum, @Param("criteria")Criteria criteria);

    /*포인트 전체개수*/
    public int totalPointCnt(int memberNum);

    /*포인트 추가*/
    public int addPoint(PointVO vo);

    /*구매 상품 취소*/
    public int removeOrder(PointVO vo);

    /*구매 취소된 상품 인지 확인 여부*/
    public int checkDeletOrder(int orderNum);
}
