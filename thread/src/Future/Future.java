package Future;

/**
 * @Author: hy
 * @Date: 2019/7/25 10:12
 * @Version 1.0
 */
public interface Future<T> {

    T get() throws InterruptedException;
}
