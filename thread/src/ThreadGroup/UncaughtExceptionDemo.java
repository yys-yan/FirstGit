package ThreadGroup;

/**
 * @Author: hy
 * @Date: 2019/7/9 11:27
 * @Version 1.0
 */
public class UncaughtExceptionDemo {

    public static void main(String[] args) {

        Thread t = new Thread("son"){
            @Override
            public void run() {
                while(true) {
                    System.out.println(10 / 0);

                }
            }
        };
        //
        t.setUncaughtExceptionHandler(
                (thread,e)->{

                    System.out.println(t.isInterrupted());
                    System.out.println(Thread.currentThread().getName());
                }
        );
        t.start();


        try {
            Thread.sleep(1000);
            System.out.println("main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
