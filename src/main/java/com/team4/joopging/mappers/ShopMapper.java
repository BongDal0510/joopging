package com.team4.joopging.mappers;


import com.team4.joopging.beans.vo.ShopVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    /*상품목록*/
    public List<ShopVO> getGoodsList();
    /*상품 추가*/
    public void goodsInsert(ShopVO shop);
    /*상품 추가(PK 가져오기)*/
    public void goodsInsertSelectKey_goodsNum(ShopVO shop);
    /*상품 기본정보만 읽기 */
    public ShopVO goodsRead(Long goodsNum);
    /* 상품 수정 */
    public int goodsUpdate(ShopVO shop);
    /* 상품 삭제 */
    public int goodsDelete(Long goodsNum);
}
