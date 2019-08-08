package IntStream;

import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/7/11 10:29
 * @Version 1.0
 */
public class IntStreamDemo {

    public static void main(String[] args) {

        //1-9
        IntStream.range(1,10).forEach(
                i->{
                    System.out.println(i);
                }
        );
        System.out.println("=========================");
        //1-10
        IntStream.rangeClosed(1,10).forEach(
                i->{
                    System.out.println(i);
                }
        );
    }
}
