package com.team4.joopging.services;

import com.team4.joopging.beans.vo.ShopCriteria;
import com.team4.joopging.beans.vo.ShopVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShopService {
    public void goodsRegister(ShopVO shop);
    public ShopVO goodsGet(Long goodsNum);
    public boolean goodsModify(ShopVO Shop);
    public boolean goodsRemove(Long goodsNum);
    public List<ShopVO> goodsGetList(ShopCriteria shopCriteria);
}
