package day28;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 */
public class ClassLoaderTest {


    @Test
    public void test() {
        // 对于自定义类，使用系统类加载进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        // 调用系统类加载器的getParent(): 获取扩展类加载器
        ClassLoader classLoader2 = classLoader.getParent();
        System.out.println(classLoader2);

        // 调用扩展类加载器到getParent():  无法获取引导类加载器
        // 引导类加载器主要负责: 加载Java的核心类型，无法加载自定义类的。
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);

        // JDK 中的类是被 引导类加载器加载到的。这个引导类加载器我们无法获取到的。
        ClassLoader classLoader4 = String.class.getClassLoader();
        System.out.println(classLoader4);
    }


    /**
     * Properties 用来读取配置文件信息
     */
    @Test
    public void test2() {
        // 没有使用反射
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/day28/jdbc.properties");
            Properties properties = new Properties();
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String user = properties.getProperty("user");
            System.out.println(user);
            String password = properties.getProperty("password");
            System.out.println(password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭IO资源
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 使用反射进行获取
    @Test
    public void test3() {
        // Map 集合
        Properties properties = new Properties();

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 注意: 该文件路径需要在 src 目录下才行，注意: 再包下时需要说明包路径下的位置
        // 读取配置文件的方式二: 使用ClassLoader
        // 配置文件默认识别为: 当前module的src 下
        InputStream resourceAsStream = classLoader.getResourceAsStream("day28/jdbc.properties");

        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String user = properties.getProperty("user");
        System.out.println(user);
        String password = properties.getProperty("password");
        System.out.println(password);

    }
}
