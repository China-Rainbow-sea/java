package day26;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流读取/写入
 * 字符流文件只能处理 文本文件(java.c,c++,txt) word 不是纯文件，word的文本存在格式
 * 注意：如果有文件有后缀的话，路径中需要写明文件的后缀，不然无法读取到文件的。
 */
public class FileReaderTest {
    public static void main1(String[] args) {
        FileReader fileReader = null;
        try {
            // 创建读取文件的输入流
            fileReader = new FileReader("src/day26/FileCopy.java");

            // 开始读取文件内容
            char[] chars = new char[4]; // 一次性读取 4 个字符
            int readCount = 0;
            // fileReader.read()将文件当中的内容读取到 chars[] 字符数组当中，
            // 并返回读取到的字符个数,当
            while((readCount = fileReader.read(chars))  != -1) {
                // 读取到多少个字符转换多少个字符
                String s = new String(chars,0,readCount);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭IO流
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    /**
     * 使用字符输出流，向文件总写入数据
     */
    public static void main2(String[] args) {
        FileWriter fileWriter = null;
        try {
            // 1. 创建输出流,true 从文件末尾写入，不会覆盖
            fileWriter = new FileWriter("src/day26/temp",true);

            // 2. 写入操作
            char[] chars = new char[] {'H','e','l','l','o','上','海'};
            fileWriter.write(chars);

            // 刷新：强制将内存当中的内容全部写入到文件当中
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭IO流资源
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            // 1. 创建输出流,true 从文件末尾写入，不会覆盖
            fileWriter = new FileWriter("src/day26/temp",true);

            // 2. 写入操作
            fileWriter.write("\n");  // 写入换行
            fileWriter.write("我是一名Java软件工程师");
            fileWriter.write("\n");
            fileWriter.write("Hello World");


            // 刷新：强制将内存当中的内容全部写入到文件当中
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭IO流资源
            if(fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
