package com.team4.joopging.plogging.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class PloggingDTO {
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private PloggingCriteria eventCriteria;

    public PloggingDTO() {;}

    public PloggingDTO(int total, int pageCount, PloggingCriteria eventCriteria) {
        this.total = total;
        this.pageCount = pageCount;
        this.eventCriteria = eventCriteria;

        this.endPage = (int)(Math.ceil(eventCriteria.getPageNum() * 1.0 / pageCount)) * pageCount;
        this.startPage = endPage - (pageCount - 1);

        realEnd = (int)(Math.ceil(total * 1.0 / eventCriteria.getAmount()));

        if(endPage > realEnd){
            endPage = realEnd == 0 ? 1 : realEnd;
        }

        //true 또는 false로 값이 나뉨
        prev = startPage > 1;
        next = endPage < realEnd;
    }
}
