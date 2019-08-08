package Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: hy
 * @Date: 2019/8/7 14:42
 * @Version 1.0
 */
public class ConditionDemo {

    private static  volatile boolean isZero = true;

    private static Lock lock = new ReentrantLock();

    private static Condition c1 = lock.newCondition();

    private static int data = 0;

    public static void main(String[] args) {
        new Thread(()->produce()).start();
        new Thread(()->consume()).start();



    }

    public static void produce() {

        try {
            lock.lock();
            while (!isZero) {
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data++;
            isZero = false;
            System.out.println(Thread.currentThread().getName() + "---" + data);
            c1.signal();
        } finally {
            lock.unlock();
        }


    }
    public static void consume() {

        try {
            lock.lock();
            while (isZero) {
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data--;
            isZero = true;
            System.out.println(Thread.currentThread().getName() + "----" + data);
            c1.signal();
        } finally {
            lock.unlock();
        }


    }
}
