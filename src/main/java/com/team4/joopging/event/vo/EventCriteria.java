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
        this(1, 10);
    }

    public EventCriteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

//    public String getListLink(){
//        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
//                .queryParam("pageNum", pageNum)
//                .queryParam("amount", amount);
//        return builder.toUriString();
//    }

}
