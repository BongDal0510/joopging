package com.team4.joopging.services;

import com.team4.joopging.admin.vo.ReportCriteria;
import com.team4.joopging.admin.vo.ReportVO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    //신고 접수
    public void insertReport(ReportVO report);
    //게시글 -> 신고글로 변경
    public boolean commuToReported(Long commuBno);
    //report 상세보기
    public ReportVO readReport(Long reportNum);
    //report 전체 목록
    public List<ReportVO> getReportList(ReportCriteria reportCriteria);
    //report 전체 글 개수
    public int getReportTotal(ReportCriteria reportCriteria);
}
