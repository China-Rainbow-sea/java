package day26;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 数据专属的字节输出流
 */
public class DateOutPutStreamTest {
    public static void main1(String[] args) {
        DataOutputStream dataOutputStream = null;
        try {
            // 创建数据专属的字节输出流
            // 如果文件不存在创建
            dataOutputStream = new DataOutputStream(new FileOutputStream("src/day26/temp3"));

            // 写数据，将 内存当中的数据写入到文件中
            byte b = 100;
            short s = 200;
            int i = 300;
            long l = 400;
            float f = 2.0f;
            double d = 3.14;
            boolean bool = true;
            char c = 'A';

            // 写
            dataOutputStream.writeByte(b);
            dataOutputStream.writeShort(s);
            dataOutputStream.writeInt(i);
            dataOutputStream.writeLong(l);
            dataOutputStream.writeFloat(f);
            dataOutputStream.writeDouble(d);
            dataOutputStream.writeBoolean(bool);
            dataOutputStream.writeChar(c);

            // 刷新
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                // 关闭IO流:只需关闭外层的就可以了，内层的会自动关闭
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取 DataOutPutStreamTest 写入到文件中的类型信息:
     * 注意 : 读的顺序需要和写的顺序一致，才可以正常取出数据。
     */
    public static void main(String[] args) {
        DataInputStream dataInputStream = null; // 注意后缀
        try {
            dataInputStream = new DataInputStream(new FileInputStream("src/day26/temp3"));

            // 读取该文件中的存储类型的数据
            // 注意 : 读的顺序需要和写的顺序一致，才可以正常取出数据。不然获取到的数据是错误的，无意义的。

            byte b = dataInputStream.readByte();
            System.out.println(b);
            short s = dataInputStream.readShort();
            System.out.println(s);
            int i = dataInputStream.readInt();
            System.out.println(i);
            long l = dataInputStream.readLong();
            System.out.println(l);
            float f = dataInputStream.readFloat();
            System.out.println(f);
            double d = dataInputStream.readDouble();
            System.out.println(d);
            boolean bool = dataInputStream.readBoolean();
            System.out.println(bool);
            char c = dataInputStream.readChar();
            System.out.println(c);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 关闭IO流,只需要外层关闭就可以了，自动会将内部节点流关闭
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
