package CountDownLatch;

import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/8/1 10:05
 * @Version 1.0
 *
 * CountDownLatch(int count) //实例化一个倒计数器，count指定计数个数
 * countDown() // 计数减一
 * await() //等待，当计数减到0时，所有线程并行执行
 *
 * 1. 首先创建任务个数的计数器
 * 2. 每个任务执行完，计数器减1
 * 3.
 */
public class CountDownLatchDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws InterruptedException {
        int[] intArr = new int[]{1,2,3,4,5,6,7,8,9,10};

        IntStream.rangeClosed(1,10).forEach(i->{
            executorService.execute(new SimpleRunnable(intArr,i-1));
        });
        // 等待其他线程完在执行
//        executorService.shutdown();
//        executorService.awaitTermination(1, TimeUnit.HOURS);
        countDownLatch.await();
        IntStream.rangeClosed(1,10).forEach(i->{
            System.out.println(intArr[i-1]);
                }
        );
    }
    static class SimpleRunnable implements Runnable {
        private int[] data;
        private int index;

        public SimpleRunnable(int[] data, int index) {
            this.data = data;
            this.index = index;
        }

        @Override
        public void run() {
            if (this.data[this.index] % 2 == 0) {
                this.data[this.index] += 2;
            }else {
                this.data[this.index] -= 1;
            }
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName());

        }
    }


}
