package Atomic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/7/31 9:32
 * @Version 1.0
 */
public class AtomicIntegerDemo {
    // AtomicInteger 保证int 操作的原子性
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static Set s = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            IntStream.rangeClosed(1,500).forEach(j->{
                int a = atomicInteger.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + "-->" + a);
                s.add(a);

            });
        });
        executorService.execute(()->{
            IntStream.rangeClosed(1,500).forEach(j->{
                int a = atomicInteger.getAndIncrement();
                System.out.println(Thread.currentThread().getName() + "-->" + a);
                s.add(a);
            });
        });
        executorService.awaitTermination(5,TimeUnit.SECONDS);
        System.out.println(s.size());
    }
}
