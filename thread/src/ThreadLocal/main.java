package ThreadLocal;

/**
 * @Author: hy
 * @Date: 2019/7/24 10:54
 * @Version 1.0
 */
public class main {
    public static void main(String[] args) {
        Account account = new Account("a");

        Thread t1 = new TestThread(account,"b");
        Thread t2 = new TestThread(account,"c");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(account.getName());


    }
}
