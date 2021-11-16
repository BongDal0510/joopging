package com.team4.joopging.mappers;

import com.team4.joopging.event.vo.EventCriteria;
import com.team4.joopging.event.vo.EventVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {
    //이벤트 등록
    public void insertEvent(EventVO event);

    //이벤트 상세보기
    public EventVO readEvent(int eventNum);

    //이벤트 수정
    public int updateEvent(EventVO event);

    //이벤트 삭제
    public int deleteEvent(int eventNum);

    //이벤트 목록
    public List<EventVO> getEventList(EventCriteria eventCriteria);

    //이벤트 전체 개수
    public int getTotal();

    //파일명 가져오기
    public String getFileName(int eventNum);

}
