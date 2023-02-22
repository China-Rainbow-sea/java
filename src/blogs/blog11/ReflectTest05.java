package blogs.blog11;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * 反射处理构造器
 */
public class ReflectTest05 {
    public static void main(String[] args) {
        // 1.获取对应的Class 对象
        try {
            Class clazz =  Class.forName("blogs.blog11.MyClass3"); // 全类路径

            // 2.调用 newInstance();这个构造器
            // 该方法实际上是调用了类中的无参构造器
            // Object o = clazz.newInstance();
            // 这里因为我们知道调用的是哪个类中的构造器
            // 可以进行强制类型转换。转换为对应中的类
            MyClass3 myClass = (MyClass3)clazz.newInstance();
            // 第一步：先获取到这个类中有参数的构造器的Constructor对象
            // 注意对应调用的构造器中的参数类型要保持一致，用于后面的赋值
            Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);

            // 第二步: 设置将该获取到的Constructor(构造器)对象中的setAccessible(true)保证私有的可以被访问
            // 如果缺少这一步设置的话，是无法访问私有的构造器的
           // declaredConstructor.setAccessible(true);

            // 第三步: 传构造器中对应的参数，调用构造器，创建对象
            Object tom = declaredConstructor.newInstance("Tom", 18);
            System.out.println(tom);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }



    public static void main1(String[] args) {
        StringBuilder s = new StringBuilder(); // 用于字符串的拼接

        // 获取到对应的类中的 Class 对象.
        Class clazz = null;
        try {
            clazz = Class.forName("blogs.blog11.MyClass3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取该类中所有的构造方法
        // 因为一个类中可能会存在多个构造器，所有返回的是一个Constructor 的数组
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();

        for(Constructor c : declaredConstructors) {
            // 获取到构造方法的修饰符
            int modifiers = c.getModifiers();
            String s2 = Modifier.toString(modifiers);
            System.out.print(s2 + "\t");

            // 获取到构造器的名字,其实就是类名
            String simpleName = clazz.getSimpleName();
            System.out.println(simpleName);

            // 获取该构造方法中的实参列表
            // 因为一个方法中会存在多个参数。所以返回的是一个 Class[]数组
            Class[] parameterTypes = c.getParameterTypes();
            // 当该返回的参数数组，含有数据，不是 0 ,不为 null
            // 则说明该构造器是有参数的。
            if(!(parameterTypes.length == 0 || parameterTypes == null)) {
                // 则获取到该构造器中从参数
                for(Class aClass : parameterTypes) {
                    String type = aClass.getSimpleName();  // 实参类型
                    System.out.println(type);
                }
            }

            System.out.println();



        }


    }

}


class MyClass3 {
    String name;
    int age;

    public MyClass3() {
    }

    private MyClass3(String name) {
        this.name = name;

    }


    private MyClass3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
