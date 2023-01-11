package blogs.blog4;

public class ThreadTest10 {
    public static void main(String[] args) {
        MyClass m1 = new MyClass();
        MyClass m2 = new MyClass();

        Thread t1 = new MyThread(m1);
        Thread t2 = new MyThread(m2);  // 多态性

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        try {
            Thread.sleep(1000);   // 这个睡眠的作用: 为了保证t1线程先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}


class MyThread extends Thread {
    private MyClass mc = null;

    public MyThread(MyClass mc) {
        super();
        this.mc = mc;
    }

    @Override
    public void run() {
        if ("t1".equals(super.getName())) {
            mc.doSome();
        }

        if ("t2".equals(super.getName())) {
            mc.doOther();
        }
    }

}


class MyClass {
    public static synchronized void doSome() {  // 这里的同步监视器是: this 锁
        System.out.println("doSome begin");

        try {
            Thread.currentThread().sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome over");
    }


    public static synchronized void doOther() {
        System.out.println("doOther begin");
        System.out.println("doOther over");
    }
}