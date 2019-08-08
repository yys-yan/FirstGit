package Future;

import java.util.concurrent.Executors;

/**
 * @Author: hy
 * @Date: 2019/7/25 10:26
 * @Version 1.0
 *
 * future 设计模式
 *
 * 去买蛋糕。
 * 1. 想商家订货
 *
 * 2. 商家让你回去等， 你继续做你自己的事
 *
 * 3. 自己事情忙完了去继续取数据
 */
public class main {

    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        //提交一个任务，等待响应结果
        // 参数是耗时任务
        AsyncFuture<String> future = futureService.submit(()->{
            Thread.sleep(3000);
            return "finish";
        });
        System.out.println("=============");
        System.out.println("xxxx");
        System.out.println("=============");

        // 一段时间后，在获取响应结果
        System.out.println(future.get());



    }

}
