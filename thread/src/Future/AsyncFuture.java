package Future;


/**
 * @Author: hy
 * @Date: 2019/7/25 10:18
 * @Version 1.0
 */
public class AsyncFuture<T> implements Future<T> {

    private volatile boolean isDone = false;

    private T result;

    public void done(T result) {
        synchronized (this) {
            this.result = result;
            this.isDone = true;
            this.notifyAll();
        }
    }
    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!isDone) {
                this.wait();
            }
        }
        return result;
    }
}
