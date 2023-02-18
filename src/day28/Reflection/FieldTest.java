package day28.Reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test() {
        Class<?> clazz = null; // 全类路径]
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取属性结构
        //getFields() : 获取当前运行时"类"及其"父类"中声明为 public 访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

    }

    // 获取到属性中的: 权限修饰符 数据类型 变量名
    @Test
    public void test2() {
        // 创建运行时类的对象
        Class<?> clazz = null;
        try {
            //clazz = Class.forName("day28.Reflection.Person");
            clazz = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 获取到该运行时类包括 private 私有的,注意这个方法不会获取到父类中的属性,仅仅只会获取到当前类中的属性
        // 因为一个类中属性可能含有多个,所以是数组
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 1.获取到对应的属性上的权限修饰符
            // getModifiers()返回的是对应权限修饰符中的一个标记
            /*int modifiers = field.getModifiers();
            System.out.println(modifiers);*/
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) +"\t");

            // 2. 获取到对应属性上的数据类型
            Class<?> type = field.getType();
            System.out.print(type.getName() + "\t");

            // 3. 获取到对应的变量名
            String name = field.getName();
            System.out.print(name);
            System.out.println();
        }
    }
}
