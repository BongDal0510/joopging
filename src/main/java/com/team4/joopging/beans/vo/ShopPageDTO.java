package com.team4.joopging.beans.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ShopPageDTO {
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private ShopCriteria shopCriteria;

    public ShopPageDTO() {;}

    public ShopPageDTO(int total, int pageCount, ShopCriteria shopCriteria) {
        this.total = total;
        this.pageCount = pageCount;
        this.shopCriteria = shopCriteria;
        //getPageNum() = 사용자가 있는 현재페이지
        this.endPage = (int)(Math.ceil(shopCriteria.getPageNum() * 1.0 / pageCount)) * pageCount;
        this.startPage = endPage - (pageCount - 1);

        realEnd = (int)(Math.ceil(total * 1.0 / shopCriteria.getAmount()));

        if(endPage > realEnd){
            endPage = realEnd == 0 ? 1 : realEnd;
        }

        prev = startPage > 1;
        next = endPage < realEnd;
    }
}