package ThreadLocal;

import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/7/24 10:51
 * @Version 1.0
 */
public class TestThread extends Thread {

    private Account account;
    private String name;

    public TestThread(Account account,String name) {
        this.account = account;
        this.name = name;
    }

    @Override
    public void run() {
        IntStream.rangeClosed(1,10).forEach(i->{
            if(i == 6) {
                this.account.setName(name);
            }
            System.out.println(this.account.getName());
        });
    }
}
