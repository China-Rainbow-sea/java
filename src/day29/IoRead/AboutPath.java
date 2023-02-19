package day29.IoRead;


import day17.EcmDef;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * import java.io.FileReader;
 * 研究一下文件路径问题：
 *  怎么获取一个文件的绝对路径，以下讲解的这种方式是通用的。但前提是：文件需要在类路径下。才能用这种方式。
 */
public class AboutPath {
    @Test
    public void test() throws Exception {
        // 这种路径缺点是: 移植性差:在IDEA 中默认的当前路径是Project 的根
        // 这个代码假设离开了IDEA ，换到了其它位置，可能当前路径就不是Project的根了。
        // FileReader reader = new FileReader("src/day29/IoRead.properties");

        // 接下来说一种比较通用的一种路径：即使代码换位置了，这样编写仍然是通用的
        // 注意：使用以下通用方式的前提是：这个文件必须在类路径下
        // 什么类路径 下？？ 方式在 src下都是类路径下 《记住它》
        // src 是类的根路径

        // 从类的根路径下作为起点开始的，如果 src 在包下，需要指明包
        String path = Thread.currentThread().getContextClassLoader().
                getResource("day29/IoRead/classinfo.properties").getPath();
        System.out.println(path);
        // 采用上述方法可以拿到一个文件的绝对路径: /E:/Java/JavaRebuilt/out/production/JavaRebuilt/day29/IoRead/classinfo.properties

        // 获取到 db.properties 文件的绝对路径 ： 如果直接在 src 目录下，没有包(包含)可以直接使用文件名，需要带上后缀
        // 如下的这种获取文件的方式是通用的。
        String path2 = Thread.currentThread().getContextClassLoader().getResource("db.properties").getPath();
        System.out.println(path2);

        /*
        解释:
         Thread.currentThread() 当前线程对象
         getContextClassLoader() 是线程对象的方法，可以获取到当前线程的类加载对象。
         getResource() 获取资源：这是类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源。
         */

        FileInputStream fileInputStream = new FileInputStream(path);
    }

    @Test
    public void test2() {
        String path = Thread.currentThread().getContextClassLoader().getResource("test.txt").getPath();
        System.out.println(path);
    }


    /**
     * 使用上述读取文件的方式，获取到文件的路径，通过该路径创建 输入字节流对象，再创建Properties 读取配置文件信息】
     */
    @Test
    public void test3() throws Exception {
        String path = Thread.currentThread().getContextClassLoader().getResource("db.properties").getPath();
        // 创建输入字节流对象
        FileInputStream fileInputStream = new FileInputStream(path);

        // 创建 Properties 对象
        Properties properties = new Properties();
        properties.load(fileInputStream);

        String name = properties.getProperty("name");
        System.out.println(name);

    }
}
