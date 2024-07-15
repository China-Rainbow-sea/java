package day34.com.rainbowsea.javase.net.udpcommunication;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP编程， 发送端
 */
public class Send {
    public static void main(String[] args) throws Exception {
        // 创建一个 UDP的Socket 套接字
        DatagramSocket datagramSocket = new DatagramSocket();

        //  创建包
        byte[] bytes = "RainbowSea".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, InetAddress.getLocalHost(), 8888);

        // 发送消息,将封装到包(datagramPacket) 中的信息发送过去
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
