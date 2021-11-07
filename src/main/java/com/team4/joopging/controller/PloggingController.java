package com.team4.joopging.controller;


import com.team4.joopging.plogging.vo.PloggingCriteria;
import com.team4.joopging.plogging.vo.PloggingDTO;
import com.team4.joopging.plogging.vo.PloggingVO;
import com.team4.joopging.services.PloggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/plo/*")
@RequiredArgsConstructor
public class PloggingController {

    private final PloggingService ploggingService;

    /*플로깅 소개페이지*/
    @GetMapping("info")
    public String info(){
        return "ploggingReservation/ploInfo";
    }

    /*플로깅 상세페이지*/
    @GetMapping("ploresinfo")
    public String ploResInfo(){
        return "ploggingReservation/ploResInfo";
    }

    /*플로깅 목록 페이지*/
    @GetMapping("ploreslist")
    public String ploreslist(PloggingCriteria ploggingCriteria, Model model) {
        model.addAttribute("list", ploggingService.getList(ploggingCriteria));
        model.addAttribute("pageMaker", new PloggingDTO(ploggingService.getTotal(), 10, ploggingCriteria));
        return "ploggingReservation/ploResList";
    }

    /*플로깅 결제 팝업 창*/
    @GetMapping("payment")
    public String payMent(){ return "ploggingReservation/payMent"; }

    /*플로깅 글쓰기 창*/
    @GetMapping("ploWritePop")
    public String plowritePop(){ return "ploggingReservation/ploggingWrite"; }

    /*플로깅 글쓰기 완료 후 디비 저장*/
    @PostMapping("ploWrite")
    public String ploWrite(PloggingVO vo){
        log.info("-------------------------");
        log.info(vo.toString());
        log.info("-------------------------");
        ploggingService.register(vo);
        return "/writeSuccess";
    }


    /*테스트 버튼*/
    @GetMapping("writeSuccess")
    public String writeSuccess(){
        return "ploggingReservation/button";
    }
}
