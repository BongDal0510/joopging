package com.team4.joopging.event.dao;

import com.team4.joopging.event.vo.EventCriteria;
import com.team4.joopging.event.vo.EventVO;
import com.team4.joopging.mappers.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventDAO {

    private final EventMapper eventMapper;

    public void register(EventVO event) { eventMapper.insertEvent(event); }

    public EventVO get(Long eventNum) { return eventMapper.readEvent(eventNum); }

    public boolean modify(EventVO event) { return eventMapper.updateEvent(event) == 1; }

    public boolean remove(Long eventNum) { return eventMapper.deleteEvent(eventNum) == 1; }

    public List<EventVO> getList(EventCriteria eventCriteria) { return eventMapper.getEventList(eventCriteria); }

    public int getTotal() { return eventMapper.getTotal(); }

    //파일명 가져오기
    public String getFileName(Long eventNum){ return eventMapper.getFileName(eventNum); };
}