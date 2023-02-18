package day28.Reflection;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    @Test
    public void test() {
        Class<?> clazz = null; // 注意是全类名路径,因为不同包下可能含有相同的类名
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // getMethods():获取当前运行时类及其所有父类中声明为public 权限的方法
        // 注意只有声明为 public 的方法,该方法才可以拿到对应的信息.
        // 因为一个类中可能会有多个方法,所以返回的是数组
        Method[] method = clazz.getMethods();
        for (Method m : method) {
            System.out.println(m);
        }

        System.out.println("******************************************");

        // getDeclaredMethods():获取到当前运行时类中声明的所有的方法:(不包括父类中声明的 public )
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

    }

    /**
     * 方法:权限修饰符 返回值类型 方法名(参数类型1 形参名,参数类型2 形参名2) throws XXXException
     *
     */
    @Test
    public void test2() {
        // 创建运行时类对象
        Class clazz = null; // 全类路径,不同的包下可能有同名的类
        try {
            clazz = Class.forName("day28.Reflection.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取到该类中的方法的对象
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            // 1. 获取到方法中声明的注解:
            // getAnnotations() 获取对应方法中的注解:因为注解可能有多个所有返回的是数组
           Annotation[] annotations =  m.getAnnotations();
           for(Annotation a : annotations) {
               System.out.print("注解: " + a + "\t");
           }

           //2 权限修饰符:
            int modifiers = m.getModifiers();
            System.out.print("权限修饰符: "+Modifier.toString(modifiers) + "\t");

            // 3. 返回值类型
            Class<?> returnType = m.getReturnType();
            System.out.print("返回值类型: " + returnType + "\t");

            // 4. 方法名
            String name = m.getName();
            System.out.print( "方法名: " + name + "\t");

            // 5. 形参列表:
            // getParameter表示获取到形参列表()因为一个方法中可能有多个参数,所以返回的是数组\
            //
            Class[] parameterTypes = m.getParameterTypes();
            System.out.print("形参: (");
            if(!(parameterTypes == null || parameterTypes.length == 0)) {
                for(int i = 0; i < parameterTypes.length ; i++) {
                    // 方法中最后一个形参
                    if(i == parameterTypes.length -1) {
                        System.out.print(parameterTypes[i].getName() + "\t");
                        break;
                    }
                    System.out.println(parameterTypes[i].getName() + ",");
                }
            }

            System.out.print(")");

            //


            System.out.println();
        }
    }
}
