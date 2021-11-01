package com.team4.joopging.community.dao;

import com.team4.joopging.community.vo.CommuAttachFileVO;
import com.team4.joopging.mappers.CommuAttachFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommuAttachFileDAO {
    @Autowired
    private CommuAttachFileMapper commuAttachFileMapper;

    public void commuInsert(CommuAttachFileVO commuAttachFileVO){
        commuAttachFileMapper.commuInsert(commuAttachFileVO);
    }

    public void commuDelete(String commuUuid){
        commuAttachFileMapper.commuDelete(commuUuid);
    }

    public List<CommuAttachFileVO> commuFindByBno(Long commuBno){
        return commuAttachFileMapper.commuFindByBno(commuBno);
    }

    public void commuDeleteAll(Long commuBno){commuAttachFileMapper.commuDeleteAll(commuBno);}

    public List<CommuAttachFileVO> commuGetOldFiles() {return commuAttachFileMapper.commuGetOldFiles();}
}


















