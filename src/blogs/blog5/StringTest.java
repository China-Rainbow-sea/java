package blogs.blog5;


import org.junit.Test;

/**
 * 关于String 博客的编写需要
 */
public class StringTest {
    public static void main(String[] args) {

        final String str = "hello";
        final String str1 = new String("hello");
        final String str2 = "world";
        String str3 = str + str2;
        String str4 = str1 + str2;
        String str5 = "helloworld";
        System.out.println(str4 == str5);
        System.out.println(str3 == str5);
    }


    public static void main7(String[] args) {
        String str = "good";
        char[] arrs = {'a', 'b', 'c'};

        change(str, arrs);

        System.out.println(str);
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }

    public static void change(String str, char[] arrs) {
        str = "Google";
        arrs[0] = 'A';
    }


    public static void main6(String[] args) {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "haddoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        // == 运算符 比较的是地址值，对于引用类型来说
        System.out.println("s3 == s4: " + (s3 == s4));
        System.out.println("s3 == s5: " + (s3 == s5));
        System.out.println("s3 == s6: " + (s3 == s6));
        System.out.println("s3 == s7: " + (s3 == s7));
        System.out.println("s5 == s6: " + (s5 == s6));
        System.out.println("s5 == s7: " + (s5 == s7));
        System.out.println("s6 == s7: " + (s6 == s7));

        String s8 = s7.intern();
        // 堆空间的 s7对象调用intern()对象方法，会将字符串常量池中已经存在 s7 字符串内容的值的地址
        // 直接赋值给 s8 , 等同于 s8 = "abc";
        System.out.println("s8 == s4: " + (s8 == s4));
    }


    public static void main5(String[] args) {
        Person p1 = new Person("Tom", 20);
        Person p2 = new Person("Tom", 19);

        System.out.println(p1.getName() == p2.getName());
    }


    public static void main4(String[] args) {
        String str = new String("hello");
        String str2 = new String("hello");

        System.out.println("str == str2 : " + (str == str2));

        String str3 = "world";
        String str4 = "world";
        System.out.println("str3 == str4 : " + (str3 == str4));

        String str5 = "hello";
        System.out.println("str5 == str : " + (str5 == str));

    }


    public static void main3(String[] args) {
        String str = new String("hello");
        String str2 = new String("hello");
    }


    public static void main2(String[] args) {
        String str = "hello";
        str = "world";
        System.out.println(str);

        String str2 = "abc";
        str2 = str2 + "def";
        System.out.println(str2);

        String str3 = "Google";
        String str4 = str3.replace('o', 'e');  // replace 替换
        System.out.println(str3);
        System.out.println(str4);

    }


    @Test
    public void test() {
        String str1 = "abc";

        byte[] bytes = {'a', 'b', 'c'};
        String str2 = new String(bytes);
        // 指定 bytes[] 数组中的“起始位置”,和“长度” 转换为字符串
        // String str3 = new String(bytes,定义对应数组的开始位置,以及需要转换为字符串的长度);
        String str3 = new String(bytes, 1, 1);

        char[] chars = {'a', 'b', 'c'};
        String str4 = new String(chars);

        // 同样可以指定char[] 数组中的“起始位置”,和“长度” 转换为字符串
        // String str5 = new String(chars,定义对应数组的开始位置,以及需要转换为字符串的长度);
        String str5 = new String(chars, 0, 3);

        String str6 = new String("abc");
    }


}


class Person {
    int age;
    String name;

    public Person() {
        // 无参构造器
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}