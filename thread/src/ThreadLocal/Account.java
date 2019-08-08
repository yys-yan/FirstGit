package ThreadLocal;

/**
 * @Author: hy
 * @Date: 2019/7/24 10:43
 * @Version 1.0
 */
public class Account {
    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String name) {
        this.name.set(name);
    }

    public String getName() {
        return this.name.get();
    }

    public void setName(String name){
        this.name.set(name);
    }
}
