package com.team4.joopging.controller;


import com.team4.joopging.beans.vo.ShopCriteria;
import com.team4.joopging.beans.vo.ShopPageDTO;
import com.team4.joopging.beans.vo.ShopVO;
import com.team4.joopging.services.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/shop/*")
@RequiredArgsConstructor
public class shopController {

    private final ShopService shopService;

    /*아무 연산 없이 샵 페이지로 이동*/
    @GetMapping("shop")
    public String shop(ShopCriteria shopCriteria, Model model){
        log.info("-----------------------------------");
        log.info("list");
        log.info("-----------------------------------");
        model.addAttribute("shop", shopService.goodsGetList(shopCriteria));
        model.addAttribute("pageMaker", new ShopPageDTO(20, 4, shopCriteria));
        return "shop";
    }


    @PostMapping("shopEnroll")
    public RedirectView shopEnroll(ShopVO shopVO, RedirectAttributes rttr){
        log.info("----------------------");
        log.info("register : " + shopVO.toString());
        log.info("----------------------");
        /* 뷰딴에 전달하려고 model 객체 필요(받는것은 자동으로됨) */
        shopService.goodsRegister(shopVO);
        /* 샵뒤에 쿼리스트링 결과가 나타남 */
//      rttr.addAttribute("goodsNum", shopVO.getGoodsNum());
        /* 세션의 플래쉬 영역을 이용하여 전달 */
        rttr.addFlashAttribute("goodsNum",shopVO.getGoodsNum());
        /* RedirectView 를 사용하면 redirect 방식으로 전송이 가능하다.*/
        return new RedirectView("shop");
    }


    @GetMapping("shopEnroll")
    public String shopEnroll(){
        return "shopEnroll";
    }

    @GetMapping("shopDetail")
    public void shopDetail(@RequestParam("goodsNum") Long goodsNum, Model model) {
        log.info("----------------------");
        log.info("detail : " + goodsNum);
        log.info("----------------------");

        model.addAttribute("shop", shopService.goodsGet(goodsNum));

      }











    @GetMapping("successPayment")
    public String successPayment() {return "successPayment";}

    @GetMapping("failPayment")
    public String failPayment() {return "failPayment";}

    @GetMapping("header")
    public String header() {
        return "header";
    }

    @GetMapping("shop_header")
    public String shop_header() { return "shop_header";}

    @GetMapping("shopPayment")
    public String shopPayment() { return "shopPayment";}

    @GetMapping("footer")
    public String footer() {
        return "footer";
    }


}



