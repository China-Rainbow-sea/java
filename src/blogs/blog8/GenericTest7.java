package blogs.blog8;

import java.util.ArrayList;
import java.util.List;

public class GenericTest7 {
    public static void main(String[] args) {
        List< ? super Person> list = null;  // >= Person
        List<Person> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();
        list3.add(new Student() );

        // list 可以存取 >= Person 的类型
        list = list2;
        list = list4;
        list.add(new Person());  // 小于的可以添加上
        list.add(new Student());

        Object object = list.get(0);
        System.out.println(object);


    }

    public static void main1(String[] args) {
        List< ? extends Person> list = null;  // <=
        List<Person> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();
        list3.add(new Student() );

        // list 可以存取 <= Person 的类型
        list = list2;
        list = list3;

        // 获取数据 “读”
        Person person = list.get(0);
        System.out.println(person);

    }
}


class Person {

}

class Student extends Person {

}