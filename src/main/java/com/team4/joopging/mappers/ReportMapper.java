package com.team4.joopging.mappers;

import com.team4.joopging.admin.vo.ReportCriteria;
import com.team4.joopging.admin.vo.ReportVO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    //신고 접수
    public void insertReport(ReportVO report);

    //게시글 -> 신고글로 변경
    public int commuToReported(Long commuBno);

    //게시글 목록
    public List<ReportVO> getReportList(ReportCriteria reportCriteria);

    //게시글 총 갯수
    public int getReportTotal(ReportCriteria reportCriteria);

    //게시글 상세보기
    public ReportVO readReport(Long reportNum);

    //게시글 삭제
    public int deleteReport(Long reportNum);
}
