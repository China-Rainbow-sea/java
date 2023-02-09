package day27;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 测试FileInputStream 和 FileOutputStream 的使用
 * 结论:
 *   1. 对于文本文件：(.txt,.java,.c,cpp) 使用字符流处理
 *   2. 对于非文本文件(.jsp,mp3,mp4,avi,doc,ppt,...) 使用字符流处理。
 *
 */
public class FileInputOutpuStreamTest {


    /**
     * 字节流读取文件内容
     *
     *
     */
    @Test
    public  void test1() {
        // 1.造文件
        File file = new File("src/day27/hello.txt");  // 注意后缀
        FileInputStream fileInputStream = null;

        try {
            // 2. 创建字节输入流:读取文件内容
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[10];
            int len = 0;

            //3. 读取文件内容
            // read(byte[] bytes) 将文件中的内容读取到byte数组中，并返回读入文件的字节个数，文件末尾返回 -1
            while ((len = fileInputStream.read(bytes)) != -1) {
                // 将byte[] 数组转换为字符串
                String s = new String(bytes, 0, len); // 读取多少，便转换多少
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭IO
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用字节流对图片进行拷贝复制
     */
    @Test
    public void test2() {

        long start = System.currentTimeMillis();  // 获取当前系统时间
        // 创建对应的文件
        File file = new File("src/day27/test2.jpg");
        File file2 = new File("src/day27/test3.jpg");  // 注意后缀
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            // 创建字节输入/输出流
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file2);

            // 一边读，一边写入数据
            byte[] bytes = new byte[1024 * 1024];  // 1Mb
            int len = 0;
            while((len = fileInputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes,0,len);
            }

            // 刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭 IO
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();  // 获取当前系统时间。

        System.out.println("消耗的时间: " + (end - start));
    }

    /**
     * 使用字节缓冲流，进行一个图片的拷贝复制
     * 处理流之一: 缓冲流的使用
     * 1.缓冲流：
     * BufferedInputStream
     * BufferedOutputSteam
     * BufferedReader
     * BufferedWriter
     *
     * 作用: 提供流的读取，写入的速度
     *   提高读写速度的原因：内部提供了一个缓冲区。
     */
    @Test
    public void test3() {

        long start = System.currentTimeMillis();

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 创建字节输入输出对象
            FileOutputStream fileOutputStream = new FileOutputStream("src/day27/test2.jpg");
            FileInputStream fileInputStream = new FileInputStream("src/day27/test3.jpg"); // 注意文件后缀

            // 创建对应的字节输入输出的缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            // 复制的细节：读取，写入
            // 一边读，一边写入
            byte[] bytes = new byte[1024 * 1024];  // 1MB
            int len = 0;

            while((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 缓冲流会自动刷新
            // bufferedOutputStream.flush();

            // 关闭：缓冲流：会自动关闭内部的节点流的资源
            // 要求：先关闭外层的流(包装流) 再关闭内层的节点流
            // 说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，我们可以省略
            // 看源码

            if(bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if(bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("消耗的时间: " + (end - start));
    }

    /**
     * 使用字符缓冲流读取文件
     */
    @Test
    public void test5() {
        BufferedWriter bufferedWriter = null; // 注意文件后缀
        BufferedReader bufferedReader = null;

        try {
            // 创建对应字符输入/输出缓冲流
            bufferedWriter = new BufferedWriter(new FileWriter("src/day27/hello2.txt"));
            bufferedReader = new BufferedReader(new FileReader("src/day27/hello.txt"));

            // 方式一：使用 char[] 数组是包含了换行符的
            // 一边读，一边写入
            /*char[] chars = new char[1024 * 1024]; // 1MB
            int len = 0;

            while((len = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars,0,len);  // 读多少写入多少
            }*/

            // 方式二：使用String 是不包含换行符的
            // 使用 readLine() 读取的是一行数据内容，当读取到文件末尾返回 null
            String s = null;
            while((s = bufferedReader.readLine()) != null) {
                //bufferedWriter.write(s);  // 注意读取不到换行符
                // 可以自动附加上换行
                // bufferedWriter.write(s + "\n");
                // 方法三：使用 newLine() 提供换行操作
                bufferedWriter.write(s);
                bufferedWriter.newLine();  // 等同于 \n
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭缓冲流：
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bufferedReader != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
