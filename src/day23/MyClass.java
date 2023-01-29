package day23;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyClass {

    // 声明一个静态内部类
    private static class InnerClass {
        public void m1() {
            System.out.println("静态内部类中的一个方法");
        }
    }

    public static void main(String[] args) {
        // 类名叫做 MyClass.InnerClass
        // 创建静态内部类对象
        MyClass.InnerClass  m = new MyClass.InnerClass();
        m.m1();

        //
    }

    @Test
    public void test() {
        // 给Set 集合中存储的对象是：MyClass.InnerClass 类型
        Set<InnerClass> set = new HashSet<InnerClass>();

        // 这个Set 集合中存储的是字符串对象
        Set<String> set2 = new HashSet<String>();

        Set<MyMap.MyEntry<MyClass.InnerClass,String>> set3 = new HashSet<MyMap.MyEntry<MyClass.InnerClass,String>>();


    }
}


class MyMap {
    public static class MyEntry<K,V> {

    }
}