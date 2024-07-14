package day34.com.rainbowsea.javase.net;


import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL包括四部分：协议:IP地址:端口:资源名称
 * URL是网络中某个资源的地址，某个资源的唯一地址
 * 通过URL是可以真实的定位到资源的
 * 在Java中，Java类库提供了一个URL类，来提供对URL的支持
 * URL的类的构造方法:
 *  URL url = new URL("url");
 *  URL类的常用方法
 */
public class URLTest {

    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com/oa/index.html?name=lihua&passwrod=123#tip");


        // 获取URL中的信息
        String protocol = url.getProtocol();
        System.out.println("协议: " + protocol);

        // 获取资源路径
        String path = url.getPath();
        System.out.println("资源路径: " + path);

        // 获取默认端口(HTTP协议的默认端口是80,HTTPS的协议端口是:443)
        int defaultPort = url.getDefaultPort();
        System.out.println("默认端口: " + defaultPort);


        // 获取当前的端口
        int port = url.getPort();
        System.out.println("当前端口号: " + port);

        // 获取URL中的IP地址
        String host = url.getHost();
        System.out.println("主机地址: " + host);

        // 获取URL准备传送的数据
        String query = url.getQuery();
        System.out.println("需要提交给服务器的数据: " + query);

        String ref = url.getRef();
        System.out.println("获取锚点: " + ref);

        // 获取 资源路径 + 数据
        String file = url.getFile();
        System.out.println("获取数据资源文件路径: " + file);
    }
}
