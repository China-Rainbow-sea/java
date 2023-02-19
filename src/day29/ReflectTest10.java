package day29;


import org.junit.Test;

/**
 * 通过反射获取到一个类中实现的接口
 */
public class ReflectTest10 {
    @Test
    public void test() throws Exception  {
        // 类加载器：自动调用该类中的静态代码块，但不会创建该类的实例对象
        Class<?> clazz = Class.forName("java.lang.String");

        // 获取该类的父类
        Class<?> superclass = clazz.getSuperclass();
        System.out.println(superclass.getName());  // 该类的父类的类名

        // 获取该String 类实现的所有接口(一个类可以实现多个接口)
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i.getName()); // 该类的接口名
        }

    }
}
