package com.team4.joopging.community.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
//페이징 연산하는 페이지
@Component
@Data
public class CommuPageDTO {
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private Criteria criteria;

    public CommuPageDTO(){;}

    public CommuPageDTO(int total, int pageCount, Criteria criteria) {
        this.total = total;
        this.pageCount = pageCount;
        this.criteria = criteria;

        this.endPage = (int)Math.ceil(criteria.getPageNum() * 1.0 / pageCount) * pageCount;
        this.startPage = endPage - (pageCount - 1);

        realEnd = (int)(Math.ceil(total *1.0 / criteria.getAmount()));

        if(endPage > realEnd){
            endPage = realEnd == 0 ? 1 : realEnd;
        }
        prev = startPage > 1;
        next = endPage < realEnd;
    }
}
