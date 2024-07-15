package day34.com.rainbowsea.javase.net.udpcommunication;




import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP编程，接收端
 */
public class Receive {
    public static void main(String[] args) throws Exception {
        // 创建 UDP的 Socket 套接字
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte[] bytes = new byte[1024 * 64];
        // 准备一个包，这个包接收发送方的信息
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        // 程序执行到这里，停下来，等待发送方的发送
        datagramSocket.receive(datagramPacket);

        // 程序执行到这里说明，已经完全将发送方发送的数据接收到了
        // 从包中取出来数据

        String msg = new String(bytes, 0, datagramPacket.getLength());

        System.out.println("接收到发送方发过来的消息: " + msg);

        datagramSocket.close();

    }
}
