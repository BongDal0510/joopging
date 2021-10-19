package com.team4.joopging.mappers;

import com.team4.joopging.community.vo.CommuVO;
import com.team4.joopging.community.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CommuMapperTest {

    @Autowired
    private CommuMapper mapper;

    @Test
    public void testGetCommuList(){
        Criteria cri = new Criteria();
        cri.setPageNum(30);
        cri.setAmount(10);
        mapper.getCommuList(cri).forEach(commu -> log.info(commu.toString()));
    }

    @Test
    public void testInsertCommu() {

        CommuVO commu = new CommuVO();
        commu.setCommuTitle("새로 작성한 글 제목");
        commu.setCommuContent("새로 작성한 글 내용");
        commu.setCommuWriter("user009");
        mapper.insertCommu(commu);

    }

    @Test
    public void testUpdateCommuViewCnt(){
        if (mapper.readCommu(10518689L) == null) {
            log.info("*****No such Board*****");
        } else {
            log.info("Update Count : " + mapper.updateCommuViewCnt(10518689L));
        }
    }

    @Test
    public void testInsertSelectKey_commuBno() {

        CommuVO commu = new CommuVO();
        commu.setCommuTitle("새로 작성한 글 제목");
        commu.setCommuContent("새로 작성한 글 내용");
        commu.setCommuWriter("user009");
        mapper.insertSelectKey_commuBno(commu);

    }
    @Test
    //게시글 상세보기(게시글 한 개 가져오기)
    public void testReadCommu() {
        mapper.readCommu(6L);
    }

    @Test
    //게시글 수정
    public void testUpdateCommu() {

        if (mapper.readCommu(10518542L) == null) {
            log.info("*****No such Board*****");
        } else {
            CommuVO commu = new CommuVO();
            commu.setCommuTitle("수정한 작성한 글 제목");
            commu.setCommuContent("수정한 작성한 글 내용");
            commu.setCommuBno(10518542L);
            log.info("Update Count : " + mapper.updateCommu(commu));
        }
    }

    //게시글 삭제
    @Test
    public void testDeleteCommu() {
        if (mapper.readCommu(6L) == null) {
            log.info("*****No such Board*****");
        } else {
            log.info("Update Count : " + mapper.deleteCommu(6L));
        }
    }
}
