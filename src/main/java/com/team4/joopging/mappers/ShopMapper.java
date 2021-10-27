package com.team4.joopging.mappers;


import com.team4.joopging.beans.vo.ShopVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    public List<ShopVO> getGoodsList();


}
