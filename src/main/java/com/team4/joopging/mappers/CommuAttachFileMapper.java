package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuAttachFileVO;

import java.util.List;

public interface CommuAttachFileMapper {
    public void commuInsert(CommuAttachFileVO CommuAttachFileVO);
    public void commuDelete(String commuUuid);
    public List<CommuAttachFileVO> commuFindByBno(Long commuBno);
    public void commuDeleteAll(Long commuBno);
    public List<CommuAttachFileVO> commuGetOldFiles();
}
