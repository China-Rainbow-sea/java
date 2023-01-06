package day19;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 */
public class AccountTest2 {
    public static void main(String[] args) {
        // 3.创建实现继承Thread的类的实例对象
        Account2 account2 = new Account2();
        Thread t1 = new Customer2(account2);
        Thread t2 = new Customer2(account2);
        Thread t3 = new Customer2(account2);

        t1.setName("甲");
        t2.setName("乙");
        t3.setName("丙");

        // 4. 通过start()创建线程
        t1.start();
        t2.start();
        t3.start();
    }

}


class Account2 {
    private int balance = 0;

    public Account2() {
    }

    public Account2(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(double amt) {
        synchronized (this) {  // 以Account2.class 类作为锁，同步监视器,使用this也是没有问题的，因为这里传的都是同一个对象的地址的引用
            if(amt > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.balance += amt;
            System.out.println(Thread.currentThread().getName() + "->存储成功，余额"+this.balance);
        }

    }
}


// 1. 创建继承 Thread 的类
class Customer2 extends Thread{
    private Account2 account2 = null;

    public Customer2(Account2 account2) {
        this.account2 = account2;
    }
    @Override
    public void run() {
        for(int i = 0; i < 3 ; i++) {
            this.account2.deposit(1000);
        }
    }


    public Account2 getAccount2() {
        return account2;
    }
}