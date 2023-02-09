package day27;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFileTest 的使用
 * 1.RandomAccessFileTest 直接继承于java.lang.Object 类，实现了DataInput 和 DataOutput 接口
 * 2.RandomAccessFileTest 即可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile 作为输出流，写出到的文件如果不存在，则在执行过程中自动创建
 * 如果写出到文件存在，则会对原有文件内容进行覆盖。(默认情况从头覆盖)
 */
public class RandomAccessFileTest {
    @Test
    public void test() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("src/day27/hello.txt", "rw");

            randomAccessFile.seek(3);  // 将指针调到角标为 3 的位置。

            StringBuilder stringBuilder = new StringBuilder((int) new File("src/day27/hello.txt").length());  //
            // 创建其指定容量的StringBuilder ，减少扩容次数
            byte[] bytes = new byte[20];
            int len;

            // 将文件3 光标后面的数据读取出来，存储到 StringBuilder 中
            while((len = randomAccessFile.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes,0,len));  // 读取多少便写入多少
            }

            randomAccessFile.seek(3);  // 将光标移动回到 "前三的位置"
            randomAccessFile.write("csv".getBytes()); // 将字符串转换成 byte

            // 将StringBuilder 中的数据写入到文件中
            randomAccessFile.write(stringBuilder.toString().getBytes());  // 将字符串转换成 byte
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
