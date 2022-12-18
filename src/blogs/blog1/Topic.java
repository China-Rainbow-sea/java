package blogs.blog1;

public class Topic {
    public static void main(String[] args) {
        Integer x = 127;
        Integer y = 127;
        System.out.println("x == y: "+(x == y));
    }

    public static void main3(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println("i == j: "+(i == j));

        Integer m = 1;
        Integer n = 1;
        System.out.println("m == n: "+(m == n));

        Integer x = 128;
        Integer y = 128;

        System.out.println("x == y: "+(x == y));

    }


    public static void main2(String[] args) {
        Object object = true ? new Integer(1) : new Double(2.0);
        System.out.println(object);
    }


    public static void main1(String[] args) {
        Test test = new Test2();  // 多态
        Test2 test2 = (Test2)test;
        test2.add(1,2,3);
    }

}


class Test{
    public void add(int a,int...arr) {
        System.out.println("Test:add");
    }
}


class Test2 extends Test{
    public void add(int a,int[]arr) {
        System.out.println("Test2:add");
    }

    public void add(int a,int b,int c) {
        System.out.println("Test: a, b, c");
    }
}