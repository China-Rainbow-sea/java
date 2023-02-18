package day28;

import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {
    @Test
    public void test() throws Exception {
        // 获取到运行时类的对象
        Class clazz = Person2.class;
        // 实例化对应运行时类
        //Object o =  clazz.newInstance();
        // 这里因为我们知道对应的实例的类型，所以可以直接进行强制转换
        // newInstance()调用此方法，创建对应的运行时类的对象
        // newInstance() 方法内部是调用了运行时类的空参的构造器
        /*
        想要此 newInstance()方法正常的创建运行时类的对象,要求:
        1.运行时类必须提供空参的构造器,因为调用该方法的内部实际上是调用空参的构造器的,没有的话报错
        2.空参的构造器的访问权限得够,通常,设置为public
        在Javabean中要求提供一个public 的空参构造器,原因:
        1.便于通过反射,创建运行时类的对象
        2.便于子类继承此运行时类时,默认调用super()时,保证父类由此构造器
         */
        Person2 p = (Person2) clazz.newInstance();
        System.out.println(p);


    }

    /**
     * 三种方式加载类到运行时类
     */
    @Test
    public void test2() {
        // 方式一: 调用运行时类的属性：class （Object 中的 class）
        // Class 是一个类 java.lang.Class
        Class clazz = Person2.class;
        System.out.println(clazz);

        // 方式二:调用Object类中的 getClass()方法
        Person2 person2 = new Person2();
        Class<? extends Person2> clazz2 = person2.getClass();
        System.out.println(clazz2);

        // 方式三: 通过反射: 调用Class.类中的静态方法forName()
        Class<?> clazz3 = null;  // 注意写入的必须是全路径类名,因为其他包中可能存在同名的类
        try {
            clazz3 = Class.forName("day28.Person2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz3);




    }

    @Test
    public void test3() {
        // Random().nextInt(3) 生成 0~3 范围的随机数,注意不包括 3
        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(3);

            String classPath = "";

            switch(num) {
                case 0 :
                    classPath = "java.util.Date";
                    break;
                case 1:
                    // 注意了: java.sql.Date 是没有空参构造器的
                    //classPath = "java.sql.Date";
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "day28.Person2";
                    break;
            }

            Object o = getInstance(classPath);
            System.out.println(o);

        }

    }

    /**
     * 创建一个指定类的对象:
     *         classPath: 指定类的全类名
     */
    public Object getInstance(String classPath) {
        try {
            Class clazz = Class.forName(classPath);
            return clazz.newInstance(); // 调用对应的类的无参构造器
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}

class Person2 {
    String name;
    int age;

    public Person2() {
        System.out.println("Hello World");
    }


    public Person2(String name, int age) {
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

    public void show() {
        System.out.println("你好，我是一个人");
    }

    private String showNation(String nation) {
        System.out.println("我的国籍: " + nation);
        return  nation;
    }




    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
