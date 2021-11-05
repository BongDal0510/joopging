package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.report.vo.ReportVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {
    //신고 접수
    public void insertReport(ReportVO report);

    //게시글 -> 신고글로 변경
    public int commuToReported(Long commuBno);
}
