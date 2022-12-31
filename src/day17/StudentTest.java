package day17;


/**
 * throw 是手动抛出异常
 *   1. throw new RuntimeException();  手动抛出异常: 将编译异常转换为运行异常
 *   2. throw new Exception("你输入的数据非法") 手动抛出异常: 抛出编译异常，一般是配合 throws 中的
 *      向上抛出异常处理配合使用。
 *   3. throw 手动抛出异常可以代替 方法的返回值 return
 */
public class StudentTest {
    public static void main(String[] args) {
        Student s = new Student();

        try {
            s.regist(-10);
        } catch (Exception e) {
            // e.printStackTrace(); 报红错误处理
            System.out.println(e.getMessage()); // getMessage()获取到 Exception("你输入的数据非法") 抛出的异常

        }
        System.out.println(s);
    }


}


class Student {
    private int id;

    public void regist(int id) throws Exception{
        if( id > 0) {
            this.id = id;
        } else {
            // throw new RuntimeException("你输入的数据非法"); // 将编译异常转换为运行异常抛出
            throw new Exception("你输入的数据非法");  // throw 手动抛出异常,一如果是 Exception编译异常，
            // 一般配合使用 throw 向上抛出异常处理
        }
    }
}