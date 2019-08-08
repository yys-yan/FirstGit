import thread.ImlRunnable;
import thread.subThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        subThread s = new subThread();
        s.start();

        Thread t = new Thread(new ImlRunnable());
        System.out.println(t.getName());

        t.start();
        Thread.sleep(2000);
        System.out.println(t.isAlive());

        new Thread(){
            @Override
            public void run() {
                System.out.println("匿名内部类线程实现");
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类线程实现 runner实现");
            }
        }).start();


    }
}
