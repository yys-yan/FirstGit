package Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: hy
 * @Date: 2019/7/25 11:05
 * @Version 1.0
 */
public class main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<String> futureTask = new FutureTask<>(()->{
            System.out.println("xxxx");
            return "finish";
        });

        new Thread(futureTask).start();

        System.out.println("===============");
        Thread.sleep(1000);
        System.out.println(futureTask.get());

    }
}
