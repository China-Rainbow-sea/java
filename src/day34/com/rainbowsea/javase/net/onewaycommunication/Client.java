package day34.com.rainbowsea.javase.net.onewaycommunication;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 现在使用Java中的 Socket实现单向通信，基于 TCP协议，属于TCP编程
 */
public class Client {
    public static void main(String[] args) {
        Socket clientSocket = null;
        BufferedWriter bufferedWriter = null;
        Scanner scanner = new Scanner(System.in);

        // 创建客户端套接字对象
        // 需要指定服务器的IP地址，和端口号
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            int port = 8888;
            clientSocket = new Socket(localHost, port);

            // 客户端给服务器端发送信息
            // 客户端你是输出流
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            // 发送信息
        /*    bufferedWriter.write("你好，最近怎么样");
            bufferedWriter.write("\n");
            bufferedWriter.write("你收到消息了吗");*/

            // 循环发送信息
        /*    while (true) {
                bufferedWriter.write("你好，最近怎么样");
                bufferedWriter.write("\n");
                bufferedWriter.write("你收到消息了吗");
                // 因为使用了缓存机制，需要记得刷新
                bufferedWriter.flush();

                // 延迟效果
                Thread.sleep(1000);
            }*/


            // 键盘中输入信息，发送给服务器端
            while (true) {
                System.out.println("请输入您要发送的信息: ");
                // 从键盘上接收的消息
                String msg = scanner.next();

                // 把消息发送给服务器端
                bufferedWriter.write(msg);

                bufferedWriter.write("\n"); // 换行

                // 刷新
                bufferedWriter.flush();

            }

            // 因为使用了缓存机制，需要记得刷新
            //bufferedWriter.flush();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            scanner.close();
        }


    }
}
