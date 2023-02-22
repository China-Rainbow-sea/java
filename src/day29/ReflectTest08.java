package day29;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest08 {
    @Test
    public void test() throws Exception {
        // 获取类，类加载器(会自动执行该类中的静态代码块的)
        Class clazz = Class.forName("day29.UserService");

        // 获取该类中的所有 Method方法(包括私有的方法)
        Method[] methods = clazz.getDeclaredMethods();

        // 遍历
        for (Method method : methods) {
            // 获取该方法中的修饰符列表:
            String s = Modifier.toString(method.getModifiers());
            System.out.println(s);

            // 获取该类中方法的返回值类型
            String simpleName = method.getReturnType().getSimpleName();
            System.out.println(simpleName);

            // 获取该类中的方法名
            System.out.println(method.getName());

            // 获取该方法的参数列表(一个方法中参数可能会有多个)
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> p : parameterTypes) {
                System.out.println(p.getSimpleName());
            }
        }
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Class.forName("java.lang.String");  // 全类名

        StringBuilder s = new StringBuilder();
        s.append(Modifier.toString(clazz.getModifiers()) + "\tclass" + clazz.getSimpleName() + "\t" + clazz.getName() + "\t{\n");

        Method[] methods = clazz.getDeclaredMethods();

        for (Method m : methods) {
            s.append("\t");
            s.append(Modifier.toString(m.getModifiers())); // 方法修饰符
            s.append(" ");
            s.append(m.getReturnType().getSimpleName()); // 方法的返回值类型
            s.append(" ");
            s.append(m.getName()); // 方法名
            s.append("( ");

            // 方法的参数列表:
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes.length == 0 || parameterTypes == null)) {
                for (Class<?> p : parameterTypes) {
                    s.append(p.getSimpleName()); // 参数类型
                    s.append(",");
                }
                // 删除指定下标位置上的字符:
                s.deleteCharAt(s.length()-1);
            }

            s.append("){}\n");
        }

        s.append("}");

        System.out.println(s);

    }


    // 不使用反射机制，调用对象中的方法
    @Test
    public void test3() {
      /*  UserService u = new UserService();
        System.out.println(u.login("admin", "123"));*/
    }

    // 使用反射机制调用，对象中的方法:
    @Test
    public void test4() throws Exception{
        // 类加载：会自动执行类中的静态代码块，而不会创建类对象
        Class clazz = Class.forName("day29.UserService"); // 全类路径
        // 创建对象
        Object o = clazz.newInstance();

        // 获取指定想要调用的方法中的 Method 对象
        // 方法存在重载:所以确定一个方法的要素是：方法名，实参类型
        Method login = clazz.getDeclaredMethod("login", String.class, String.class);
        // 设置保证反射可以调用私有的方法
        login.setAccessible(true);

        // 调用方法的4个要素:
        /*
        1. Login 方法名
        2. O 调用哪个对象中的方法
        3. “abc" ,123实参
        4. abmid 返回类型
        该 invoke()方法的返回类型就是，对应反射机制调用的对象中的方法的返回类型
         */
        Object abmid = login.invoke(o, "admin", "123");
        System.out.println(abmid);

    }
}



class UserService {
    /**
     * 登录方法
     */
    private boolean login(String name, String password) {
        if("admin".equals(name) && "123".equals(password)) {
            return true;
        }

        return false;
    }

}
