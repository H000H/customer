package learn.customer.controller.threadpool;

import learn.customer.bean.UserBean;
import org.myfacade.facade.ProductFacade;

public class CallProduct implements Runnable{

    private ThreadCounter threadCounter;

    private UserBean userBean;

    private ProductFacade productFacade;

    @Override
    public void run() {
        try {
            long begin=System.currentTimeMillis();
            String end = productFacade.getProduct();
            long endt=System.currentTimeMillis();
            System.out.println("远程接口访问的时间是："+(endt-begin));
            if(end==null)
                throw new Exception("cuow");
            long begin1=System.currentTimeMillis();
            if (threadCounter.getCount() > 1000) {
                threadCounter.incFaild();
            } else {
                threadCounter.incSuccessed();
            }
            long end2=System.currentTimeMillis();
            System.out.println("自增的时间是："+(end2-begin1));
        }catch (Exception e){
            threadCounter.incFaild();
        }
    }

    public void setThreadCounter(ThreadCounter threadCounter){
        this.threadCounter=threadCounter;
    }
    public void setUserBean(UserBean uerBean){
        this.userBean=userBean;
    }

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }
}
