package day29.IoRead;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSetMetaData;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 读取指定 Properties 该后缀文件的配置文件信息。的方式
 */
public class IoPropertiesTest {
    @Test
    public void test() {

        // 直接以流的形式返回。
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("db.properties");

        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String tom = properties.getProperty("name");
        System.out.println(tom);
    }


    /**
     * 方式二:
     * java.util 包下提供了一个资源绑定器，便于获取属性配置文件中的内容。
     * 使用以下这种方式的时候，属性配置文件必须是 xxx.properties 必并且必须放到类路径下
     *
     */
    @Test
    public void test2() {
        // 资源绑定器，只能绑定xxx.properties文件，并且这个文件必须在类路径下。
        // 并且在写路径的时候，路径后面的扩展名不能写，写了会报错
        // ResourceBundle db = ResourceBundle.getBundle("db.properties"); java.util.MissingResourceException: Can't find bundle for base name db.properties, locale zh_CN
        ResourceBundle db = ResourceBundle.getBundle("db");
        String name = db.getString("name");
        System.out.println(name);

        ResourceBundle dundle = ResourceBundle.getBundle("day29/IoRead/classinfo"); // 注意不要写后缀
        String className = dundle.getString("className");
        System.out.println(className);
    }


}
