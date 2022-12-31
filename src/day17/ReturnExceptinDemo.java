package day17;

public class ReturnExceptinDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");  // 执行 1.
            throw new RuntimeException("制造异常");  // 手动抛出异常: 将编译异常转换为运行时异常抛出  // 执行3.
        } finally {
            System.out.println("用A方法的finally");  // 执行 2.
        }
    }


    static void methodB() {
        try {
            System.out.println("进入方法B");  // 执行1
            return;
        } finally {
            System.out.println("调用B方法的finally");  // 执行2.
        }
    }


    public static void main(String[] args) {
        try {
            methodA();  // 执行 1.
        } catch(Exception e) {
            System.out.println(e.getMessage());  // 执行 2.
        }
        methodB();  // 执行3.
    }

}
