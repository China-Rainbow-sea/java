package day26;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 将文件当中的内容写入到另外一个文件当中
 */
public class FileCopy {

    /**
     * 以字节流的方式将文件的内容写入到另外一个文件当中
     * 拷贝的过程一边读，一边写:
     * 使用以上的字节流的时候，文件类型随意，万能的，什么样的文件都能拷贝。
     */
    public static void main1(String[] args) {
        FileInputStream srcFile = null;
        FileOutputStream decFile = null;
        try {
            // 创建一个输入流 ：读取文件的数据内容到内存当中
            srcFile = new FileInputStream("src/day26/temp");
            // 创建一个输出流：写入到文件当中的对象
            decFile = new FileOutputStream("src/day26/temp2");
            byte[] bytes = new byte[1024];
            int readCout = 0;
            // srcFile.read(bytes) 返回读取到文件信息的字节个数
            while ((readCout = srcFile.read(bytes)) != -1) {  // 将文件当中的数据写入到 byte 数组当中
                // 读取到多少就拷贝到多少到文件当中
                decFile.write(bytes, 0, readCout);
            }

            // 刷新: 将内存当中的内容写入到文件中
            decFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 分开 try,不用一起 try,不然一个出现了异常，后面的就无法关闭了
            // 一起try的时候，其中一个出现异常，可能会影响到另一个流的关闭。
            if (srcFile != null) {
                try {
                    srcFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (decFile != null) {
                try {
                    decFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    /**
     * 使用 字符流拷贝复制文件: 注意字符流只能处理 文本文件(java,c,c++)，不能处理其他的格式的文件
     * word 不是文本文件，word中的字含有格式。
     */
    public static void main(String[] args) {
        FileReader secFile = null; // 注意文件有后缀带上
        FileWriter desFile = null;
        try {
            // 创建读取文件的，输入到文件的字符输入流对象
            secFile = new FileReader("src/day26/FileCopy.java");
            // 创建写入到文件的，输出到文件的字符输出流对象
            desFile = new FileWriter("src/day26/temp2");

            // 一边读一边写
            // 读取文件
            char[] chars = new char[1024];
            int readCout = 0;
            // read(char[]) 将读取到的文件信息存储到该 char[] 数组当中，并返回读取到的字符个数，文件末尾返回-1
            while((readCout = secFile.read(chars)) != -1) {
                // 将内存当中的信息，写入到文件当中
                desFile.write(chars,0,readCout);  // 从数组0开始，读取多少就写入多少
            }

            // 刷新：将内存当中遗留的没有写入到文件当中的数据，强制写入到文件当中
            desFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 分开 try，一起的话: 一个出现了异常，另外一个就无法处理
            /*try {
                secFile.close();
                desFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }*/

            // 方式一: 在 finally 代码块当中处理另外一个异常
            if(secFile != null) {
                try {
                    secFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if(desFile != null) {
                        try {
                            desFile.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
