package thread;

/**
 * @Author: hy
 * @Date: 2019/7/10 17:27
 * @Version 1.0
 */
public class DaemonThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new DaemonRunnable());
        //设置守护进程， 当前台线程执行完之后， 守护线程会自动停止
        t.setDaemon(true);
        t.start();

        for (int i = 0;i<10;i++){
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"i");
        }

    }

}

class  DaemonRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"  "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
