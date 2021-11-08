package com.team4.joopging.mappers;

import com.team4.joopging.event.vo.EventFileVO;

import java.util.List;

public interface EventFileMapper {
    public void insert(EventFileVO eventFileVO);
    public void delete(String uuid);
    public List<EventFileVO> findByBno(Long eventNum);
    public void deleteAll(Long eventNum);
    public List<EventFileVO> getOldFiles();
}
