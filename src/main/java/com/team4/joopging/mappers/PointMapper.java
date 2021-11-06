package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.point.vo.PointVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PointMapper {
    /*포인트 목록*/
    public List<PointVO> getPointList(@Param("memberId")String memberId, @Param("criteria")Criteria criteria);

    /*회원의 포인트 전체 내역 개수 */
    public int totalPointCnt(String memberId);

    /*포인트 추가*/
    public int addPoint(PointVO vo);

    /*구매 상품 취소*/
    public int removeOrder(PointVO vo);

    /*구매 취소된 상품 인지 확인 여부*/
    public int checkDeletOrder(int orderNum);
}
