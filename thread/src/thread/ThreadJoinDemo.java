package thread;

/**
 * @Author: hy
 * @Date: 2019/7/10 15:41
 * @Version 1.0
 */
public class ThreadJoinDemo  {

    /**
     *   join 方法。
     *   在一个程序执行流中调用其他线程的join方法时候， 该调用线程将阻塞，
     *   直到join线程结束
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        CaiGouRunnable c1 = new CaiGouRunnable("M1",10000L);
        CaiGouRunnable c2 = new CaiGouRunnable("M2",10000L);
        CaiGouRunnable c3 = new CaiGouRunnable("M3",10000L);
        System.out.println(c1.getResult());
        System.out.println(c2.getResult());
        System.out.println(c3.getResult());

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);

        t1.start();
        t2.start();
        t3.start();
        //  main 线程等待子线程执行完， 才会继续执行
        t1.join();
        t2.join();
        t3.join();

        System.out.println("*****************************");
        System.out.println(c1.getResult());
        System.out.println(c2.getResult());
        System.out.println(c3.getResult());


    }
}


class CaiGouRunnable implements Runnable{
    private String matchingName;


    private Long tempstap;

    private String result;

    public CaiGouRunnable (){
        init(null,null);
    }

    public CaiGouRunnable (String matchingName,Long tempStap){
        init(matchingName,tempStap);
    }


    private void init(String matchingName,Long  tempstap){
        this.matchingName = matchingName;
        this.tempstap = tempstap;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(tempstap);
            result = "采集"+this.matchingName;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResult(){
        return result;
    }
}
