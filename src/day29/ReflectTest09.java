package day29;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Properties;

/**
 * 反射机制调用构造器
 */
public class ReflectTest09 {


    /**
     * 编译一个类的 Constructor 构造方法
     */
    @Test
    public void test() throws Exception {
        StringBuilder s = new StringBuilder();

        // 类加载：会自动调用类中的静态代码块，当不会创建类实例对象
        Class clazz = Class.forName("day29.Vip"); // 完整类名

        s.append(Modifier.toString(clazz.getModifiers())); // 类的修饰符
        s.append(" class ");
        s.append(clazz.getSimpleName()); // 类名
        s.append("{\n");

        // 获取所以的构造方法
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            s.append("\t");
            s.append(Modifier.toString(c.getModifiers())); // 获取构造方法的修饰符
            s.append(" ");
            s.append(clazz.getSimpleName()); // 获取构造方法的名
            s.append("(");

            // 获取该构造方法中的实参列表
            Class[] p = c.getParameterTypes();
            if (!(p.length == 0 || p == null)) {
                for (Class aClass : p) {
                    s.append(aClass.getSimpleName()); // 实参类型
                    s.append(",");
                }

                // 删除最后下标位置上的字符
                s.deleteCharAt(s.length() - 1);
            }
            s.append("){}\n");
        }

        s.append("}");
        System.out.println(s);
    }

    /** 使用反射机制调用构造器
     *
     */
    @Test
    public void test2() throws Exception {
        // 类加载器：自动会调用该类中的静态代码块，而不会创建实例对象
        Class clazz = Class.forName("day29.Vip");

        // 调用无参构造器,
        Object o = clazz.newInstance(); // 这个调用构造器必须是 public 的才行
        // 第一步：先获取到这个有参数的构造器
        Constructor declaredConstructor = clazz.getDeclaredConstructor(int.class, String.class);
        // 私有可以被反射访问
        declaredConstructor.setAccessible(true);
        // 第二步：调用构造器对象
        Object tom = declaredConstructor.newInstance(110, "Tom");
        System.out.println(tom);


    }
}


class Vip {
    int no;
    String name;
    String birth;
    boolean sex;

    public Vip() {
    }

    private Vip(int no, String name) {
        this.no = no;
        this.name = name;
    }

    private Vip(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", sex=" + sex +
                '}';
    }
}