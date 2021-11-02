package com.team4.joopging.event.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EventPageDTO {
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private EventCriteria criteria;

    public EventPageDTO() {;}

    public EventPageDTO(int total, int pageCount, EventCriteria criteria) {
        this.total = total;
        this.pageCount = pageCount;
        this.criteria = criteria;

        this.endPage = (int)(Math.ceil(criteria.getPageNum() * 1.0 / pageCount)) * pageCount;
        this.startPage = endPage - (pageCount - 1);

        realEnd = (int)(Math.ceil(total * 1.0 / criteria.getAmount()));

        if(endPage > realEnd){
            endPage = realEnd == 0 ? 1 : realEnd;
        }

        //true 또는 false로 값이 나뉨
        prev = startPage > 1;
        next = endPage < realEnd;
    }
}
