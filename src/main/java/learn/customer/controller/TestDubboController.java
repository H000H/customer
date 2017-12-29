package learn.customer.controller;

import org.myfacade.facade.ProductFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("dubbo")
public class TestDubboController {
    @Resource
    ProductFacade productFacade;

    @RequestMapping("test")
    @ResponseBody
    public String getHollean(){
        String str;
        str=productFacade.getProduct();
        return str;
    }

}
