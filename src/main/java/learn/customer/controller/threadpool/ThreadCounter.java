package learn.customer.controller.threadpool;

/**
 * 线程计数器，提供线程执行的计数功能
 */
public class ThreadCounter {
    private Integer successed=0;
    private Integer failed=0;

    /**
     * 获取执行的总数
     * @return
     */
    public Integer getCount(){
        return successed+failed;
    }

    @Override
    public String toString() {
        return "失败："+failed+" 成功："+successed;
    }

    public ThreadCounter(){
    }

    /**
     * 执行成功的线程+1
     */
    public synchronized void incSuccessed(){
        successed++;
    }

    /**
     * 执行失败的线程+1
     */
    public synchronized void incFaild(){
        failed++;
    }
}
