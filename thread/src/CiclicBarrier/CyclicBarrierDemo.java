package CiclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: hy
 * @Date: 2019/8/5 11:07
 * @Version 1.0
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier c1 = new CyclicBarrier(2);

        new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
            try {
                c1.await();
                System.out.println("xxxx1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            System.out.println(Thread.currentThread().getName());
//            try {
//                c1.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
        }).start();

        System.out.println("==========wait");



    }
}
