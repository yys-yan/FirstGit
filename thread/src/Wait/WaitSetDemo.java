package Wait;

import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/7/23 10:43
 * @Version 1.0
 */
public class WaitSetDemo {
    public static final Object lock = new Object();
    public static void main(String[] args) {

        IntStream.rangeClosed(1,10).forEach(i->{
            new Thread(()->{
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + "come");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "leave");
                }
            },String.valueOf(i)).start();
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IntStream.rangeClosed(1,8).forEach(i->{
            synchronized (lock){
                lock.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
