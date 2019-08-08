package synchronize;

import java.util.concurrent.locks.Lock;

/**
 * @Author: hy
 * @Date: 2019/4/30 15:50
 * @Version 1.0
 */
public class Value {

    private int value;

    private static int value1;

    // 不加synchronized 容易出现线程安全问题
    public synchronized int getValue()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = value+1;
        System.out.println("ooo"+value);
        //演示可重入锁，  在一个同步同步方法种调用另外一个同步方法，
        //当前线程并不会阻塞，因为获取的是同一把锁
        getValue5();

        return value;
    }

    public synchronized int getValue2()  {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = value+1;


        return value;
    }

    public synchronized int getValue5()  {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = value +1;
        System.out.println("xxx"+value);


        return value;
    }




    public synchronized static int getValue3(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value1 = value1+1;


        return value1;
    }

    public synchronized static int getValue4(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value1 = value1+1;


        return value1;
    }
}
