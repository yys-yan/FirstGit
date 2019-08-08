package synchronize;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: hy
 * @Date: 2019/4/30 15:56
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        //使用同一个对象作锁，锁就是这个对象，
        // 一个线程访问同步方法时，另外的线程不管是访问同一个方法还是另外的同步方法都会阻塞，
//        Value value = new Value();
//
//        new Thread(new Runnable1(value)).start();
//        new Thread(new Runnable2(value)).start();

//
//        System.out.println("分隔符----------------------------------------");
//        //使用不同对象作为锁，会出现锁不住的情况
//        Value value1 = new Value();
//        Value value2 = new Value();
//
//        new Thread(new Runnable1(value1)).start();
//        new Thread(new Runnable2(value2)).start();

        //可重入锁:
        System.out.println("分隔符----------------------------------------");
        new Thread(new Runnable1(new Value())).start();

//        System.out.println("分隔符----------------------------------------");
//        //一个线程访问静态同步方法时，另外的线程不管是访问同一个方法还是另外的静态同步方法都会阻塞，
//        //Synchronized 修饰静态方法时，锁住的是这个类的所有对象
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//
//                for (int i=0;i<10;i++){
//                    System.out.println("线程1----"+Value.getValue3());
//                }
//            }
//        }).start();
//
//
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//
//                for (int i=0;i<10;i++){
//                    System.out.println("线程2----"+Value.getValue4());
//                }
//            }
//        }).start();





    }

}
