package SynoCollection;

import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/7/24 11:22
 * @Version 1.0
 */
public class main {

    public static void main(String[] args) {
        CollectionDemo collectionDemo = new CollectionDemo();

        new Thread(()->{
            IntStream.rangeClosed(1,10).forEach(i->{
                collectionDemo.add(Thread.currentThread().getName() + i);
            });
        },"t1--》").start();

        new Thread(()->{
            IntStream.rangeClosed(1,10).forEach(i->{
                collectionDemo.add(Thread.currentThread().getName() + i);
            });
        },"t2--->").start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        collectionDemo.list();


    }
}
