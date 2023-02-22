package blogs.blog11;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest06 {
    public static void main(String[] args) {
        try {
            // 1. 创建该类的 Class 字节码对象
            Class clazz = Class.forName("blogs.blog11.MyClass6");

            // 2. 获取该类的实例化对象: 因为这里我们已经知道需要实例化的对象是什么了，所以可以直接强制转换
            // newInstance()实际调用的是该类中的无参构造器，所以该类必须要有无参构造器
            MyClass6 myClass = (MyClass6) clazz.newInstance();

            // 3. 获取需要访问的属性的 Field 对象((根据属性的名称来获取Field))
            Field fieldName = clazz.getDeclaredField("name");

            // 4. 给MyClass6 对象中的 私有 name 属性赋值
/*
        虽然使用了反射机制，但是三要素还是缺一不可：
        要素1: Object 对象，修改赋值的对象上的属性值
        要素2: no 属性
        要素3: 100属性值
         */
            // 通过将为setAccessible(true)反射可以访问私有的属性
            fieldName.setAccessible(true);

            // 5.使用 set()对属性赋值
            // set(对应的赋值的对象,该对象中想要赋的属性值)
            fieldName.set(myClass,"Tom"); // 注意所赋的值，需要符合该类中的这个属性的定义，不然报错


            // 6.读取属性的值:
            // 两个要素：MyClass6 对象的 name 属性的值
            Object o = fieldName.get(myClass);
            System.out.println(o);

            System.out.println(myClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


    public static void main1(String[] args) {
        // 这里我们创建一个字符串，用于字符串的拼串
        StringBuilder s = new StringBuilder();
        Class clazz = null;

        try {
            // 1. 获取到该类的Class 字节码对象
            clazz = Class.forName("blogs.blog11.MyClass6");

            // 2. 实例化该对象:因为这里我们已经知道需要实例读的对象是什么了，所以可以直接强制转换
            // newInstance()方法调用的是该类中的无参构造器，所以无参构造器必须要有
            MyClass6 myClass = (MyClass6) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // 将该类中的 修饰符 类名  添加到该字符串中
        s.append(Modifier.toString(clazz.getModifiers()) + "class \t" + clazz.getSimpleName() + "\t{ \n");

        // 3. 获取到该类中的所有属性，包括private 私有的
        // 因为一个类中的属性是多个，所以返回的是 Field 属性数组
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            s.append("\t");
            // 获取到该属性中的修饰符
            int modifiers = f.getModifiers();
            String bedeck = Modifier.toString(modifiers);
            s.append(bedeck);  //添加到字符串中
            s.append(" ");

            // 获取到该属性的类型
            Class<?> type = f.getType();
            // 获取到该属性的类型名称
            String nameType = type.getName();
            s.append(nameType); // 添加
            s.append(" ");

            // 获取到属性名
            String nameAttribute = f.getName();
            s.append(nameAttribute); // 添加
            s.append("\n");

        }

        s.append("}");
        System.out.println(s);
    }
}


class MyClass6 {

    private String name;
    protected int age;
    private int id;
    boolean sex;

    public MyClass6() {

    }


    @Override
    public String toString() {
        return "MyClass6{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
