package com.team4.joopging.services;

import com.team4.joopging.event.dao.EventDAO;
import com.team4.joopging.event.vo.EventCriteria;
import com.team4.joopging.event.vo.EventVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {
    private final EventDAO eventDAO;

    public void register(EventVO eventVO){
        eventDAO.register(eventVO);
    }

    public EventVO get(Long eventNum){
        return eventDAO.get(eventNum);
    }

    public boolean modify(EventVO event){
        return eventDAO.modify(event);
    }

    public boolean remove(Long eventNum){
        return eventDAO.remove(eventNum);
    }

    public List<EventVO> getList(EventCriteria eventCriteria){
        return eventDAO.getList(eventCriteria);
    }

    public int getTotal(){
        return eventDAO.getTotal();
    }

}
