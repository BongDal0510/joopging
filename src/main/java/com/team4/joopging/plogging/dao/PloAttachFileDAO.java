package com.team4.joopging.plogging.dao;

import com.team4.joopging.mappers.PloAttachFileMapper;
import com.team4.joopging.plogging.vo.PloAttachFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PloAttachFileDAO {
    @Autowired
    private PloAttachFileMapper attachFileMapper;

    public void insert(PloAttachFileVO ploAttachFileVO){
        attachFileMapper.insert(ploAttachFileVO);
    }

    public void delete(String uuid){
        attachFileMapper.delete(uuid);
    }

    public List<PloAttachFileVO> findByBno(int ploggingNum){
        return attachFileMapper.findByBno(ploggingNum);
    }

    public void deleteAll(int ploggingNum){attachFileMapper.deleteAll(ploggingNum);}

    public List<PloAttachFileVO> getOldFiles() {return attachFileMapper.getOldFiles();}

    public String getFileName(int ploggingNum){return attachFileMapper.getFileName(ploggingNum);}
}



