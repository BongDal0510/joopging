package com.team4.joopging.services;

import com.team4.joopging.beans.vo.ShopCriteria;
import com.team4.joopging.beans.vo.ShopVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

@SpringBootTest
@Slf4j
public class ShopServiceTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testGoodsRegister(){
        ShopVO shop = new ShopVO();
        shop.setGoodsName("수정 테스트 상품7");
        shop.setGoodsCategory("T-shirts");
        shop.setGoodsPrice("5,000");
        shop.setGoodsContent("수정 테스트 상품7 입니다.");

        shopService.goodsRegister(shop);
    }
    @Test
    public void testGetGoodsList(){
        ShopCriteria shopCriteria = new ShopCriteria();
        shopService.goodsGetList(shopCriteria).forEach(shop-> log.info(shop.toString()));
    }
}