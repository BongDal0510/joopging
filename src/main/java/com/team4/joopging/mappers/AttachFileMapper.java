package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.AttachFileVO;

import java.util.List;

public interface AttachFileMapper {
    public void insert(AttachFileVO attachFileVO);
    public void delete(String uuid);
    public List<AttachFileVO> findByBno(Long bno);
    public void deleteAll(Long bno);
    public List<AttachFileVO> getOldFiles();
}
