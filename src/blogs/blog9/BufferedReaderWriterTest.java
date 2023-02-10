package blogs.blog9;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterTest {
    public static void main(String[] args) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/blogs/blog9/hello.txt",true);
            // 1.创建字节输出缓冲流对象
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            // 2. 写入信息
            byte[] bytes = new byte[]{'K','K'};
            bufferedOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭IO资源这里不用flush()因为缓冲流会自动刷新
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main4(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/blogs/blog9/hello.txt");

            // 1. 创建字节输入缓冲流对象
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            // 2. 读取文件信息
            int len = 0;
            byte[] bytes = new byte[3];
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                // 将 bytes 转换为字符串，读取了多少转换为多少
                String s = new String(bytes,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭IO资源
            // 关闭IO资源这里只需要关闭外层缓冲区的资源就可以，内层的会自动一起关闭
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void main3(String[] args) {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter("src/blogs/blog9/hello.txt",true);
            // 1. 创建字符输出缓冲流对象
            // 参数是：Writer 抽象类，这里我们使用 BufferedWriter 同样也是 Writer 的子类作为参数
            bufferedWriter = new BufferedWriter(fileWriter);
            // 2. 写入文件信息
            char[] chars = new char[]{'H','H'};
            bufferedWriter.write("\n"); // 换行
            bufferedWriter.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭IO资源这里不用flush()因为缓冲流会自动刷新
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }



    public static void main2(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader("src/blogs/blog9/hello.txt");
            // 1. 创建字符输入缓冲流对象
            // 参数是：Reader 抽象类，这里我们使用 FileReader 同样也是 Reader 的子类作为参数
            bufferedReader = new BufferedReader(fileReader);

            // 2. 读取文件信息
            int len = 0;
            char [] chars = new char[3];
            while((len = bufferedReader.read(chars))!= -1) {
                // 将 char 转换为字符串
                // 读多少转换多少
                String s = new String(chars,0,len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭IO资源
            if (bufferedReader != null) {
                try {
                    // 只需要关闭外层缓冲区的资源就可以，内层的会自动一起关闭
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
