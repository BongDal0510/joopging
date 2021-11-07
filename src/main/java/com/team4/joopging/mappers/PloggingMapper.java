package com.team4.joopging.mappers;



import com.team4.joopging.plogging.vo.PloggingCriteria;
import com.team4.joopging.plogging.vo.PloggingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PloggingMapper {
    //이벤트 등록
    public void insertPlogging(PloggingVO plogging);

    //이벤트 상세보기
    public PloggingVO readPlogging(Long ploggingNum);

    //이벤트 수정
//    public int updateEvent(PloggingVO plogging);

    //이벤트 삭제
    public int deleteEvent(Long ploggingNum);

    //이벤트 목록
    public List<PloggingVO> getPloggingList(PloggingCriteria eventCriteria);

    //이벤트 전체 개수
    public int getTotal();
}
