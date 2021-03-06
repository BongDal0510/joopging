package com.team4.joopging.controller;

import com.team4.joopging.community.vo.CommuReplyPageDTO;
import com.team4.joopging.community.vo.CommuReplyVO;
import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.services.CommuReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@Slf4j
@RequestMapping("/replies/*")
@RequiredArgsConstructor
public class CommuReplyController {

    private final CommuReplyService commuReplyService;

    /*댓글 등록*/

    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody CommuReplyVO commuReplyVO) throws UnsupportedEncodingException{

        int replyCount = commuReplyService.registerCommuReply(commuReplyVO);
        log.info("commuReplyVO : " + commuReplyVO);
        log.info("REPLY INSERT COUNT : " + replyCount);

        return replyCount == 1 ?
                new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //게시글 댓글 전체 조회
    @GetMapping("pages/{bno}/{page}")
    public CommuReplyPageDTO getCommuReplyList(@PathVariable("commuBno") Long commuBno, @PathVariable("page") int page){
        log.info("getList--------------------------------");
        Criteria criteria = new Criteria(page, 10);
        log.info(criteria.toString());
        return commuReplyService.getCommuReplyList(commuBno, criteria);
    }
    //댓글조회
    //URI에 댓글 번호만 작성한다.
    //전달받은 rno를 JSON으로 리턴한다.

    //1. rno는 보여져도 상관 없는 정보.
    @GetMapping("pages/{commuRno}")
    public CommuReplyVO getCommuReply(@PathVariable("commuRno") Long commuRno){
        log.info("get--------------------------------");
        return commuReplyService.getCommuReply(commuRno);
    }

    //댓글 수정 (쿼리문 참조) 전체 테이블이 아니라 쿼리에 명시된 컬럼들을 기준으로 한다.
    //PUT : 자원의 전체 수정, 자원 내 모든 필드럴 전달해야함. 일부만 전달할 경우 오류
    //PATCH : 자원의 일부 수정, 수정할 필드만 전송 (자동 주입이 아닌 부분만 수정하는 쿼리문에서 사용)
    //PATCH가 PUT을 담고 있기 때문에 전체를 전달 받아서 전체를 수정하거나, 부분만 수정하는 상황 모두 PATCH를 사용하는 것이 좋다.
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value="pages/{rno}",
            consumes = "application/json", produces = "text/plain; charset=UTF-8")
    //제이슨 데이터 = 바디
    public ResponseEntity<String> modify(@RequestBody CommuReplyVO commuReplyVO, @PathVariable("commuRno") Long commuRno) throws UnsupportedEncodingException {
        log.info("modify...................");
        commuReplyVO.setCommuRno(commuRno);
        return commuReplyService.modifyCommuReply(commuReplyVO) == 1 ?
                new ResponseEntity<>(new String("댓글 수정 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @DeleteMapping(value="pages/{commuRno}", produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> remove(@PathVariable("commuRno") Long commuRno) throws UnsupportedEncodingException{
        log.info("remove...................");
        return commuReplyService.removeCommuReply(commuRno) == 1 ?
                new ResponseEntity<>(new String("댓글 삭제 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
