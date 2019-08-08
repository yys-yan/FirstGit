package BlockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: hy
 * @Date: 2019/7/30 9:22
 * @Version 1.0
 */
public class BlockingQueueDemo {
    // put 存放数据
    // take 取数据
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
        blockingQueue.put("aa");
        blockingQueue.put("bb");
        System.out.println("aaaa");
        blockingQueue.put("xccxx");
        System.out.println("xxx");
    }
}
