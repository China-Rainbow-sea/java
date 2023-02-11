package blogs.blog9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamWriterTest {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("src/blogs/blog9/hello.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 将 FileOutputStream 字节输出流转换为 OutputStreamWriter 字符输出流
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

    }


    public static void main1(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/blogs/blog9/hello.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 将 FileInputStream 字节输入流转换为 InputStreamReader 字符输入流
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
    }
}
