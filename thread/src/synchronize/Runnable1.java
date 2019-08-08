package synchronize;

/**
 * @Author: hy
 * @Date: 2019/4/30 15:49
 * @Version 1.0
 */
public class Runnable1 implements Runnable {
    Value value;

    public Runnable1(Value value){
        this.value = value;
    }
    @Override
    public void run() {

        for (int i=0;i<10;i++){
            System.out.println("线程1----"+value.getValue());
        }
    }
}
