package com.team4.joopging.admin.dao;

import com.team4.joopging.admin.vo.ReportCriteria;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.mappers.ReportMapper;
import com.team4.joopging.admin.vo.ReportVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReportDAO {
    private final ReportMapper reportMapper;

    /*댓글 등록*/
    public void insertReport(ReportVO report){
        reportMapper.insertReport(report);
    }

    /*게시글 status 수정하기*/
    public boolean commuToReported(Long commuBno){
        return reportMapper.commuToReported(commuBno) == 1;
    }

    /*특정 게시물 가져오기*/
    public ReportVO readReport(Long reportNum){
        return reportMapper.readReport(reportNum);
    }

    /*전체 목록*/
    public List<ReportVO> getReportList(ReportCriteria reportCriteria){
        return reportMapper.getReportList(reportCriteria);
    }
    /*전체 게시글 수*/
    public int getReportTotal(ReportCriteria reportCriteria){ return reportMapper.getReportTotal(reportCriteria);}

}
