package day25;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 有限制条件的通配符的使用
 * ? extends Person
 *    G< ? extends A> 可以作为G<A> 和 G<B>的父类的，其中B是A的子类
 * ? super Person
 *   G< ? super A> 可以作为G<A>和G<B>的父类，其中B是A的子类。
 */
public class GenericTest5 {
    @Test
    public void test() {
        List<? extends Person> list = null;  // 可以存放赋值 <= Peron的类型
        List<? super Person> list2 = null;   // 可以存放赋值 >= Person的类型

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list = list3;
        list = list4;
        // list = list5;  // 这就就不行了，？ extends Person "?" 存储的类要 <= Person

        // list2 = list3;  // super 上界 >= Person list3是 Person的子类小了
        list2 = list4;
        list2 = list5;

    }

    @Test
    public void test2() {
        List<? extends Person> list = null;  // <=

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list = list3;
        // 写入数据 ： 无法写入。
        /*list.add(new Object());
        list.add(new Person());
        list.add(new Student());*/


        // 读取数据
        Person person = list.get(0);
        System.out.println(person);
        list = list4;
        Person p2 = list.get(0);
        System.out.println(p2);


    }

    @Test
    public void test3() {
        List<? super Person> list2 = null;   // >=

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        //list2 = list3;  小了
        list2 = list4;
        list2 = list5;

        // 写入数据
        list2.add(new Student());
        list2.add(new Person());
        // list2.add(new Object());

        // 读取数据
        Object object = list2.get(0);
        System.out.println(object);
    }

}

class Person {

}

class Student extends Person {

}
