package day27;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转换流：
 *  1.转换流属于字符流
 *   InputStreamReader: 将一个字节的输入流转换为字符的输入流
 *   OutputStreamWriter:
 *  2. 作用：提供字节流与字符流之间的转换。
 */
public class InputStreamReaderTest {

    @Test
    public void test() {
        InputStreamReader inputStreamReader = null;  // 使用系统默认的字符集
        InputStreamReader inputStreamReader2 = null;  // 使用系统默认的字符集
        try {
            FileInputStream fis = new FileInputStream("src/day27/hello.txt");
            inputStreamReader = new InputStreamReader(fis);
            //参数2指明了字符集，具体使用哪个字符集，取决于文件的hello.txt保存时使用的字符集
            inputStreamReader2 = new InputStreamReader(fis,"gbk"); // 使用系统默认的utf-8字符集
            inputStreamReader2 = new InputStreamReader(fis,"UTF-8"); // 使用系统默认的utf-8字符集

            char[] cbuf = new char[20];
            int len;

            while((len = inputStreamReader2.read(cbuf)) != -1) {
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStreamReader2 != null) {
                try {
                    inputStreamReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
