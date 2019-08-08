package ThreadPool;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/7/29 14:28
 * @Version 1.0
 */
public class CacheThreadPoolDemo {

    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //执行任务
        executorService.execute(()->{
            IntStream.rangeClosed(1,10).forEach(i->{
                System.out.println("xxxxxxx");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });


    }
}
