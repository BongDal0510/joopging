package com.team4.joopging.beans.dao;

import com.team4.joopging.beans.vo.ShopVO;
import com.team4.joopging.mappers.ShopMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShopDAO {

    private final ShopMapper mapper;

    public void goodsRegister(ShopVO shop){
        mapper.goodsInsertSelectKey_goodsNum(shop);
    }

    public ShopVO goodsGet(Long goodsNum){
        return mapper.goodsRead(goodsNum);
    }

    public boolean goodsModify(ShopVO shop){
        return mapper.goodsUpdate(shop) == 1;
    }
    public boolean goodsDelete(Long goodsNum){
        return mapper.goodsDelete(goodsNum) == 1;
    }
    public List<ShopVO> goodsGetList(){
        return mapper.getGoodsList();
    }

}
