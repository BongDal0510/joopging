package com.team4.joopging.community.vo;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Data
public class Criteria {
    private int pageNum;
    private int amount;
    private String type;
    private String keyword;

    public Criteria(){
        this(1,10);
    }

    public Criteria(int pageNum, int amount){
        this.pageNum = pageNum;
        this.amount = amount;
    }

    //fromPath는 기존 경로에 추가할 경로가 있을 때 사용하는 것.
    public String getListLink(){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")//쿼리스트링 앞에 추가적으로 넣어줄 경로가 없으므로 비워둠.
                .queryParam("pageNum", pageNum)
                .queryParam("amount", amount)
                .queryParam("type", type)
                .queryParam("keyword", keyword);
        return builder.toUriString();
    }

    public String[] getTypeArr(){
        return type == null ? new String[] {} : type.split("");
    }

}