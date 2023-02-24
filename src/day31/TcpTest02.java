package day31;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题2: 客户端发送文件给服务器，服务端将文件保存在本地
 * 服务端：接受到信息后，给予客户端一个反馈信息，
 * 客户端：将接受到服务端的反馈信息，并显示在控制台中。
 * 注意: 服务端，先执行
 *
 */
public class TcpTest02 {


    // 客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fis = null;

        try {
            // 创建一个ip与对象
            InetAddress inet = InetAddress.getByName("127.0.0.1");

            // 创建:  客户端传输到的服务端对应的ip地址，端口号
            socket = new Socket(inet,9090);

            // 创建一个字节输出流，通过该字节输出流，将数据从网络中传输
            outputStream = socket.getOutputStream();
            // 定义一个传输的图片信息的输入字节流，到内存当中
            fis = new FileInputStream(new File("src/day31/java.png"));

            byte[] buffer = new byte[1024];
            int len;

            // 读取该图片的字节信息，到内存当中
            while((len = fis.read(buffer)) != -1) {
                // 将信息写入到对应的文件中，读取到多少信息，就写入多少信息
                outputStream.write(buffer,0,len);
            }

            // 关闭客户端数据的输出，不然客户端可能会一直输出，而服务端一直等待，客户端的信息，导致死循环:
            socket.shutdownOutput();

            // 客户端接受到服务端中的信息，并显示到控制台中
            InputStream is = socket.getInputStream();
            // 定义了java.io.ByteArrayOutputStream 工具类中读取信息，防止读取中文出现，
            // 读取不全，截断，导致乱码的情况
            // 该工具类 的原理是：读取到字节的全部信息，存储到数组当中，如果不足，会自动扩容，不会出现分片的现象
            //
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[20];
            int len2;
            while((len2 = is.read(bytes)) != -1) {
                // 读取多少，便写入多少
                baos.write(bytes,0,len2);
            }

            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源:
            if (fis != null) {
                try {
                    fis.close();
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

            if (socket != null) {
                try {
                    socket.close();
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
        FileOutputStream fileOutputStream = null;
        try {
            // 1. 创建服务端对象，并设置其对应的端口号，注意: 客户端与服务端的端口号保持一致
            serverSocket = new ServerSocket(9090);
            // 2. 创建服务端 Socket 套接口
            socket = serverSocket.accept();
            // 3. 创建一个字节输入流对象，读取到客户端发送的信息
            inputStream = socket.getInputStream();
            // 4.创建一个文件存储，从客户端读取到的信息
            fileOutputStream = new FileOutputStream(new File("src/day31/java2.png"));
            // 5. 读取多少字节信息，就将多少字节信息输入到文件中
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }

            // 6. 服务端给予客户端反馈
            OutputStream outputStreamWriter = socket.getOutputStream();
            outputStreamWriter.write("你好，我信息接受成功到了".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭资源
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

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
