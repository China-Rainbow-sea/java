package blogs.blog9;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamWriterTest {
    public static void main(String[] args) {
        DataInputStream dataInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/blogs/blog9/hello.txt");
            // 1.创建对应的DataInputStream 对象
            dataInputStream = new DataInputStream(fileInputStream);

            // 2. 读取其中文件的类型信息：注意：write 和 read 的取值顺序一定要匹配
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

            String str = dataInputStream.readLine();
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭IO资源
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main1(String[] args) {
        DataOutputStream dataOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/blogs/blog9/hello.txt");
            // 1.创建对应的 DataOutputStream对象
            dataOutputStream = new DataOutputStream(fileOutputStream);

            byte b = 100;
            short s = 200;
            int i = 300;
            long l = 400;
            float f = 2.0f;
            double d = 3.14;
            boolean bool = true;
            char c = 'A';
            String str = "hello";

            // 2. 写数据，将 内存当中的数据写入到文件中
            dataOutputStream.writeByte(b);
            dataOutputStream.writeShort(s);
            dataOutputStream.writeInt(i);
            dataOutputStream.writeLong(l);
            dataOutputStream.writeFloat(f);
            dataOutputStream.writeDouble(d);
            dataOutputStream.writeBoolean(bool);
            dataOutputStream.writeChar(c);
            dataOutputStream.writeChars(str);
            dataOutputStream.writeChars(str);

            // 3.刷新
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭IO资源
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

