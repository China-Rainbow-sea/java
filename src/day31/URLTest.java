package day31;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * URL: 统一资源定为符
 */
public class URLTest {


    @Test
    public void test() {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/jdbc/test.txt");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // 获取到URL的协议名
        String s = url.getProtocol();
        System.out.println(s);

        // 获取该URL的主机名
        String s2 = url.getHost();
        System.out.println(s2);

        // 获取该URL的端口号
        int num = url.getPort();
        System.out.println(num);

        // 获取该URL的文件名
        String s3 = url.getFile();
        System.out.println(s3);

        // 获取到该URL的路径
        String path = url.getPath();
        System.out.println(path);

        // 获取到该URL的查询名
        String query = url.getQuery();
        System.out.println(query);
    }
}
