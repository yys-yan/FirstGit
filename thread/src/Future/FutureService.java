package Future;

/**
 * @Author: hy
 * @Date: 2019/7/25 10:16
 * @Version 1.0
 */
public class FutureService {

    public <T> AsyncFuture<T> submit(FutureTask<T> task) {
        AsyncFuture<T> future = new AsyncFuture<T>();
        new Thread(()->{
            T result = null;
            try {
                result = task.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.done(result);
        }).start();
        return future;

    }
}
