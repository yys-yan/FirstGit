package Future;

/**
 * @Author: hy
 * @Date: 2019/7/25 10:13
 * @Version 1.0
 */
public interface FutureTask<T> {

    T call() throws InterruptedException;
}
