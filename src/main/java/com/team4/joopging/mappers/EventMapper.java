package com.team4.joopging.mappers;

import com.team4.joopging.event.vo.EventVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {
    //이벤트 목록
    public List<EventVO> getEventList();

    //이벤트 등록
    public void insertEvent(EventVO event);

    //이벤트 상세보기
    public EventVO readEvent(Long eventNum);

    //이벤트 수정
    public int updateEvent(EventVO event);

    //이벤트 삭제
    public int deleteEvent(Long eventNum);

}
