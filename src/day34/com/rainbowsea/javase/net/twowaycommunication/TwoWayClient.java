package day34.com.rainbowsea.javase.net.twowaycommunication;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 双向通信
 */
public class TwoWayClient {
    public static void main(String[] args) {
        Socket clientSocket = null;
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            // 创建客户端套接字
            clientSocket = new Socket(InetAddress.getLocalHost(), 8888);

            // 发送一张图片给服务器
            bufferedOutputStream = new BufferedOutputStream(clientSocket.getOutputStream());

            // 开始写图片到服务器
            // 一边读一边写(读客户端本地硬盘上的图片)
            bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\Java\\JavaRebuilt\\src\\day34\\com\\rainbowsea\\javase" +
                    "\\net\\twowaycommunication\\hongye.jpg"));

            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes,0,readCount);
            }

            // 刷新
            bufferedOutputStream.flush();

            // 关闭输出（输出结果）
            clientSocket.shutdownOutput();

            // 接收服务器响应回来的消息
             bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
