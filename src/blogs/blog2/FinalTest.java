package blogs.blog2;

public class FinalTest {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.test(aa);

    }




}

class AA {
    String name;
    int age ;

    public void test(final AA aa) {
        aa.age = 10;   // 这里是否或报错，能否编译成功
        System.out.println(aa.age);
    }
}