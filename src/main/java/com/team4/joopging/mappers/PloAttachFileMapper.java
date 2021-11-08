package com.team4.joopging.mappers;


import com.team4.joopging.plogging.vo.PloAttachFileVO;

import java.util.List;

public interface PloAttachFileMapper {
    public void insert(PloAttachFileVO ploAttachFileVO);
    public void delete(String uuid);
    public List<PloAttachFileVO> findByBno(int ploggingNum);
    public void deleteAll(int ploggingNum);
    public List<PloAttachFileVO> getOldFiles();
    public String getFileName(int ploggingNum);
}
