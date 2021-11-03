package com.team4.joopging.beans.dao;

import com.team4.joopging.beans.vo.AttachFileVO;
import com.team4.joopging.mappers.AttachFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

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

    public List<AttachFileVO> findByGoodsNum(Long goodsNum){
        return attachFileMapper.findByGoodsNum(goodsNum);
    }
}
