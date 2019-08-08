package ThreadGroup;

/**
 * @Author: hy
 * @Date: 2019/7/9 16:10
 * @Version 1.0
 */
public class ThreadGroupDemo {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("group 1");
        Thread t = new Thread(threadGroup,"theaad1"){
            @Override
            public void run() {
                int a = 10/0;
                System.out.println("xx");
            }
        };
        Thread t1 = new Thread(threadGroup,"theaad2"){
            @Override
            public void run() {
                System.out.println("xx");
            }
        };
        int a = threadGroup.activeCount();
        threadGroup.uncaughtException(
                t1,new RuntimeException()
        );
        t.start();
        t1.start();

        System.out.println(threadGroup.activeCount());


    }
}
