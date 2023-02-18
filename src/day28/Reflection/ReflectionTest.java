package day28.Reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    /**
     * 获取到 public 公开是属性值,设置值
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        Class clazz = Class.forName("day28.Reflection.Person");  // 全类路径

        // 创建运行时类的对象
        Person p = (Person) clazz.newInstance(); // 该方法实际上调用的对应空参的构造器

        // 获取指定的属性
        // getField () 只能拿到 public 公开的属性的值
        Field id = clazz.getField("name");

        /*
        设置当前属性的值
        set(): 参数1:指明设置的是哪个对象中的属性(因为可能存在多个对象),
                参数2: 将此属性值设置为多少.
         */
        id.set(p, 1001);

        /*
        获取当前属性的值
        get(): 参数1: 获取哪个对象的当前属性
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
    }


    /**
     * 获取到私有的属性中的值,或修改私有的属性值
     */
    @Test
    public void test2() throws Exception {
        Class clazz = Class.forName("day28.Reflection.Person"); // 全类路径

        // 创建运行时类的对象
        // 这里因为我们知道,创建的是什么类型的对象,所以可以直接强制转换
        Person person = (Person) clazz.newInstance();
        // 获取到指定属性的 Field 对象
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true); // 将该属性私有的,设置为 true 可以被反射访问到
        field.set(person, "Tom");  // 修改该属性的值(保证当前属性是可访问的),注意:设置的值需要和定义的类型保持一致.
        System.out.println(field.get(person));  // 获取到该属性的值
    }


    /**
     * 如何操作运行时类的指定的方法 ---掌握
     */
    @Test
    public void test3() throws Exception {
        // 类加载
        Class clazz = Class.forName("day28.Reflection.Person"); // 全类路径
        // 创建运行时类的对象
        // 因为我们知道获取到的是什么类型的,所以可以直接强制转换为对应的类型
        Person p = (Person)clazz.newInstance(); // 实际上调用的是空参构造器

        /*
        获取指定的某个方法
        getDeclaredMethod()
         参数1:指明获取的方法的名称
         参数2: 指明获取方法的形参列表
         因为方法可以重载:所以确定一个方法的两个要素是:方法名,和方法的参数列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);  // 保证当前方法是可访问的.
        /*
        invoke():参数1 方法的调用者,参数2:给方法形参赋值的实参.
        注意: invoke() 方法的返回值即为对应类中调用的方法的返回值.
         */
        Object o = show.invoke(p,"Tom");
        System.out.println(o);
    }

    /**
     * 如何调用静态的方法
     */
    @Test
    public void test4() throws Exception{
        // 反射获取运行类加载器
        Class clazz = Class.forName("day28.Reflection.Person"); // 全类路径

        // 2.创建运行时类对象
        // 因为我们已经知道了,被创建的运行时类的对象,所以可以直接强制转换了
        Person person = (Person)clazz.newInstance(); // 调用的是对应类中的空参构造器

        // 调用静态方法,获取到静态方法的Methods 对象
        Method m = clazz.getDeclaredMethod("disPlay", String.class);
        // 设置该方法可以被访问
        m.setAccessible(true);

        // 传参数调用
        // invoke()方法的返回值就是对应调用的方法的返回值
        Object o = m.invoke(person,"中国");
        System.out.println(o);
    }

    /**
     * 如何调用运行时类中的指定的构造器
     */
    @Test
    public void test5() throws Exception {
        // 加载对应信息的类
       Class clazz =  Class.forName("day28.Reflection.Person"); // 全类路径

        /*
        getDeclaredConstructor()参数: 指明构造器的参数列表:
        用于识别调用的是哪个构造器
         */

        // 获取指定的构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);

        // 保证该构造器是可以被访问的
        declaredConstructor.setAccessible(true);

        // 调用此构造器创建运行时类的对象
        // 因为我们已经知道了创建的是哪个对象的类,所以这里可以直接强制转换
        Person p = (Person)declaredConstructor.newInstance("Tom");
        System.out.println(p);
    }
}
