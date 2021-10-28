package com.team4.joopging.bean.dao;


import com.team4.joopging.beans.dao.ShopDAO;
import com.team4.joopging.beans.vo.ShopVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShopDAO_test {
    @Autowired
    private ShopDAO shopDAO;

    @Test
    public void testGoodsRegister(){
        ShopVO shop = new ShopVO();
        shop.setGoodsName("수정 테스트 상품6");
        shop.setGoodsCategory("T-shirts");
        shop.setGoodsPrice("15,000");
        shop.setGoodsContent("수정 테스트 상품6 입니다.");

        shopDAO.goodsRegister(shop);
        log.info("-------------------------------");
        log.info(shop.getGoodsNum() + "");
        log.info("-------------------------------");
    }


    @Test
    public void testGoodsGet(){
        log.info(shopDAO.goodsGet(10000L).toString());
    }
}
