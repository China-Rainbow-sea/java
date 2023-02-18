package day28.Reflection;


import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 获取到构造器的结构
 */
public class OtherTest {

    @Test
    public void test() {
        Class clazz = null;
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // getConstructors()获取到当前运行时类中声明为 public 的构造器
        // 因为一个类中会有多个构造器,所以返回数组
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println("**************************************");

        // 获取到当前运行时类中所有的构造器
        Constructor[] decConstructor =  clazz.getDeclaredConstructors();
        for (Constructor c : decConstructor) {
            System.out.println(c);
        }
    }


    /**
     * 获取运行时的父类
     *
     */
    @Test
    public void test2() {
        Class clazz = null; // 全类路径
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取到运行时类的父类
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);
    }

    /**
     * 获取运行时类的带泛型的父类
     */
    @Test
    public void test3() {
        Class clazz = null;  // 全类路径
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }


    /**
     * 获取到运行时类的带泛型的父类的泛型
     *
     * 代码: 逻辑代码 VS 功能代码;
     */
    @Test
    public void test4() {
        Class clazz = null; // 全类路径
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //1.先获取到子类的父类带泛型的
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;

        // 2. 获取到泛型类型
        // 因为泛型可能有多个所以返回的是数组
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class)actualTypeArguments[0]).getName());

    }

    /**
     * 获取运行时类的接口
     */
    @Test
    public void test5() {
        Class clazz = null;  // 全类路径
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 一个类可能继承多个接口,所以返回的是数组
        Class[] interfaces = clazz.getInterfaces();
        for(Class c : interfaces) {
            System.out.println(c);
        }
    }


    /**
     * 获取到运行时类的父类所实现的接口
     */
    @Test
    public void test6() {
        Class clazz = null; // 全类路径
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取到运行时类的父类实现的接口
        // 同样一个类可能实现了多个接口
        Class[] interfaces = clazz.getSuperclass().getInterfaces();
        for(Class c : interfaces) {
            System.out.println(c);
        }


    }


    /**
     * 获取运行时类所在的包
     */
    @Test
    public void test7() {
        Class clazz = null;  // 全类路径
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /**
     * 获取到运行时类声明的注解
     */
    @Test
    public void test8() {
        Class clazz = null; // 全类路径
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 因为一个类中可能存在多个注解.所以返回的是数组
        Annotation[] annotations = clazz.getAnnotations();

        for(Annotation a : annotations) {
            System.out.println(a);
        }
    }

}
