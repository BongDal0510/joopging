package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuAttachFileVO;

import java.util.List;

public interface CommuAttachFileMapper {
    public void insert(CommuAttachFileVO commuAttachFileVO);
    public void delete(String uuid);
    public List<CommuAttachFileVO> findByBno(Long commuBno);
    public void deleteAll(Long commuBno);
    public List<CommuAttachFileVO> getOldFiles();
}
