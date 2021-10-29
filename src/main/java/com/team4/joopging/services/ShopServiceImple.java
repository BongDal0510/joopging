package com.team4.joopging.services;

import com.team4.joopging.beans.dao.ShopDAO;
import com.team4.joopging.beans.vo.ShopCriteria;
import com.team4.joopging.beans.vo.ShopVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImple implements ShopService{

    private final ShopDAO shopDAO;

    @Override
    public void goodsRegister(ShopVO shop) {
        shopDAO.goodsRegister(shop);
    }

    @Override
    public ShopVO goodsGet(Long goodsNum) {
        return shopDAO.goodsGet(goodsNum);
    }

    @Override
    public boolean goodsModify(ShopVO shop) {
        return shopDAO.goodsModify(shop);
    }

    @Override
    public boolean goodsRemove(Long goodsNum) {
        return shopDAO.goodsDelete(goodsNum);
    }

    @Override
    public List<ShopVO> goodsGetList(ShopCriteria shopCriteria) {
        return shopDAO.goodsGetList(shopCriteria);
    }
}
