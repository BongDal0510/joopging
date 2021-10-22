package com.team4.joopging.community.dao;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommuDAO_test {
    @Autowired
    private CommuDAO commuDAO;

    @Test
    public void testRegisterCommu(){
        CommuVO commu = new CommuVO();
        commu.setCommuTitle("새로 작성하는 글3");
        commu.setCommuContent("새로 작성하는 내용3");
        commu.setCommuWriter("hds1204");

        commuDAO.registerCommu(commu);
        log.info("-------------------------------");
        log.info(commu.getCommuBno() + "");
        log.info("-------------------------------");
    }

    @Test
    public void testGet(){
        log.info(commuDAO.getCommu(3L).toString());
    }

    @Test
    public void testModify() {
        if (commuDAO.getCommu(3L) == null) {
            log.info("***********NO SUCH BOARD***********");
        } else {
            CommuVO commu = new CommuVO();
            commu.setCommuBno(3L);
            commu.setCommuTitle("수정된 글 제목");
            commu.setCommuContent("수정된 글 내용");
            log.info("UPDATE : " + commuDAO.modifyCommu(commu));
        }
    }

    @Test
    public void testRemove(){
        if (commuDAO.getCommu(3L) == null) {
            log.info("***********NO SUCH BOARD***********");
        }else{
            log.info("REMOVE : " + commuDAO.removeCommu(3L));
        }
    }

    @Test
    public void testGetList(){
        Criteria criteria = new Criteria();
        commuDAO.getCommuList(criteria).forEach(commu -> log.info(commu.toString()));
    }

    @Test
    public void testGetAnnounceList(){
        CommuVO announce = new CommuVO();
        commuDAO.getAnnounceList(announce.getCommuBoardStatus());
    }

}