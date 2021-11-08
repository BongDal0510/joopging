package com.team4.joopging.controller;


import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.community.vo.InquiryReplyPageDTO;
import com.team4.joopging.community.vo.InquiryReplyVO;
import com.team4.joopging.services.InquiryReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController//REST
@Slf4j
@RequestMapping("/inqReplies/*")
@RequiredArgsConstructor
public class InquiryReplyController {

    private final InquiryReplyService inquiryReplyService;

    /*댓글 등록*/
    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody InquiryReplyVO inquiryReplyVO) throws UnsupportedEncodingException{

        int replyCount = inquiryReplyService.registerInquiryReply(inquiryReplyVO);
        log.info("inquiryReplyVO : " + inquiryReplyVO);
        log.info("REPLY INSERT COUNT : " + replyCount);

        return replyCount == 1 ?
                new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //게시글 댓글 전체 조회
    @GetMapping("pages/{inquiryNum}/{page}")
    public InquiryReplyPageDTO getInquiryReplyPagingList(@PathVariable("inquiryNum") Long inquiryNum, @PathVariable("page") int page){
        log.info("getList--------------------------------");
        Criteria criteria = new Criteria(page, 10);
        log.info(criteria.toString());
        return inquiryReplyService.getInquiryReplyPagingList(inquiryNum, criteria);
    }
    //댓글조회
    //URI에 댓글 번호만 작성한다.
    //전달받은 rno를 JSON으로 리턴한다.

    //1. rno는 보여져도 상관 없는 정보.
    @GetMapping("{inquiryRno}")
    public InquiryReplyVO getInquiryReply(@PathVariable("inquiryRno") Long inquiryRno){
        log.info("get--------------------------------");
        return inquiryReplyService.getInquiryReply(inquiryRno);
    }

    //댓글 수정 (쿼리문 참조) 전체 테이블이 아니라 쿼리에 명시된 컬럼들을 기준으로 한다.
    //PUT : 자원의 전체 수정, 자원 내 모든 필드럴 전달해야함. 일부만 전달할 경우 오류
    //PATCH : 자원의 일부 수정, 수정할 필드만 전송 (자동 주입이 아닌 부분만 수정하는 쿼리문에서 사용)
    //PATCH가 PUT을 담고 있기 때문에 전체를 전달 받아서 전체를 수정하거나, 부분만 수정하는 상황 모두 PATCH를 사용하는 것이 좋다.
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value="{inquiryRno}",
            consumes = "application/json", produces = "text/plain; charset=UTF-8")
    //제이슨 데이터 = 바디
    public ResponseEntity<String> modify(@RequestBody InquiryReplyVO inquiryReplyVO, @PathVariable("inquiryRno") Long inquiryRno) throws UnsupportedEncodingException {
        log.info("modify...................");
        inquiryReplyVO.setInquiryRno(inquiryRno);
        return inquiryReplyService.modifyInquiryReply(inquiryReplyVO) == 1 ?
                new ResponseEntity<>(new String("댓글 수정 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @DeleteMapping(value="{inquiryRno}", produces = "text/plain; charset=UTF-8")
    public ResponseEntity<String> remove(@PathVariable("inquiryRno") Long inquiryRno) throws UnsupportedEncodingException{
        log.info("remove...................");
        return inquiryReplyService.removeInquiryReply(inquiryRno) == 1 ?
                new ResponseEntity<>(new String("댓글 삭제 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
