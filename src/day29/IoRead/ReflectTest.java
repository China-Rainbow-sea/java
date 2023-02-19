package day29.IoRead;


import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 验证反射机制的灵活性
 *
 *    java 代码写一遍，再不改变Java源代码的基础上，可以做到不同对象的实例化。
 *    非常灵活。(符合：OCP开闭原则：对扩展开放，对修改关闭。)
 *
 *
 *    后期：我们要学习的就是高级框架，而工作过程中，也都是使用高级框架，
 *    包括: ssh ssm
 *      Spring SpringMVC MyBatis
 *      Spring Struts Hibernate
 *      ...
 *      这些高级框架底层实现原理: 都是采用反射机制，所以反射机制还是重要的：
 *      框架: 设计模式 + 反射 + 注解
 *      学会了反射机制有利于你理解，刨析框架底层源代码
 *
 */
public class ReflectTest {
    /**
     * 没有使用反射读取文件信息
     */
    @Test
    public void test() throws Exception {
        // 通过 IO 读取classinfo.properties 文件
        Properties properties = new Properties();
        // 输入字节流对象，默认是在 src 同级目录下为：相对路径
        FileInputStream inputStream = new FileInputStream("src/day29/IoRead/classinfo.properties");

        properties.load(inputStream);

        String className = properties.getProperty("className");
        System.out.println(className);

        if(inputStream != null) {
            inputStream.close();  // 关闭 IO资源
        }

    }


    /**
     * 先通过读取IO文件中的对象信息，再通过该读取到的信息，
     * 使用反射创建实例化对象
     */
    @Test
    public void test2() throws Exception  {
        // 通过 IO 读取classinfo.properties 文件
        Properties properties = new Properties();
        // 输入字节流对象，默认是在 src 同级目录下为：相对路径
        FileInputStream inputStream = new FileInputStream("src/day29/IoRead/classinfo.properties");

        properties.load(inputStream);

        String className = properties.getProperty("className");

        // 通过反射实例化对象
        Class c = Class.forName(className);
        Object o = c.newInstance();
        System.out.println(o);

        if(inputStream != null) {
            inputStream.close();  // 关闭 IO资源
        }
    }

}
