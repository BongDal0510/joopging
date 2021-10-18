package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommuMapper {
    //게시글 목록
    public List<CommuVO> getCommuList(Criteria criteria);

    //게시글 등록
    public void insertCommu(CommuVO commu);

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
}
