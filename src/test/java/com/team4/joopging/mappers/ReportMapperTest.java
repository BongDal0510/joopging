package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.admin.vo.ReportVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReportMapperTest {

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private CommuMapper commuMapper;

    @Test
    public void testInsertReport() {
        ReportVO report = new ReportVO();
        report.setSessionId("신고한사람임");
        report.setReportContent("청소년 유해 매체");
        report.setCommuBno(229548L);
        report.setCommuTitle("안녕");
        reportMapper.insertReport(report);
    }

    @Test
    public void testCommuToReported(){
        CommuVO commu = new CommuVO();
        ReportVO report = new ReportVO();
        if (commuMapper.readCommu(116960L) == null) {
            log.info("*****No such Board*****");
        } else {
            log.info("Update Count : " + reportMapper.commuToReported(116960L));
        }
    }
/*(229548, '안녕', '신고글 테스트중이야', 'user06', 1);*/
}
