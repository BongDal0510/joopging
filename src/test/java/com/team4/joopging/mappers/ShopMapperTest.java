package com.team4.joopging.mappers;

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

}
