package com.team4.joopging.services;

import com.team4.joopging.community.dao.ReportDAO;
import com.team4.joopging.report.vo.ReportVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImple implements ReportService{

    private final ReportDAO reportDAO;

    @Override
    public void insertReport(ReportVO report) {
        reportDAO.insertReport(report);
    }

    @Override
    public boolean commuToReported(Long commuBno) {
        return reportDAO.commuToReported(commuBno);
    }
}
