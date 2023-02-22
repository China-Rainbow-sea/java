package blogs.blog11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest07 {
    public static void main(String[] args) {
        try {
            // 1. 获取到该类的 Class 字节码对象
            Class clazz = Class.forName("blogs.blog11.MyClass7");

            //2. 创建对应的类对象，通过反射调用其无参构造器
            // 这里因为我们知道，实例化的对象是什么类型的可以直接强制转换
            MyClass7 myClass = (MyClass7) clazz.newInstance();


            // 3. 获取指定想要调用的方法中的 Method 方法的字节码对象
            // 方法存在重载：所以想要确定一个方法的要素是：方法名，实参类型
            // 获取到 fun1()方法的 Method 对象
            Method method = clazz.getDeclaredMethod("fun1");

            // 获取到 fun3(String s ,int num) 方法的 Method 对象
            Method method2 = clazz.getDeclaredMethod("fun3", String.class, int.class); // 注意需要和实际调用的方法中的类型保持一致

            // 4. 设置为 true 保证反射可以调用私有的方法
            method.setAccessible(true);
            method2.setAccessible(true);

            // 5.
            /*
            调用方法
            1. fun1() fun2() 方法名
            2. myClass调用哪个对象中的方法
            3. 方法中的参数列表的赋值：“Tom" ,999实参
            4. o,o2 返回类型
            该 invoke()方法的返回类型就是，对应反射机制调用的对象中的方法的返回类型
         */

            // 调用 method 中的 fun1() 方法
            // 因为我们的 fun1()方法是没有实参的所以传个 null 就可以了
            Object o = method.invoke(myClass, null);
            System.out.println(o); // 因为fun1()方法是没有返回值的所以返回的是 null

            // 调用 method2 中的fun2()方法
            Object o2 = method2.invoke(myClass, "Tom", 999);
            System.out.println(o2); // invoke()方法的返回值，就是 fun2()方法的返回值
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


    public static void main2(String[] args) {

        // 定义一个字符串，用于字符串的拼接
        StringBuilder stringBuilder = new StringBuilder();
        // 1. 获取到该类的 Class 字节码对象
        Class clazz = null;
        try {
            clazz = Class.forName("blogs.blog11.MyClass7");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 首先将该类名，信息添加到字符串中
        stringBuilder.append(Modifier.toString(clazz.getModifiers()) + "\tclass\t" + clazz.getSimpleName() +
                "\t{\n");

        // 2. 获取到该类中的所有的方法，包括private 私有的
        Method[] methods = clazz.getDeclaredMethods();

        // 遍历该 Method 数组中的值
        for (Method m : methods) {
            stringBuilder.append("\t");

            // 获取到该方法中的修饰符 public
            int modifiers = m.getModifiers();
            String s = Modifier.toString(modifiers);
            stringBuilder.append(s);  // 添加上
            stringBuilder.append(" ");

            // 获取到该方法的返回值类型
            Class<?> returnType = m.getReturnType();
            // 获取到该方法的返回值类型名
            String nameType = returnType.getName();
            stringBuilder.append(nameType);  // 添加上
            stringBuilder.append(" ");

            // 获取到该方法名称
            String name = m.getName();
            stringBuilder.append(name);
            stringBuilder.append(" ( ");

            // 获取到该方法的参数列表:
            // 因为方法中可能存在多个参数列表，也可能一个也没有
            Class<?>[] parameterTypes = m.getParameterTypes();
            // 如果该方法从实参数是 0 个，就不要获取该方法中的实参类型了
            if (!(parameterTypes.length == 0 || parameterTypes == null)) {
                // 有遍历该实参列表
                for (Class<?> p : parameterTypes) {
                    // 获取到该实参的类型
                    String simpleName = p.getSimpleName();
                    stringBuilder.append(simpleName);  // 添加上
                    stringBuilder.append(",");
                }


                // 删除指定下标位置上的字符，这里删除的是：最后一个参数多了一个 “,”逗号
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            }
            stringBuilder.append("){}\n");
        }
        stringBuilder.append("}");
        System.out.println(stringBuilder);
    }
}


final class MyClass7 {
    public MyClass7() {
        // 定义无参构造器，用于反射调用
    }

    public static void fun2() {

    }

    static final void fun4(String s, double d) {

    }

    private void fun1() {
        System.out.println("你好世界");
    }

    private String fun3(String s, int num) {
        return "Hello World" + num;
    }
}