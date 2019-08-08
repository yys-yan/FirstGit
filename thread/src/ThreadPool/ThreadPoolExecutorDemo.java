package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: hy
 * @Date: 2019/7/30 10:00
 * @Version 1.0
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 阻塞，直到线程池的线程任务执行完
        executor.awaitTermination(1,TimeUnit.HOURS);
        System.out.println("coreNum" + executor.getCorePoolSize());
        System.out.println("activeNum" + executor.getActiveCount());
        System.out.println("maxNum" + executor.getMaximumPoolSize());
        System.out.println("queueNum" + executor.getQueue().size());


    }

    public static ThreadPoolExecutor buildThreadPoolExecutor(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1,
                2,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1));
        threadPoolExecutor.execute(()->sleep(60));
        threadPoolExecutor.execute(()->sleep(60));
        threadPoolExecutor.execute(()->sleep(60));
//        threadPoolExecutor.execute(()->sleep(60));
        /**
         *  一个任务： 线程池线程数量1，执行任务1， 任务队列 0
         *  两个任务： 线程池线程数量1，执行任务1， 任务队列 1
         *  三个任务： 线程池线程数量2，执行任务2， 任务队列 1
         *  四个任务： 线程池线程数量2，执行任务2， 任务队列超过队列最大值，产生拒绝策略
         */
        return threadPoolExecutor;
    }
    public static void sleep(long seconds){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
