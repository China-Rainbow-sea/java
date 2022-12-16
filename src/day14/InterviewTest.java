package day14;

public class InterviewTest {
    public static void main(String[] args) {
        Base1 base1 = new Sub1();
        base1.add(1,2,3);  // 调用的是 sub1重写的方法(int...arr/int[] arr)是一样的可以满足重写,不是调用 add(int a,int b,int c) Sub1特有的的方法
        System.out.println("*************************");
        Sub1 sub1 = (Sub1)base1;   // 强制向下转型,
        // 调用的是 sub1 特有的  add(int a,int b, int c) 三个参数的特有的方法
        sub1.add(1,2,3);    // 这不是 add(int a,int[]arr)不是 Sub1特有的方法,而是继承父类重写的方法





    }

}


class Base1{
    public void add(int a,int...arr) {
        System.out.println("base1");
    }

}

class Sub1 extends Base1 {
    public void add(int a,int[] arr) {
        System.out.println("sub_1");
    }

    public void add(int a,int b,int c) {
        System.out.println("sub_2");
    }

}
