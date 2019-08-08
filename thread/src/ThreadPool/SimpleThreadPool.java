package ThreadPool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/7/11 10:35
 * @Version 1.0
 *
 * 自定义线程池
 */
public class SimpleThreadPool {

    // thread size
    private final int size;

    private final int DEFAULT_SIZE = 10;

    private final ThreadGroup group = new ThreadGroup("GROUP-POOL");

    private int seq = 0;

    private final String THREAD_PRIFIX = "THREAD-";

    public  static LinkedList<Runnable> taskQueue = new LinkedList<>();

    private LinkedList<WorkerTask> threadPool = new LinkedList<>();

    public SimpleThreadPool(){
        this.size = DEFAULT_SIZE;
        init();
    }

    public SimpleThreadPool(int size){
        this.size = size;
        init();
    }

    private void init(){
        IntStream.range(1,size).forEach(
                i->{
                    createWorkerThread();
                }
        );
    }
    private void createWorkerThread(){
        WorkerTask workerTask = new WorkerTask(group,THREAD_PRIFIX+(seq++));
        workerTask.start();
        threadPool.add(workerTask);

    }

    public void submit(Runnable runnable){
        synchronized (taskQueue){
            taskQueue.addLast(runnable);
            taskQueue.notifyAll();
        }
    }
    // thread state
    private enum TaskState{
        FREE,
        RUNNING,
        BLOCKING,
        DEAD
    }
    private static class WorkerTask extends Thread{
        private TaskState taskState = TaskState.FREE;

        public TaskState getTaskState(){
            return taskState;
        }

        public WorkerTask(ThreadGroup group,String name){
            super(group,name);
        }

        @Override
        public void run() {
            outer:
                while (getTaskState()!=TaskState.DEAD){
                    Runnable runnable;
                    synchronized (taskQueue){
                        while (taskQueue.isEmpty()){
                            try {
                                taskState = TaskState.BLOCKING;
                                taskQueue.wait();
                            } catch (InterruptedException e) {
                                break outer;
                            }
                        }
                        runnable = taskQueue.removeFirst();
                        //执行任务
                        if(runnable != null){
                            taskState = TaskState.RUNNING;
                            runnable.run();
                            taskState = TaskState.FREE;
                        }

                    }
            }
        }

        public void close(){
            taskState = TaskState.DEAD;
        }


    }
    public void listThreadState(){
       threadPool.stream().forEach(
               x->{
                   System.out.println(x.getName()+"----"+x.getTaskState());

               }
       );
    }
    public static void main(String[] args) throws InterruptedException {

        SimpleThreadPool pool = new SimpleThreadPool();
        IntStream.range(1,10).forEach(
                i->{
                    pool.submit(()->{
                        try {
                            Thread.sleep(1000);
                            pool.listThreadState();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("任务"+i+"被执行");
                    });

                }
        );
        Thread.sleep(5000);

        System.out.println("==============================");


    }



}
