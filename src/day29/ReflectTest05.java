package day29;


import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射属性 Field
 * Field 翻译为字段，其实就是属性/成员
 *
 */
public class ReflectTest05 {
    @Test
    public void test()  throws Exception {
        // 获取整个类，类加载器
        Class clazz = Class.forName("day29.Student"); // 全类路径
        // 获取类中所有的Field
        // 因为类中有多个属性，所以返回的是数组
        Field[] fields = clazz.getFields();  // 该方法只能获取到 public 的属性值
        System.out.println(fields.length);  // 测试这个数组中只有1个元素
        // 单独取出这个值的名字
        System.out.println(fields[0].getName());
        // 取出整个 field 的名字:
        for(Field f : fields) {
            System.out.println(f);
        }
        System.out.println("**********************");
        // 获取到类中所有的 Field 包括private 私有的
        Field[] fields2 = clazz.getDeclaredFields();
        System.out.println(fields2.length);
        for(Field f : fields2) {
            System.out.println(f);
        }
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Class.forName("day29.Student");  // 全类路径名
        String clazzName = clazz.getName();  // 获取到该类的完整类名
        System.out.println("完整类名: " + clazzName);

        String simpleName = clazz.getSimpleName(); // 获取到该类的简单类名
        System.out.println(simpleName);

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 获取属性的修饰符(public ,final ,static)
            int modifiers = field.getModifiers(); // 返回的修饰符是一个数字，每个数字是修饰符的代号:
            System.out.println(modifiers);
            // 可以将这个 “代号” 数字转换成“字符串”
            String s = Modifier.toString(modifiers);
            System.out.println(s);


            // 获取属性的类型:
            Class<?> type = field.getType();
            //System.out.println(type);
            String fName = type.getName();  // 获取到该属性的类型
            System.out.println(fName);

            // 获取属性的名字:
            System.out.println(field.getName());

        }
    }

    @Test
    public void test3() throws Exception {
        // 创建这个是为了拼接字符串
        StringBuilder stringBuilder = new StringBuilder();

        Class clazz = Class.forName("day29.Student");
        stringBuilder.append(Modifier.toString(clazz.getModifiers()) + "class \t" + clazz.getSimpleName() + "\t{ \n" );

        Field[] fields = clazz.getDeclaredFields();

        for(Field f : fields) {
            stringBuilder.append("\t");
            stringBuilder.append(Modifier.toString(f.getModifiers()));  // 获取属性的修饰符
            stringBuilder.append(" ");
            stringBuilder.append(f.getType().getName());  // 获取属性的类型
            stringBuilder.append(" ");
            stringBuilder.append(f.getName());
            stringBuilder.append(";\n");
        }

        stringBuilder.append("}");
        System.out.println(stringBuilder);
    }


    @Test
    public void test4() {
        // 我们不使用反射机制访问对象的属性
        Student student = new Student();
        System.out.println(student.age);
    }


    /**
     * 使用反射机制，访问对象的属性(set get)
     */
    @Test
    public void test5() throws Exception {
        // 加载该类对象
        Class<?> clazz = Class.forName("day29.Student");
        // 实例化该对象:因为这里我们已经知道需要实例化的对象是什么了，所以可以直接强制转换
        Student student = (Student) clazz.newInstance();

        // 获取no 属性(根据属性的名称来获取Field)
        Field no = clazz.getDeclaredField("name");

        // 给student 对象的 no 属性赋值
        /*
        虽然使用了反射机制，但是三要素还是缺一不可：
        要素1: Object 对象，修改赋值的对象上的属性值
        要素2: no 属性
        要素3: 100属性值
         */
        // 通过配置 为 true 反射可以访问私有的属性
        no.setAccessible(true);
        no.set(student,"Tom"); // 注意所赋的值，需要符合该类中的这个属性的定义，不然报错

        // 读取属性的值
        // 两个要素：获取Student 对象的 no 属性的值
        System.out.println(no.get(student));


    }
}


//如下 4个Field, 分别采用了不同的访问控制权限修饰符
class Student {
    public int no;
    private String name;
    protected int age;
    boolean sex;

    public static final double MATH_PI = 3.1415926;

}