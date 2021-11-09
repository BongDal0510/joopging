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
    public void register(EventVO vo) {
        eventDAO.register(vo);
        System.out.println("저장 완료");
        //첨부파일 없을때
//        if(vo.getAttachList() == null || vo.getAttachList().size() == 0){
//            log.info("리턴 실행");
//            return;
//        }
//        vo.getAttachList().forEach(attach -> {
//            log.info("파일 저장 실행");
//            attach.setEventNum(vo.getEventNum());
//            eventFileDAO.insert(vo);
//            log.info("파일 저장 성공");
//        });
    }


    public EventVO get(int eventNum){
        return eventDAO.get(eventNum);
    }

    public boolean modify(EventVO event){
        return eventDAO.modify(event);
    }

    public boolean remove(int eventNum){
        return eventDAO.remove(eventNum);
    }

    public List<EventVO> getList(EventCriteria eventCriteria){
        return eventDAO.getList(eventCriteria);
    }

    public int getTotal(){
        return eventDAO.getTotal();
    }

    public String getFileNames(int eventNum){ return eventDAO.getFileName(eventNum);}

    public List<EventFileVO> getAttachList(int eventNum) {
        return eventFileDAO.findByBno(eventNum);
    }
}
