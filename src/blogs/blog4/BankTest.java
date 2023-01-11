package blogs.blog4;

public class BankTest {
}


class Bank {
    private static Bank instance = null;

    // 构造器私有化
    private Bank() {

    }

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {   // 防止多线程安全问题，进一步再判断。
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}