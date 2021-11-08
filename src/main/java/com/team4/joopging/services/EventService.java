package com.team4.joopging.services;

import com.team4.joopging.event.dao.EventDAO;
import com.team4.joopging.event.dao.EventFileDAO;
import com.team4.joopging.event.vo.EventCriteria;
import com.team4.joopging.event.vo.EventFileVO;
import com.team4.joopging.event.vo.EventVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {
    private final EventDAO eventDAO;
    private final EventFileDAO eventFileDAO;

    @Transactional(rollbackFor = Exception.class)
    public void register(EventVO eventVO) {

        eventDAO.register(eventVO);


        if(eventVO.getAttachList() == null || eventVO.getAttachList().size() == 0){
            return;
        }

        eventVO.getAttachList().forEach(attach -> {
            attach.setEventNum(eventVO.getEventNum());
            eventFileDAO.insert(attach);
        });
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

    public String getFileNames(Long eventNum){ return eventDAO.getFileName(eventNum);}

    public List<EventFileVO> getAttachList(Long eventNum) {
        return eventFileDAO.findByBno(eventNum);
    }
}
