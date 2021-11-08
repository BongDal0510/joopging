package com.team4.joopging.mappers;

import com.team4.joopging.event.vo.EventFileVO;
import com.team4.joopging.event.vo.EventVO;

import java.util.List;

public interface EventFileMapper {
    public void insert(EventVO eventVO);
    public void delete(String uuid);
    public List<EventFileVO> findByBno(int eventNum);
    public void deleteAll(int eventNum);
    public List<EventFileVO> getOldFiles();
}
