package blogs.blog2;

public class SingletonTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        // Bank.instance = null; // fianl 无法修改
        System.out.println(bank1 == bank2); // == 操作符，引用类型比较的是地址
    }
}

// 饿汉式方式以
class Bank{
    // 构造器私有化，不然外部调用
    private Bank() {

    }


    // 静态的好通过 类名直接调用
    // 注意附加上 final 防止外部访问修改为了 null,
    private static Bank instance = null;

    // 提供公共静态的方法，返回当前类的对象
    public static Bank getInstance() {
        if(instance == null) {  // 当 instance 为 null 的时候，就创建新的不是空就不创建新的对象
            // 内部创建实例化对象
            instance = new Bank();
        }
        return instance;
    }

}
