package day27;


import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * 流的分类:
 * 1.操作数据单位：字节流，字符流
 * 2. 数据的流向：输入流，输出流，
 * 3. 流的角色，节点流，处理流。
 *
 * 二流的体系结构：
 * 抽象基类：             节点流(文件流)        缓冲流(处理流的一种)
 * InputStream        FileInputStream         BufferedInputStream
 * OutputStream       FileOutPutStream        BufferedOutStream
 * Reader             FileReader              BufferedReader
 * Writer             FileWriter              BufferedWriter
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        // main 中相对路径在IDEA中默认是项目的根目录
        File file = new File("src/day26/hello.txt");
        System.out.println(file.getAbsolutePath());  // 获取该文件的绝对路径
    }


    /**
     * read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
     * 异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
     * 读入的文件一定要存在，否则就会报FileNOtFoundExceptin
     *
     */
    @Test
    public void test()  {
        // Test 测试类中，默认的相对路径是在 当前的module 下的
        // 1. 实例化File类的对象，指明要操作的文件
        File file = new File("src/day27/hello.txt");   // 相较于当前的 Module
        FileReader fileReader = null;

        try {
            // 2.提供具体的流: 字符输入流
            fileReader = new FileReader(file);

            // 3.将文件中的数据读取到内存当中
            int date = 0;

            // read() 返回读入的一个字符，如果达到文件的末尾，返回 -1；
            while((date = fileReader.read()) != -1) {  // 文件的末尾返回 -1
                System.out.println((char)date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        // 4. 关闭IO
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 对read()操作升级，使用read()的重载方法
     */
    @Test
    public void test2() {
        // 1. File 文件类
        File file = new File("src/day27/hello.txt");  // 注意文件后缀
        FileReader fileReader = null;

        try {
            // 2. 创建字符输入流
            fileReader = new FileReader(file);

            // 3. 读取文件的内容到内存当中
            char[] chars = new char[5];
            int len;
            // read(char[] chars) 返回每次读入到char数组中的字符个数，如果达到文件末尾，返回 -1
            // 并将读取到的内容存储到 chars数组中
            while((len = fileReader.read(chars)) != -1) {
                //System.out.println(Arrays.toString(chars));
                // 转换为字符串输出
                String s = new String(chars,0,len);  // 读取到多少就输出多少
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 从内存中写出数据到硬盘的文件里
     * 1.输出操作，对应的File 可以不存在的，
     *   如果不存在，在输出的过程中，会自动创建此文件。
     * 2. File对应的硬盘的文件如果存在：
     *       如果流的使用的构造器是：FileWriter(file,false) / FileWriter(file): 对原有的数据进行覆盖
     *       如果流使用的构造器是：FileWriter(file,true) : 不会对原有文件覆盖，而是在原有的基础上追加
     */
    @Test
    public void test3() {
        // 1. 提供文件
        File file = new File("src/day27/hello.txt"); // 注意后缀
        FileWriter fileWriter = null;

        try {
            // 2. 创建字符输出流
            fileWriter = new FileWriter(file,true);

            // 3. 写出的操作
            fileWriter.write("I have a dream!");
            fileWriter.write("\n");  // 写入一个换行
            fileWriter.write("you need to have a dream!");

            // 4. 刷新: 将没有内存中没有全部写入到文件中的数据，全部强制写入
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        // 5. 流资源的关闭
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
