package com.team4.joopging.mappers;

import com.team4.joopging.beans.vo.AttachFileVO;

import java.util.List;

public interface AttachFileMapper {
    public void insert(AttachFileVO attachFileVO);
    public void delete(String uuid);
    public List<AttachFileVO> findByGoodsNum(Long goodsNum);
}
