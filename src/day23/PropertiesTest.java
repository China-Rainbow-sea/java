package day23;

import org.junit.Test;

import java.util.Properties;

/**
 * Properties属性类对象的相关方法
 * Properties 是一个Map集合，继承Hashtable , Properties 的key 和value 都是String类型
 * Properties 被称为属性类对象。
 * Properties 是线程安全的
 */
public class PropertiesTest {

    @Test
    public void test() {
        // 创建 Properties 对象
        Properties pro = new Properties();

        // 需要掌握 Properties() 的两个方法，一个存，一个取
        pro.setProperty("url","jdbc:mysql://localhost:3306/bijin");
        pro.setProperty("driver","com.mysql.jdbc.Driver");
        pro.setProperty("username","root");
        pro.setProperty("password","123");


        // 通过 key 获取对于的 value 值
        String url = pro.getProperty("url");
        String driver = pro.getProperty("driver");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");

        System.out.println(url);
        System.out.println(driver);
        System.out.println(username);
        System.out.println(password);


    }
}
