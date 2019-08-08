package SynoCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: hy
 * @Date: 2019/7/24 11:20
 * @Version 1.0
 */
public class CollectionDemo {

    // private ArrayList<String> list = new ArrayList<>();
    // private static List<String> list = Collections.synchronizedList(new ArrayList<>());
    private ConcurrentLinkedQueue list = new ConcurrentLinkedQueue();
    public  void add(String aaa){
        list.add(aaa);
    }

    public void list(){
        list.forEach(i->{
            System.out.println(i);
        });
    }
}
