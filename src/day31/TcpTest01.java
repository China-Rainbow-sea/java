package day31;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 举例: 客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 * 注意：是先将服务端启动，再启动客户端的
 * 如果服务端都没有启动，客户端将数据发送给谁呢
 */
public class TcpTest01 {

    // 客户端
    @Test
    public void client() {

        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            // 将信息发送到 inet 这个ip地址的服务端,中的8899端口号的进程（软件）
            socket = new Socket(inet,8899);

            // 将客户端的数据，以字节流的形式，在网络中传输
            outputStream = socket.getOutputStream();
            outputStream.write("你好，我是客户都".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    // 服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;

        try {
            // 创建服务端对象，并设定对应的端口号: 注意客户端发送的服务端之间的端口号要保持一致
            serverSocket = new ServerSocket(8899);

            // 接受客户端中发送的信息的套接口对象
            socket = serverSocket.accept();
            // 通过字节输入流将从客户端中获取到的信息，输入到内存当中
            inputStream = socket.getInputStream();

            // 获取是哪个客户端 Ip 发送的信息
            System.out.println("收到了来自于"+socket.getInetAddress().getHostAddress() + "的数据");


            // 如下方式，读取信息，存在一个问题：
        /*
        如果传的是中文信息，3个字节为一个汉字，当 1024 个bit 无法一次性将所以的中文信息获取到。
        存在一个截断的情况，当一个汉字仅仅读取到了该汉字的 2个字节，该读取到的汉字信息就是错误的乱码信息。
        再次读取文件中汉字的信息时，由
        举例: 你好世界  假设一次读取到了 4 个字节，
        “好”这个汉字只读取了 其中的 1个字节，截断了，信息不全，乱码
        当再次读取的时候，读取 “好”这个字的，后2个字节，还是不全，乱码，
        因为该方式一次性读取的是 byte[] 数组大小的内容，后面读取的是分片的，
        是不会将前面读取到的信息拼接起来的。局部变量。覆盖了数组信息。
         */
        /*byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) != -1) {
            // 读取多少转换多少
            String str = new String(buffer,0,len);
            System.out.println(str);
        }
*/

            // 建议使用: java.io.ByteArrayOutputStream 中的工具类
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len  = 0;

            while((len = inputStream.read(buffer))!= -1) {
                // 该ByteArrayOutputStream工具类，是将读取到所有的信息，存储到一个数组当中
                // 不足的时候，会自动扩容。不会分片，而是一个整体
                // 读取到的信息都存储在，写入到了 ByteArrayOutputStream 这个工具类中的数组当中了
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源:
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
