package thread;

/**
 * @Author: hy
 * @Date: 2019/4/30 10:28
 * @Version 1.0
 */
public class subThread extends Thread{

    /**  创建线程的方式一: 继承Thread类
     *
     *
     *   interrupt() : 中断操作,只是添加一个中断标志
     *  具体中断通过 isInterrupted() 进行判断操作
     *
     *   isAlive() : 判断线程是否可用   现车执行完后，isAlive() 为 false
     */

    @Override
    public void run() {
        int i = 0;
            while(!this.isInterrupted()){
            System.out.println("i=="+i++);
            if(i==10){
                this.interrupt();
            }
        }
    }
}
