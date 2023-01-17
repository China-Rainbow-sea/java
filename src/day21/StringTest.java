package day21;

import org.junit.Test;

/**
 * String 的使用
 * <p>
 * String 类: 代表字符串，Java程序中的所有字符串 “字面值” 如 ("abc") 都作为此类的实例实现
 * String 是一个final 类,代表 “不可变的字符序列”。
 * 字符串是常量，用双引号引起来表示，它们的值在创建之后不能更改
 * String 对象的字符内容是存储在一个字符数组 value[] 中的.
 * <p>
 * String: 字符串，使用一对 "" 双引号引起来表示的
 * String: 声明为 final 的,不可被继承。
 * String实现了 Serializable 接口，表示字符串是支持序列化的.  private static final long serialVersionUID = -6849794470754667710L;
 * String 实现了 Comparable 接口，表示String 可以比较大小.
 * String 内部定义了final char[] value 用于存储字符串数据
 * String 代表不可变的字符序列，简称：不可变性
 * 体现:
 * 1.当对字符串重新赋值时，需要重新指定内存区域赋值,不能使用原有的 value 进行赋值操作
 * 2.当对现有的字符串进行连续的 + “拼接”操作时，也无需要重新指定内存区域赋值，不能使用原有的 values 数组进行赋值操作
 * 3.当调用String中的 replace()的对象方法修改指定字符或字符串时,也需要重新指定内存区域赋值. 不能在原有的 values 数据进行赋值操作
 *
 * <p>
 * 通过字面量的方式: (区别于 new)  给一个字符串赋值,此时的字符串声明在字符串的常量池中.
 * 字符串常量池中是不会存储相同内容的字符串的。
 * 字符串常量存储在字符串常量池，目的是共享，减小内存的消耗
 */
public class StringTest {

    /**
     * 字符串的不可变性
     */
    @Test
    public void test1() {
        String s1 = "abc";    // 字面量的定义方式.
        String s2 = "abc";
        s1 = "hello";

        System.out.println(s1);   // hello
        System.out.println(s2);   // abc

        // 比较的是 s1 和  s2 的地址量
        System.out.println(s1 == s2);   // == 默认对于引用类型比较的是地址.

        String s3 = "abc";
        s3 += "def";

        System.out.println(s3); // abcdef

        String s4 = "abc";
        // 并不是在原有的字符串的基础上修改的而是,通过新建一个被修改的字符串： 体现字符串的不可变性。
        String s5 = s4.replace('a', 'm');   // replace() 替换字符串中的字符为“xx”

        System.out.println(s4);
        System.out.println(s5);
    }


    /**
     * String 的实例方式:
     * 方式一: 字面量定义的方式
     * 方式二: 通过 new 对象的方式
     * <p>
     * 面试题: String s = new String("abc"); 方式创建对象，在内存中创建了几个对象
     * 两个: 一个是在堆区当中的 new 的实例对象，另一个是char[] 在方法区当中的字符串常量池中的数据 “abc”
     */
    @Test
    public void test2() {
        // 通过字面量定义的方式,此时的s1 和 s2 的数据javaEE声明在方法区中的字符常量池当中
        String s1 = "javaEE";
        String s2 = "javaEE";

        // 通过 new 对象的方式，此时的 s3 he s4 保存的“地址值”
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);   // true   比较的是地址(s1 和 s2 都是直接指向字符串常量池中的 "javaEE")
        System.out.println(s1 == s3);   // false  比较的是地址(s3 和 s4 是先在堆区中 new 对象 该对象的地址指向 方法区中的字符串常量池中的 “javaEE”)
        System.out.println(s1 == s4);   // false
        System.out.println(s3 == s4);   // false

        System.out.println("************************");

        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name));  // true
        System.out.println(p1.name == p2.name);       // true

        p1.name = "Jerry";
        System.out.println(p2);


    }

    /**
     * 创建 String对象的方式
     */
    @Test
    public void test3() {
        // 1.字面量创建
        String str = "abc";
        System.out.println(str);
        // 2. new 调用构造其
        String s2 = new String("abc");
        System.out.println(s2);
        // 3. 字符数组作为参数，new String 字符串,调用构造其
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        String s4 = new String(arr);
        System.out.println(s4);
        // 4. 指定char字符数组的起始位置，和需要的长度
        String s5 = new String(arr, 0, 3);
        System.out.println(s5);


    }


    /**
     * 面试题: + = 的使用
     * 1. 常量(字符串字面常量) +(拼接) + 常量(字符串字面常量(是被""双引号括起来的字符串)) 后的字符串结果是直接指向字符串常量池当中的，
     * 没有堆区的一个String对象间接指向的，且字符串常量池中是不会存储相同的内容的常量(字符串)的
     * <p>
     * 2. 使用 + 字符串拼接 字符串时，只要存在一个变量(不是字符串字面常量(就是双击引号""括起来的))，结果就在堆中
     * 3. 如果拼接使用 intern()方法，返回值就在常量池中
     * String s2 = "abc";
     * String s1 = s2.intern();
     * s2调用intern()对象方法，会将字符串常量池中已经存储到的s2中的 "abc" 直接赋值到 s1当中
     * 等同于 String s1 = "abc";
     * 4. 特殊的对于 被 final 修饰的变量字符串，本身就是字符串常量等同于 s = "abc" 字面常量
     * <p>
     * 所以 对于
     * final String s9 = "abc";
     * final String s10 = "hello";
     * String s11 = "abchello";
     * String s12 = s9 + s10;   // 等同与 s12 = "abc" + "hello" 直接从字符串常量池中获取到地址值指向。
     * System.out.println(s12 == s11); // true
     */
    @Test
    public void test4() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "haddoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        // == 运算符 比较的是地址值，对于引用类型来说
        System.out.println(s3 == s4);  // true
        System.out.println(s3 == s5);  // false
        System.out.println(s3 == s6);  // false
        System.out.println(s3 == s7);  // false
        System.out.println(s5 == s6);  // false
        System.out.println(s5 == s7);  // false
        System.out.println(s6 == s7);  // false

        String s8 = s7.intern();
        // 堆空间的 s7对象调用intern()对象方法，会将字符串常量池中已经存在 s7 字符串内容的值的地址
        // 直接赋值给 s8 , 等同于 s8 = "abc";
        System.out.println(s8 == s4);

        System.out.println("**********************************");

        final String s9 = "abc";
        final String s10 = "hello";
        String s11 = "abchello";
        String s12 = s9 + s10;
        System.out.println(s12 == s11);   // true


    }


    /**
     * 一道面试题:
     * 字符串是不可变的，是不会被修改的，只会在方法区中的字符串常量池中，重新生成一份.
     *
     */
    @Test
    public void test5() {
        String str = new String("good");
        char[] ch = {'t', 'e', 's', 't'};

        change(str, ch);
        System.out.println(str);   // good
        System.out.println(ch);    // best

    }

    // 注意了字符串是不可变的，这里的str传的是地址值
    public void change(String str, char ch[]) {
        // 这里修改的字符串常量仅仅只是这里的，指向新的一个 test ok 字符串常量池的字符串
        // 记住一点就是：字符串是不会被修改的，只会重新生成
        str = "test ok";
        ch[0] = 'b';
    }
}


class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
