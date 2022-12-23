package blogs.blog2;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("我是 MainTest 中的 main()方法");
    }
}


class Main2{
    public static void main(String[] args) {
        System.out.println("我要调用 MainTest中的main()方法");
        // 调用 MainTest 中的main()方法
        MainTest.main(args);
    }
}