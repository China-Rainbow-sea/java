package day31;


import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 1.IP: 唯一的标识 Internet 上的计算机(通信实体)
 * 2.在Java中使用InetAddress 类代表IP
 * 3.IP 分类: IPV4 和 IPV6 ; 万维网 和局部网
 * 4.域名: www.baidu.com www.mi.com www.sina.com www.jd.com www.vip.com
 *
 * 5.本地回环地址 : 127.0.0.1 对应着的域名为 : getByName(String host)
 *    两个常用的方法: getHostName()获取到该ip地址的域名 / getHostAddress()获取到该ip地址的ipv4的地址
 *
 * 6. 端口号: 正在计算机上运行的进程。
 *    要求: 不同的进程不同的端口号
 *    范围: 被规定为一个 16位的整数 0~65535
 *
 * 7. 端口号与IP地址的组合得出一个网络套接字 Socret
 */
public class InetAddressTest {


    /**
     * 如何实例化： InetAddress对象两个方法: getByName(String host) 获取到指定的地址,getLocalHost()获取到的是本地地址
     */
    @Test
    public void test() {

        // 创建 InetAddress Inet中网络地址的对象
        InetAddress byName = null;
        InetAddress inet = null;
        try {
            byName = InetAddress.getByName("127.0.0.1");
            System.out.println(byName);


            // 获取到本地服务器的地址
            InetAddress localHost = InetAddress.getLocalHost();

            inet = InetAddress.getByName("www.baidu.com");
            System.out.println(inet);

            // getHostName() 获取到该ip 地址的域名
            String hostName = inet.getHostName();
            System.out.println(hostName);
            String hostAddress = inet.getHostAddress();
            System.out.println(hostAddress);


            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
