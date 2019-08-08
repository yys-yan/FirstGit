package TimeUnit;

import java.util.concurrent.TimeUnit;

/**
 * @Author: hy
 * @Date: 2019/7/29 11:16
 * @Version 1.0
 */
public class TimeUnitDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("xxxx");
        System.out.println(TimeUnit.SECONDS.toMillis(1));
        System.out.println(TimeUnit.HOURS.toMinutes(1));
        System.out.println(TimeUnit.DAYS.toHours(1));
    }
}
