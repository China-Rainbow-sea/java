package day34.com.rainbowsea.javase.net.twowaycommunication;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 双向通信
 */
public class TwoWayServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            // 创建服务器套接字对象
            int port = 8888;  // 端口号
            serverSocket = new ServerSocket(port);

            System.out.println("服务器启动成功，正在接收客户端的请求");

            // 开始接收客户端的请求
            clientSocket = serverSocket.accept();

            // 获取输入流
            bufferedInputStream = new BufferedInputStream(clientSocket.getInputStream());

            // 新建输出流，输出读取到的信息，到硬盘当中
            //new BufferedOutputStream(new FileOutputStream("本地服务器硬盘地址"))
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("./test.jpg"));

            // 开始读
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = bufferedInputStream.read(bytes)) != -1) {
                // 把客户端发送过来的图片，保存到本地服务器中
                bufferedOutputStream.write(bytes, 0, readCount);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
