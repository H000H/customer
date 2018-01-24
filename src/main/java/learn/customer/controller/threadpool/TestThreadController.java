package learn.customer.controller.threadpool;

import learn.customer.controller.threadpool.ReadThreadTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("dubbo")
public class TestThreadController {
    @Resource
    private ReadThreadTest readThreadTest;

    @RequestMapping("thread")
    @ResponseBody
    public String multThread(){
        long begintime=System.currentTimeMillis();
        String result=readThreadTest.test();
        long endtime=System.currentTimeMillis();
        System.out.println("最后使用的时间是："+(endtime-begintime));
        return result;
    }

}
