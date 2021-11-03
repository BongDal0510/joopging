package com.team4.joopging.event.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class EventCriteria {
    private int pageNum;
    private int amount;

    public EventCriteria(){
        this(1, 8);
    }

    public EventCriteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

}
