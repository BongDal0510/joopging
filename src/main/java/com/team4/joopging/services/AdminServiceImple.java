package com.team4.joopging.services;

import com.team4.joopging.admin.dao.ReportDAO;
import com.team4.joopging.admin.vo.ReportCriteria;
import com.team4.joopging.admin.vo.ReportVO;
import com.team4.joopging.community.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImple implements AdminService {

    private final ReportDAO reportDAO;

    @Override
    public void insertReport(ReportVO report) {
        reportDAO.insertReport(report);
    }

    @Override
    public boolean commuToReported(Long commuBno) {
        return reportDAO.commuToReported(commuBno);
    }

    @Override
    public ReportVO readReport(Long reportNum) {
        return reportDAO.readReport(reportNum);
    }

    @Override
    public List<ReportVO> getReportList(ReportCriteria reportCriteria) {
        return reportDAO.getReportList(reportCriteria);
    }
    @Override
    public int getReportTotal(ReportCriteria reportCriteria) {
        return reportDAO.getReportTotal(reportCriteria);
    }
}
