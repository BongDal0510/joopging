package com.team4.joopging.controller;

import com.team4.joopging.community.vo.Criteria;
import com.team4.joopging.point.vo.PointVO;
import com.team4.joopging.services.MemberService;
import com.team4.joopging.services.MypageService;
import com.team4.joopging.services.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.time.LocalDate;

@Controller
@Slf4j
@RequestMapping("orderhistory/*")
@RequiredArgsConstructor
public class OrderHistoryController {

    private final MypageService mypageSVC;
    private final PointService pointSVC;
    private final MemberService memberSVC;

    /*구매 상품 상세보기 이동*/
    @GetMapping("orderInfo")
    public String orderInfo(@RequestParam("orderNum") int orderNum, Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        String memberId = (String)session.getAttribute("memberId");

        model.addAttribute("order", mypageSVC.getOrderHistory(orderNum));
        model.addAttribute("member",memberSVC.memberAllSelect(memberId));
//        model.addAttribute("parcel",mypageSVC.getParcel(orderNum));

        return "mypage/orderInfo";
    }

    /*택배 내역(파업창)*/
    @PostMapping("deliveryTracking")
    public String deliveryTracking(){ return "mypage/deliveryTracking"; }


    /*구매 취소(파업창)*/
    @RequestMapping(value = "/refundOrderPage", method = RequestMethod.GET)
    public String refundOrderPage(Model model, @RequestParam("orderNum") int orderNum) throws IOException {
        model.addAttribute("order", mypageSVC.getOrderHistory(orderNum));
        return "/mypage/goodsRefund";
    }

    /*구매 취소하기*/
    @PostMapping("goodsRefund")
    public String goodsRefund(Model model, @RequestParam("orderNum") int orderNum){
        if(mypageSVC.deleteGoodsOrder(orderNum)){
            PointVO vo = new PointVO();
            vo.setHistory(mypageSVC.getOrderHistory(orderNum).getGoodsName()+" 구매 취소");
            vo.setPoint(mypageSVC.getOrderHistory(orderNum).getUsePoint());
            vo.setMemberNum(mypageSVC.getOrderHistory(orderNum).getMemberNum());
            vo.setPointStatus("취소");
            pointSVC.addPoint(vo);
            model.addAttribute("msg", "refundOrder");
        }else{
            model.addAttribute("msg", "notRefundOrder");
        }
        return "mypage/resultpage";
    }

    /*해더*/
    @GetMapping("/pageframe/header")
    public String header() {return "/pageframe/header";}

    /*푸터*/
    @GetMapping("/pageframe/footer")
    public String footer() {return "/pageframe/footer";}

}
