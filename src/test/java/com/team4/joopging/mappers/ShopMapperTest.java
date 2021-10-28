package com.team4.joopging.mappers;

import com.team4.joopging.beans.vo.ShopVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ShopMapperTest {

    @Autowired
    private ShopMapper mapper;

    @Test
    public void testGetGoodsList(){
        mapper.getGoodsList().forEach(goodslist ->log.info(goodslist.toString()));

    }

    @Test
    public void testGoodsInsert(){
        ShopVO shop = new ShopVO();
        shop.setGoodsName("테스트 상품3");
        shop.setGoodsCategory("T-shirts");
        shop.setGoodsPrice("20,000");
        shop.setGoodsContent("테스트 상품3 입니다.");
        mapper.goodsInsert(shop);
    }

    @Test
    public void testGoodsInsertSelectKey_goodsNum(){
        ShopVO shop = new ShopVO();
        shop.setGoodsName("테스트 상품4");
        shop.setGoodsCategory("T-shirts");
        shop.setGoodsPrice("30,000");
        shop.setGoodsContent("테스트 상품4 입니다.");
        mapper.goodsInsertSelectKey_goodsNum(shop);
    }
    @Test
    public void testGoodsRead(){
        log.info(mapper.goodsRead(10000L).toString());
    }

    @Test
    public void testGoodsUpdate() {

        if (mapper.goodsRead(10000L) == null) {
            log.info("찾는 상품이 없습니다.");
        } else {
            ShopVO shop = new ShopVO();
            shop.setGoodsNum(10000L);
            shop.setGoodsName("수정 테스트 상품4");
            shop.setGoodsCategory("T-shirts");
            shop.setGoodsPrice("35,000");
            shop.setGoodsContent("수정 테스트 상품4 입니다.");
            log.info("update count : " + mapper.goodsUpdate(shop));
        }
    }
    @Test
    public void testGoodsDelete() {
        if (mapper.goodsRead(10021L) == null) {
            log.info("찾는 상품이 없습니다.");
        } else {
            log.info("Delete count : " + mapper.goodsDelete(10021L));
        }
    }
}
