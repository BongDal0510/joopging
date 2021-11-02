package com.team4.joopging.community.dao;

import com.team4.joopging.community.vo.AttachFileVO;
import com.team4.joopging.mappers.AttachFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttachFileDAO {
    @Autowired
    private AttachFileMapper attachFileMapper;

    public void insert(AttachFileVO attachFileVO){
        attachFileMapper.insert(attachFileVO);
    }

    public void delete(String uuid){
        attachFileMapper.delete(uuid);
    }

    public List<AttachFileVO> findByBno(Long commuBno){
        return attachFileMapper.findByBno(commuBno);
    }

    public void deleteAll(Long commuBno){attachFileMapper.deleteAll(commuBno);}

    public List<AttachFileVO> getOldFiles() {return attachFileMapper.getOldFiles();}
}


















