package com.team4.joopging.services;


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
public class CommuReplyServiceTest {
    private Long[] arBno = {114768L, 114767L, 114766L, 114765L, 114764L};

    @Setter(onMethod_ = @Autowired)
    private CommuReplyService commuReplyService;

    @Test
    public void testCommuReplyService(){
        log.info(commuReplyService.toString());
    }


    //    5칸 배열 만들기(게시글 번호 투입)
//    5개의 게시글에 2개씩 댓글 달기
    @Test
    public void testRegisterCommuReply() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            CommuReplyVO reply = new CommuReplyVO();
            reply.setCommuBno(arBno[i % 5]);
            reply.setCommuReply("댓글 테스트1111" + i);
            reply.setCommuReplier("replier1111" + i);
            commuReplyService.registerCommuReply(reply);
        });
    }

    @Test
    public void testGetCommuReply(){
        log.info(commuReplyService.getCommuReply(10L).toString());
    }

    @Test
    public void testRemoveCommuReply(){
        log.info("DELETE COUNT : " + commuReplyService.removeCommuReply(15L));
    }

    @Test
    public void testModifyCommuReply(){
        CommuReplyVO replyVO = commuReplyService.getCommuReply(12L);
        replyVO.setCommuReply("UPDATE TEST");
        log.info("UPDATE COUNT : " + commuReplyService.modifyCommuReply(replyVO));
    }

    @Test
    public void testGetCommuReplyPagingList(){
        Criteria criteria = new Criteria();
        commuReplyService.getCommuReplyPagingList(arBno[0], criteria).getList().forEach(reply -> log.info(reply.toString()));
    }

}
