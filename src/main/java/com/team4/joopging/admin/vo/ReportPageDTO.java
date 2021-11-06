package com.team4.joopging.admin.vo;

import com.team4.joopging.community.vo.Criteria;
import lombok.Data;
import org.springframework.stereotype.Component;
//신고한 글 목록 보는 페이지의 페이징 연산
//게시글의 페이징과 별개로 진행하고 싶을 수 있으니 따로 생성.
@Component
@Data
public class ReportPageDTO {
    private int pageCount;
    private int startPage;
    private int endPage;
    private int realEnd;
    private boolean prev, next;
    private int total;
    private ReportCriteria reportCriteria;

    public ReportPageDTO(){;}

    public ReportPageDTO(int total, int pageCount, ReportCriteria reportCriteria) {
        this.total = total;
        this.pageCount = pageCount;
        this.reportCriteria = reportCriteria;

        this.endPage = (int)Math.ceil(reportCriteria.getPageNum() * 1.0 / pageCount) * pageCount;
        this.startPage = endPage - (pageCount - 1);

        realEnd = (int)(Math.ceil(total *1.0 / reportCriteria.getAmount()));

        if(endPage > realEnd){
            endPage = realEnd == 0 ? 1 : realEnd;
        }
        prev = startPage > 1;
        next = endPage < realEnd;
    }
}
