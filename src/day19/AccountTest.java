package day19;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 */
public class AccountTest {
    public static void main(String[] args) {
        // 3.创建实现Runnable 的实现类的实例对象
        Account account = new Account(0);
        Customer customer = new Customer(account);

        // 4.通过 Runnable 的实现类对象，创建Thread对象
        Thread t1 = new Thread(customer);
        Thread t2 = new Thread(customer);
        Thread t3 = new Thread(customer);

        t1.setName("甲");
        t2.setName("乙");
        t3.setName("丙");

        // 5. 通过start()创建线程
        t1.start();
        t2.start();
        t3.start();



    }


}

class Account {
    private int balance = 0;
    ReentrantLock reentrantLock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(double amt) {

        if (amt > 0) {
            try {
                reentrantLock.lock(); // 手动设置显式锁
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.balance += amt;
                System.out.println(Thread.currentThread().getName()+"->存储成功，余额"+this.balance);
            } finally {
                reentrantLock.unlock();  // 手动释放显式子锁
            }
        }

    }

}


// 1. 创建实现 Runnable接口的实现类
class Customer implements Runnable {
    private Account account = null;
    public Customer(Account account) {
        this.account = account;
    }


    public Customer() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    // 2. 重写 Runnable 接口中的 run()方法
    @Override
    public void run() {
        this.account.deposit(1000);
    }
}


