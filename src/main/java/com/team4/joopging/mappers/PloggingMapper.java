package com.team4.joopging.mappers;



import com.team4.joopging.plogging.vo.PloggingCriteria;
import com.team4.joopging.plogging.vo.PloggingVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PloggingMapper {
    //플로깅 등록
    public void insertPlogging(PloggingVO plogging);

    //플로깅 상세보기
    public PloggingVO readPlogging(int ploggingNum);

    //플로깅 수정
//    public int updateEvent(PloggingVO plogging);

    //플로깅 삭제
    public int deleteEvent(int ploggingNum);

    //플로깅 목록
    public List<PloggingVO> getPloggingList(PloggingCriteria ploggingCriteria);

    //플로깅 전체 개수
    public int getTotal();

    //플로깅 예약
    public void reservation(String memberId, String ploggingNum);

    //플로깅 신청인원
    public void addPloggingPpl(int peo, String ploggingNum);

    //파일명 가져오기
    public String getFileName(int ploggingNum);
}