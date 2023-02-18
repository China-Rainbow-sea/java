package day29;

import org.junit.Test;

public class ReflectTest01 {
    @Test
    /*
    获取到 Class 能干什么
     */
    public void test2() {
        try {
            // 通过反射机制，获取到 Class ，通过class 来实例化对象
            Class clazz = Class.forName("day29.User");
            // 这个newInstance()方法会调用 User 这个类的无参构造方法，完成对象的创建.
            // 如果该类中没有定义 "无参构造器"的话会报: java.lang.InstantiationException异常
            // 重点: newInstance()调用的是无参构造，必须保证无参构造器是存在的。
            Object o = clazz.newInstance();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
        }
    }
}




class User {
    String name;
    int age;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
