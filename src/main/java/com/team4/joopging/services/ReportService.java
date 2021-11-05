package com.team4.joopging.services;

import com.team4.joopging.report.vo.ReportVO;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {
    //신고 접수
    public void insertReport(ReportVO report);
    //게시글 -> 신고글로 변경
    public boolean commuToReported(Long commuBno);
}
