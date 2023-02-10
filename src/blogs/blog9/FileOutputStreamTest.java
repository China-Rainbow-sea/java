package blogs.blog9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            // 1.创建 test2.png 文件的输入字节流对象
            fileOutputStream = new FileOutputStream("src/blogs/blog9/test2.png");
            // 2.创建 test.png 文件的输出字节流对象
            fileInputStream = new FileInputStream("src/blogs/blog9/test.png");

            // 2. 一边读，一边写
            int len = 0;
            byte[] bytes = new byte[1024 * 1024]; // 1MB
            // 读
            while ((len = fileInputStream.read(bytes)) != -1) {
                // 读取多少写入多少
                fileOutputStream.write(bytes, 0, len);
            }

            // 3. 刷新：
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭IO资源
            // 分开 try 防止，如果一起try的话，其中一个出现了异常，后面的IO资源就无法关闭了。
            if (fileInputStream != null) {  // 防止null引用
                try {
                    fileInputStream.close();
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


    public static void main2(String[] args) {
        File file = new File("src/blogs/blog9/hello.txt");
        FileOutputStream fileOutputStream = null;
        try {
            // 1. 创建FileOutputStream对象
            fileOutputStream = new FileOutputStream(file, true);

            // 2. 写入信息到文件中
            byte[] bytes = new byte[]{'A', 'B'};
            fileOutputStream.write(bytes);

            // 3. 刷新:将遗留在内存当中没有写入到文件的信息，强制全部写入到文件中
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭IO资源
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main1(String[] args) {
        File file = new File("E:\\Java\\JavaRebuilt\\src\\blogs\\blog9\\test.png"); // 绝对路径
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream("src/blogs/blog9/test.png"); // 相对路径
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
