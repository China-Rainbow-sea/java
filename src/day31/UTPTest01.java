package day31;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议的网络编程，面向无连接不可靠的传输
 * 因为UDP是无连接不可靠: 所以无论发送端，还是接受端都可以先运行
 */

public class UTPTest01 {

    // 发送端
    @Test
    public void sender() {

        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();

            String str = "我是UDP方式发送的导弹";
            byte[] data = str.getBytes();  // 将字符串转换为字节数组
            InetAddress inet = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet,6800);

            datagramSocket.send(packet);  // 将信息发送到服务端
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }

    }

    // 接受端
    @Test
    public void receiver() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(6800);

            byte[] bytes = new byte[1024];

            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);

            socket.receive(packet);  // 接受客户端的信息
            // 获取到客户端的信息，转换为字符串
            String s = new String(packet.getData(), 0, packet.getLength());
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (socket != null) {
                socket.close();
            }
        }
    }

}
