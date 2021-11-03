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

    public void insert(CommuAttachFileVO commuAttachFileVO){
        commuAttachFileMapper.insert(commuAttachFileVO);
    }

    public void delete(String uuid){
        commuAttachFileMapper.delete(uuid);
    }

    public List<CommuAttachFileVO> findByBno(Long commuBno){
        return commuAttachFileMapper.findByBno(commuBno);
    }

    public void deleteAll(Long commuBno){
        commuAttachFileMapper.deleteAll(commuBno);}

    public List<CommuAttachFileVO> getOldFiles() {return commuAttachFileMapper.getOldFiles();}
}


















