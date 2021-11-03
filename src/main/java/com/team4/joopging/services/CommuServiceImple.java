package com.team4.joopging.services;

import com.team4.joopging.community.dao.CommuAttachFileDAO;
import com.team4.joopging.community.dao.CommuDAO;
import com.team4.joopging.community.vo.CommuAttachFileVO;
import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommuServiceImple implements CommuService{

    private final CommuDAO commuDAO;
    private final CommuAttachFileDAO commuAttachFileDAO;

    //게시글 등록 with 첨부파일
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void registerCommu(CommuVO commu) {
        commuDAO.registerCommu(commu);
        if(commu.getAttachList() == null || commu.getAttachList().size() == 0){
            return;
        }

        commu.getAttachList().forEach(attach -> {
            attach.setCommuBno(commu.getCommuBno());
            commuAttachFileDAO.insert(attach);
        });
    }

    //게시글 하나 조회
    @Override
    public CommuVO getCommu(Long commuBno) {
        return commuDAO.getCommu(commuBno);
    }

    //게시글 수정
    @Override
    public boolean modifyCommu(CommuVO commu) {
        boolean boardModifyResult = false;

        commuAttachFileDAO.deleteAll(commu.getCommuBno());
        boardModifyResult = commuDAO.modifyCommu(commu);

        if(boardModifyResult && commu.getAttachList() != null && commu.getAttachList().size() != 0){
            commu.getAttachList().forEach(attach -> {
                attach.setCommuBno(commu.getCommuBno());
                commuAttachFileDAO.insert(attach);
            });
        }
        return boardModifyResult;
    }
    //게시글 삭제
    @Override
    public boolean removeCommu(Long commuBno) {
        return commuDAO.removeCommu(commuBno);
    }

    //전체 리스트
    @Override
    public List<CommuVO> getCommuList(Criteria criteria) {
        return commuDAO.getCommuList(criteria);
    }

    //전체 글 개수
    @Override
    public int getCommuTotal(Criteria criteria) { return commuDAO.getCommuTotal(criteria); }

    //조회수 올리기
    @Override
    public boolean updateCommuViewCnt(Long commuBno) { return commuDAO.updateCommuViewCnt(commuBno); }

    //공지글 리스트
    @Override
    public List<CommuVO> getAnnounceList(int commuBoardStatus) { return commuDAO.getAnnounceList(commuBoardStatus); }

    //첨부파일
    @Override
    public List<CommuAttachFileVO> getAttachList(Long commuBno) {
        return commuAttachFileDAO.findByBno(commuBno);
    }
}