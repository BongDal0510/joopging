package com.team4.joopging.community.dao;

import com.team4.joopging.mappers.ReportMapper;
import com.team4.joopging.report.vo.ReportVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReportDAO {
    private final ReportMapper reportMapper;
/*    private final CommuMapper commuMapper;*/

    /*댓글 등록*/
    public void insertReport(ReportVO report){
        reportMapper.insertReport(report);
    }
/*    *//*특정 게시물 가져오기*//*
    public CommuVO getCommu(Long commuBno){
        return commuMapper.readCommu(commuBno);
    }*/
    /*게시글 status 수정하기*/
    public boolean commuToReported(Long commuBno){
        return reportMapper.commuToReported(commuBno) == 1;
    }

}
