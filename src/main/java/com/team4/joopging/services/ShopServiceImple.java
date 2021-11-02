package com.team4.joopging.services;

import com.team4.joopging.beans.dao.AttachFileDAO;
import com.team4.joopging.beans.dao.ShopDAO;
import com.team4.joopging.beans.vo.ShopCriteria;
import com.team4.joopging.beans.vo.ShopVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImple implements ShopService{

    private final ShopDAO shopDAO;
    private final AttachFileDAO attachFileDAO;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void goodsRegister(ShopVO shop) {
        shopDAO.goodsRegister(shop);
        if(shop.getAttachList() ==null || shop.getAttachList().size() ==0){
            return;
        }
        shop.getAttachList().forEach(attach ->{
            attach.setGoodsNum(shop.getGoodsNum());
            attachFileDAO.insert(attach);

        });
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

    @Override
    public int goodsGetTotal() {return shopDAO.goodsGetTotal();}
}
