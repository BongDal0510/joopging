package com.team4.joopging.mappers;


import com.team4.joopging.community.vo.CommuReplyVO;
import com.team4.joopging.community.vo.Criteria;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;
@SpringBootTest
@Slf4j
public class CommuReplyMapperTest {
    private Long[] arBno = {114768L, 114767L, 114766L, 114765L, 114764L};

    @Setter(onMethod_ = @Autowired)
    private CommuReplyMapper commuReplyMapper;

    @Test
    public void testMapper(){
        log.info(commuReplyMapper.toString());
    }


    //    5칸 배열 만들기(게시글 번호 투입)
//    5개의 게시글에 2개씩 댓글 달기
    @Test
    public void testInsertCommuReply(){
        IntStream.rangeClosed(1, 10).forEach(i -> {
            CommuReplyVO reply = new CommuReplyVO();
            reply.setCommuBno(arBno[i % 5]);
            reply.setCommuReply("댓글 테스트1111" + i);
            reply.setCommuReplier("replier1111" + i);
            commuReplyMapper.insertCommuReply(reply);
        });
    }

    @Test
    public void testReadCommuReply(){
        log.info(commuReplyMapper.readCommuReply(10L).toString());
    }

    @Test
    public void testDeleteCommuReply(){
        log.info("DELETE COUNT : " + commuReplyMapper.deleteCommuReply(15L));
    }

    @Test
    public void testUpdateCommuReply(){
        CommuReplyVO replyVO = commuReplyMapper.readCommuReply(12L);
        replyVO.setCommuReply("UPDATE TEST");
        log.info("UPDATE COUNT : " + commuReplyMapper.updateCommuReply(replyVO));
    }
    @Test
    public void testGetCommuReplyPagingList(){
        Criteria criteria = new Criteria();
        commuReplyMapper.getCommuReplyPagingList(arBno[0], criteria).forEach(reply -> log.info(reply.toString()));
    }

}
