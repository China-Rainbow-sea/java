package day28;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Java 的反射: Reflection 是被视为“动态语言”的关键，反射机制允许程序在执行期间借助: Reflection API
 * 取得任何类的内部信息，并能直接操作任意对象的内部属性及方法。
 *
 * 加载完类之后，在堆内存的方法区中就产生了一个 Class类型的对象(一个类只有一个Class对象，)这个对象就包含了
 * 完整的类结构的信息（我们可以通过这个对象看到类的结构）。这个对象就像一面镜子，透过这个镜子看到类的结构
 * ，所以，我们形象的称之为：反射。
 * 正常方式：引入需要的“包类”的名称 ——> 通过 New 实例化——> 取消实例化对象。
 * 反射方式：实例化对象——> getClass()方法——> 得到完整的 “包类”名称。
 *
 *
 *
 * */
public class ReflectionTest {
    // 反射之前，对于Person的操作
    @Test
    public void test() {
        // 1. 创建 Person 类的对象
        Person p1 = new Person("Tom",12);

        // 2.通过对象，调用其内部的属性，方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在 Person类的外部，不可以通过 Person 类的对象调用其内部私有结构。
        // 比如: name,showNation() 以及私有的构造器



    }


    // 使用反射之后:对于 Person的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        Object o = null;
        try {
            // 1. 通过反射，创建Person类的对象
            Constructor constructor = clazz.getConstructor(String.class, int.class);
            o = constructor.newInstance("Tom", 12);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Person person = (Person)o;
        System.out.println(o.toString());
        System.out.println(person);
        System.out.println("***********************");

        // 2.通过反射，调用对象指定的属性，方法
        Field field = clazz.getDeclaredField("age");
        field.set(person,10);
        System.out.println(person);

        // 3.调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);

    }





    // 通过反射调用: private 私有的属性和方法
    @Test
    public void test3() throws Exception {
        // 1. 获取到对应类的反射实例
        Class<Person> clazz = Person.class;
        // 2. 通过反射实例化对象，这里调用私有的构造器
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true); // 设置：表示可以访问 private 私有的构造器
        Person person = constructor.newInstance("Tom");

        // 3. 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);  // 设置表示可以访问到 private 私有的属性
        name.set(person,"张三");

        System.out.println(person.toString());

        // 4. 调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true); // 设置表示可以访问 private 私有的方法
        Object o = showNation.invoke(person, "中国");// 相当于是: person.showNation("中国");
        // 因为这里我们知道了，返回的类型是 String 所以做了一步“强制类型转换”
        String  s = (String)o; // 该invoke()方法的返回值就是，我们对应类方法中的返回值，
        System.out.println(s);

    }

    //反射获取Class 的实例的四种方式:
    @Test
    public void test4() throws Exception {
        // 方式一:调用从 Object 中继承过来的 class 的属性:
        Class<Person> clazz = Person.class;
        System.out.println(clazz);

        // 方式二: 通过运行时类的对象，调用 Object 中继承过来的getClass()方法
        Person person = new Person();
        Class<Person> clazz2 = (Class<Person>)person.getClass();
        System.out.println(clazz2);

        // 方式三: 调用 Class 的静态方法: forName(String classPath)
        Class clazz3 = Class.forName("day28.Person");// 注意该方法中的类名必须是: 全路径: 因为不同的包下会有相同的类名
        System.out.println(clazz3);

        // 判断两个运行类的地址是否相等:
        // == 比较的是两个内存的地址，两个运行类的实例对象的地址是一样的:
        // 因为都是 class 字节码的类，类的加载只会加载一次到内存当中，所有对象共用
        System.out.println(clazz == clazz2);
        System.out.println(clazz2 == clazz3);


        // 方式四: 使用类的加载器: ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("day28.Person");// 同样需要全类路径
        System.out.println(clazz4);

        System.out.println(clazz == clazz4);


    }

    @Test
    public void test5() {
        Class<Object> objectClass = Object.class;
        Class<Comparable> comparableClass = Comparable.class;
        Class<String[]> aClass = String[].class;
        Class<int[][]> aClass1 = int[][].class;
        Class<ElementType> elementTypeClass = ElementType.class;
        Class<Override> overrideClass = Override.class;
        Class<Integer> integerClass = int.class;
        Class<Class> classClass = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class<? extends int[]> aClass2 = a.getClass();
        Class<? extends int[]> aClass3 = b.getClass();
        // 只要元素类型与数组的维度(一维数组，二维数组)，就是同一个Class 类
        // 类仅仅只会加载一次到内存当中，所有对象共用此类。
        System.out.println(aClass2 == aClass3);
    }


}



class Person {
   private String name;
    int age;


    public Person() {
        // 无参构造器，一定要创建处理，用于反射的实例化
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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
        System.out.println("我的国籍是: " + nation);

        return nation;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}