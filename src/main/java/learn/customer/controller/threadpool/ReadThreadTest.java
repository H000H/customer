package learn.customer.controller.threadpool;

import org.myfacade.facade.ProductFacade;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReadThreadTest {
    @Resource
    private ThreadPoolTaskExecutor myThreadPool;

    @Resource
    private ProductFacade productFacade;

    public String test(){
        ThreadCounter threadCounter=new ThreadCounter();
        long begin=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            CallProduct callProduct=new CallProduct();
            callProduct.setThreadCounter(threadCounter);
            callProduct.setProductFacade(productFacade);
            myThreadPool.execute(callProduct);
        }
        while (threadCounter.getCount()!=10000){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long end=System.currentTimeMillis();
            System.out.println("心跳第n次,此时完成的个数为："+threadCounter.getCount()+" 使用时长为："+(end-begin));
        }
        System.out.println("线程运行完毕"+threadCounter.getCount()+threadCounter.toString());
        return "线程运行完毕"+threadCounter.getCount()+threadCounter.toString();
    }

}
