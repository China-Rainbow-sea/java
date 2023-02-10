package blogs.blog9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 1. 创建字节流对象
            fileInputStream = new FileInputStream("src/blogs/blog9/hello.txt");

            // 2.读取文件信息
            int len = 0;
            byte[] bytes = new byte[1024];  // 1KB
            // read(bytes) 一次性读取byte[]数组大小的字节个数，并存储到 bytes 数组中，返回读取的字节个数
            while((len = fileInputStream.read(bytes)) != -1) {
                // 将 bytes 数组转换为字符串，读取多少，转换多少
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭IO资源
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




    public static void main2(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            // 1. 创建字节流对象
            fileInputStream = new FileInputStream("src/blogs/blog9/hello.txt");

            int len = 0;
            // 2.读取文件信息
            while((len = fileInputStream.read()) != -1) {
                System.out.println(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭资源
            // 防止null引用
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void main1(String[] args) {
        File file = new File("E:\\Java\\JavaRebuilt\\src\\blogs\\blog9\\test.png"); // 绝对路径
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream2 = new FileInputStream("src/blogs/blog9/test.png"); // 相对路径
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
