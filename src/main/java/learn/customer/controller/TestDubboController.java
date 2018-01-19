package learn.customer.controller;

import org.myfacade.facade.ProductFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("dubbo")
public class TestDubboController  {
    @Resource
    ProductFacade productFacade;

    @RequestMapping("test")
    @ResponseBody
    public String getHollean(){
        String str;
        str=productFacade.getProduct();
        //多线程的访问
//        String strings=getStrings();
        return str;
    }

    public String getStrings(){
        StringBuffer buffer=new StringBuffer("begin:");
        for(int i=0;i<50;i++){
            MyThread myThread=new MyThread(buffer);
            Thread thread=new Thread(myThread);
            thread.start();
            System.out.println("线程"+thread.getName()+"开始执行");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public class MyThread implements Runnable{
        public StringBuffer buffer;
        public MyThread(StringBuffer buffer){
            this.buffer=buffer;
        }
        @Override
        public void run() {
            String str;
            str=productFacade.getProduct();
            buffer.append(str);
        }
    }

}
