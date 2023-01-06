package day19;

/**
 * 单例模式的：懒汉模式的线程安全处理
 */

/*
如果找问题，即代码是否存在线程安全？
  1.明确哪些代码时多线程运行的代码/
  2.明确多个线程是否有共享数据
  3.明确多线程运行代码种是否有多条语句操作共享数
如何解决 ：
  > 对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中，其他线程不可以参与执行。
    即所有操作共享数据的这些语句都要放在同步范围中
    切记:范围太小：没锁住所有有安全问题的代码；
    范围太小：没发挥多线程的功能。
    注意锁：是共用一把锁的，注意作用范围上的是否是同一把锁的问题


    释放锁的操作：
    1.当前同步代码块，同步方法执行结束了，释放锁
    2.当前线程同步代码块，同步方法遇到 break;return ;
    3.当前线程同步代码块，同步方法遇到 Error 或者 Exception 异常没有处理的，导致异常结束
    4.当前线程同步代码块，同步方法中执行了线程对象的wait()方法，当前线程暂停，并释放锁
    5.当前线程同步代码块，同步方法中执行了调用了Thread.sleep(),Thread.yield()方法暂停了当前线程的执行
    6.线程执行同步代码块，同步方法时，其他线程调用了该线程的suspend()方法将线程挂起，该线程不会释放锁(同步监视器)
      应当避免使用suspend() 和 resume()来控制线程。

 */
public class BankTest {

}


class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    // 方式一：使用同步方法解决：线程安全问题: 同步监视器“锁”是 类.class 类对象
    /*public static synchronized Bank getInstance() {
        // 附加synchronized静态的同步方法解决线程安全问题。
        if(instance == null) {
            instance = new Bank();
        }

        return instance;
    }*/


    // 方式二: 使用同步代码块的方式：解决线程问题：同步锁是: 类.class 类对象
    public static Bank getInstance() {
        /*synchronized (Bank.class) {
            if(instance == null) {
                instance = new Bank();
            }

        }
        return instance;*/
        // 方式二:优化，方式二的第一种方式：效率低，因为存在这样一种情况：多个线程等待锁时，
        // 得到锁以后，发现 instance != null ,就什么也没有做，还将多线程变成了单线程，并等待了不少时间
        // 就相当于是：排队核酸检测，明明前面已经没有检查试剂了，缺不早说而是，等排到你的时候，才说，
        // 而不是已经没有试剂了，就说，让大家不要排队了。

        // 优化：告诉大家，没有试剂了。不要排队了。
        if(instance == null) {
            synchronized(Bank.class) {
                if(instance == null) {
                    instance = new Bank();
                }
            }
        }

        return instance;
    }

}
