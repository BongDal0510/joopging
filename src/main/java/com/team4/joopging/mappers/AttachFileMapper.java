package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.AttachFileVO;

import java.util.List;

public interface AttachFileMapper {
    public void insert(AttachFileVO attachFileVO);
    public void delete(String uuid);
    public List<AttachFileVO> findByBno(Long commuBno);
    public void deleteAll(Long commuBno);
    public List<AttachFileVO> getOldFiles();
}
