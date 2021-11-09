package com.team4.joopging.event.dao;

import com.team4.joopging.event.vo.EventFileVO;
import com.team4.joopging.event.vo.EventVO;
import com.team4.joopging.mappers.EventFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventFileDAO {
    @Autowired
    private EventFileMapper eventFileMapper;

    public void insert(EventVO eventVO){
        System.out.println("실행");

        eventFileMapper.insert(eventVO);
    }

    public void eventFileMapper(String uuid){
        eventFileMapper.delete(uuid);
    }

    public List<EventFileVO> findByBno(int eventNum){
        return eventFileMapper.findByBno(eventNum);
    }

    public void deleteAll(int eventNum){eventFileMapper.deleteAll(eventNum);}

    public List<EventFileVO> getOldFiles() {return eventFileMapper.getOldFiles();}
}


