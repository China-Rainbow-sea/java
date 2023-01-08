package day20;

/**
 * 银行账户:
 *     使用线程同步机制，解决线程安全问题
 */
public class Account {
    // 账号
    private String actno;
    // 余额
    private double balance;

    // 对象
    Object object = new Object();   // 实例变量

    public Account() {

    }

    public Account(String actno,double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


    public void withdraw(double money) {
        /*
        以下这几行代码记录是线程排队的，不能开发
        一个线程把这里的代码全部执行结束之后，另一个线程才能进来。
        线程同步机制的语法是：
          synchronized() {
            // 线程同步代码块
          }

          synchronized() 后面小括号中传的这个"数据"是相关关键的。
          这个数据必须是多线程共享的数据，才能达到多线程排队的效果

          ()中的是什么？？ 是同步监视器，“锁”
            那要看你想让哪些线程同步，
            假设 t1,t2,t3,t4,t5  有5个线程
            你只考虑t1,t2,t3排队，t4,t5 不需要排队，怎么办
             你一定要在()中写一个t1,t2,t3共享的对象，而这个对象对于t4,t5来说不是共享的

             这里的共享对象是：账户对象
               账户对象是共享的，那么this就是账户对象吧
               不一定是 this.这里只要是多线程共享的哪个对象就行。

              在Java语言中，任何一个对象都有“一把锁” ，其实这把锁就是标记(只是把它叫做“锁”)
              100个对象，100把锁，1个对象1把锁。
              这样就达到了线程排队执行。
              这里需要注意的是：这个共享对象一定要选好了，这个共享对象一定是你需要排队
              执行的这些线程对象所共享的.

         */

        /*
        以下代码的执行原理：
         1.假设t1和t2线程并发，开始执行以下代码的时候，肯定有一个先一个后，
         2.假设t1先执行了，遇到了synchronized,这个时候自动“找” 后面共享对象的对象锁。
         找到之后，并占有这把锁，然后执行同步代码块中的程序，在程序执行过程中一直都是占有这把锁的，直到同步代码块代码结束，这把锁才会释放。
         3.假设t1已经占有这把锁，此时t2也遇到synchronized关键字，也会去占有后面共享对象的这把锁，结果这把锁被t1
         占有，t2只能在同步代码块外面等待t1的结束，直到t1把同步代码块执行结束了，t1会归还这把锁，此时t2终于等到这把锁，
         然后t2占有这把锁之后，进入同步代码块执行程序。
         这样就达到了线程排队执行。
         这里需要注意的是：这个共享对象一定要选好了，这个共享对象一定是你需要排队执行的这些线程对象所共享的
         */

         synchronized (this) {   // 因为this是所有线程共用的对象，同步监视器“锁”是同一把，可以
                                   // t1,t2两个线程需要排队等锁
        // synchronized ("abc") {  // "abc" 字符串常量池的存在是唯一的，所有线程共享的数据，同步监视器“锁”都是同一个对象
        //synchronized(Account.class) {   // Account.class 类对象也仅仅只会加载一次，所有线程对象共享，
        Object object = new Object();
        //synchronized(object) {  // 这里的object 对象是局部变量，在栈中，每个线程都有一个锁,不是共享的资源，同步监视器不是唯一的
          Object object2 = null;  // 仅仅只是骗过了编译器而已
          //synchronized(object2) {  // NullPointerException 不可以传null 空指针异常.
           //synchronized(null) { //空异常报错
            // 余额
            double before = this.balance;
            // 取款之后
            double after = before - money;
            try {
                Thread.sleep(1000*1);  // 注意这里睡眠的，不会释放手中的“锁”
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + after);

            this.setBalance(after);
        }
    }
}
