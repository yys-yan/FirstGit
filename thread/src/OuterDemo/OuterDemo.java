package OuterDemo;

import java.util.stream.IntStream;

/**
 * @Author: hy
 * @Date: 2019/7/11 10:57
 * @Version 1.0
 */
public class OuterDemo {

    public static void main(String[] args) {

        outer:
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println("i="+i+",j="+j);

                    if(j == 1){
                        break outer;
                    }
            }
        }
    }
}
