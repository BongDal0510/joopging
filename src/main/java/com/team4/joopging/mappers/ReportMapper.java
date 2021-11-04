package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.report.vo.ReportVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReportMapper {
/*
    //게시글 목록
    public List<CommuVO> getCommuList(Criteria criteria);
*/

    //신고 접수
    public void insertReport(ReportVO report);

    //게시글 -> 신고글로 변경
    public int commuToReported(Long commuBno);
    /*

    //등록한 게시글의 PK가져오기 = bno
    public void insertSelectKey_commuBno(CommuVO commu);

    //게시글 상세보기
    public CommuVO readCommu(Long commuBno);

    //게시글 수정
    public int updateCommu(CommuVO commu);

    //게시글 삭제
    public int deleteCommu(Long commuBno);

    //게시글 총 갯수
    public int getCommuTotal(Criteria criteria);

    //게시글 조회수
    public int updateCommuViewCnt(Long commuBno);

    //공지글 가져오기
    public List<CommuVO> getAnnounceList(int commuBoardStatus);
*/
}
