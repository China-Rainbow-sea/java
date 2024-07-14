package day34.com.rainbowsea.javase.net.onewaycommunication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader bufferedReader = null;

        try {
            // 先启动服务端，启动服务器端后，这个应用肯定要对应一个端口
            // 创建服务器端套接字对象
            int port = 8888;  // 指明端口
            serverSocket = new ServerSocket(port);
            System.out.println("服务器端正在启动,请稍后...");
            System.out.println("服务器端启动成功,端口号: " + port + "，等待客户端的请求");


            // 开始接收客户端的请求
            clientSocket = serverSocket.accept();

            // 后续代码怎么写一会再说？
            // 服务端接收消息，所以服务端应该获取输入流
            bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // 开始读
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭服务端套接字
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
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
