package day24;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Properties 读取配置文件信息
 */
public class PropertiesTest {
    @Test
    public void test() throws Exception {
        Properties pros = new Properties();

        FileInputStream fis = new FileInputStream("jdbc.properties"); // IO流读取
        pros.load(fis);

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        fis.close();  // 关闭IO流文件


    }
}
