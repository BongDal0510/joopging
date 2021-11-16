package com.team4.joopging.plogging.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class PloggingCriteria {
    private int pageNum;
    private int amount;

    public PloggingCriteria(){
        this(1, 6);
    }

    public PloggingCriteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

}