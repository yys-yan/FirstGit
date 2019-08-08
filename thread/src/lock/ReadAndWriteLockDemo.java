package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: hy
 * @Date: 2019/8/7 11:00
 * @Version 1.0
 */
public class ReadAndWriteLockDemo {
    /**
     *  读写锁。
     *  只能同时读， 但不可同时写或者同时读写
     */
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    private static final Lock readLock = lock.readLock();
    private static final Lock writeLock = lock.writeLock();

    public static void main(String[] args) throws Exception {
        new Thread(ReadAndWriteLockDemo::read).start();
        new Thread(ReadAndWriteLockDemo::read).start();

    }
    public static void read(){
        readLock.lock();
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        readLock.unlock();
    }

    public static void write() {
        writeLock.lock();
        System.out.println("write lock");
        writeLock.lock();
    }
}
