package day34.com.rainbowsea.javase.net;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * java.net.IntAddress类用来封装设计计算机IP地址和DNS（没有端口信息）
 * 它包括一个主机名和一个地址，是Java对IP地址的高层表示，大多数其它
 * 网络类都要用到这个类，包括 Socket，ServerSocket，URL.DatagramSocket，DatagramPacket等
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机的IP地址和主机名的封装对象: InetAddress
        InetAddress inetAddress = InetAddress.getLocalHost();

        // 获取本机的IP地址
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("本机IP地址: " + hostAddress);

        // 获取本机的主机名
        String hostName = inetAddress.getHostName();
        System.out.println("本机的主机名: " + hostName);

        // 通过域名来获取InetAddress 对象
        InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress2.getHostName());  // www.baidu.com
        System.out.println(inetAddress2.getHostAddress());  // 36.155.132.3


    }
}
