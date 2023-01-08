package day20;

public class AccountTest {
    public static void main(String[] args) {
        // 创建账户对象(只创建1个)
        Account account = new Account("act--001",10000);

        // 创建两个线程
        Thread t1 = new AccountThread(account);
        Thread t2 = new AccountThread(account);

        // 设置线程名
        t1.setName("t1");
        t2.setName("t2");

        // 启动创建线程
        t1.start();
        t2.start();

    }


}



class AccountThread extends Thread {
    private Account account = null;

    public AccountThread () {

    }

    public AccountThread(Account account) {
        this.account = account;
    }

    // 重写 Thread 中的 run()方法
    @Override
    public void run() {
        this.account.withdraw(5000);
    }
}