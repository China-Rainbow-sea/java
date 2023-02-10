package blogs.blog9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main2(String[] args) {
        FileReader fileReader = null; // 相对路径
        try {
            fileReader = new FileReader("src/blogs/blog9/hello.txt");
            int len = 0;
            char [] chars = new char[4];
            // read(chars) 一次性读取数组长度个字符，返回读取到的字符个数。到达文件末尾返回-1
            while((len = fileReader.read(chars)) != -1) {
                // 将char[] 数组转换为字符串
                // 这里我们 读取到了多少个字符，就将 chars数组中的前多少个转换为字符串
                System.out.println(new String(chars,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fileReader 防止 null引用
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main1(String[] args) {
        File file = new File("E:\\Java\\JavaRebuilt\\src\\blogs\\blog9\\hello.txt");  // 绝对路径
        try {
            FileReader fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader2 = new FileReader("src/blogs/blog9/hello.txt"); // 相对路径
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
