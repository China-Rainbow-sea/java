package blogs.blog11;


import java.lang.reflect.Modifier;

public class ReflectTest03 {
    public static void main(String[] args) {
        // 1. 获取到对应类中的  Class 对象
        Class clazz = null;
        try {
            clazz = Class.forName("blogs.blog11.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 通过该 Class 对象获取到对应类中的包名
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);

        // 3. 获取到该类中的修饰符
        int modifiers = clazz.getModifiers();  // 注意这里返回的是对应 修饰符中序号
        String s = Modifier.toString(modifiers);
        System.out.println(s);  // 如果默认是缺省的权限修饰符的话，返回的是 空

        // 4. 获取到该类的类名
        String name = clazz.getName();
        System.out.println(name);

        // 5. 获取该类中所继承的父类名
        String superName = clazz.getSuperclass().getName();
        System.out.println(superName);

        // 6. 获取该类中的所实现的接口.因为一个类中可以继承多个接口所以，返回的是Class[]类型的数组
        Class[] interfaces = clazz.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

    }
}

class MyClass<String> extends MySuperClass implements Comparable {

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


@interface MyAnnotation {
    String value() default "Hello";

}

class MySuperClass {  // protected

}