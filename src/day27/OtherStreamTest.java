package day27;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * System.in: 标准输入流，默认从键盘输入
 * System.out: 标准的输出流，默认从控制台输出
 * 1.2
 * System类的Setin(InputSteam is) / setOut(PrintStream ps) 方式重新指定输入和输出的位置
 *
 * 1.5 练习:
 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作。
 * 直至当输入 "e" 或者 "exit" 时，退出程序，
 *
 * 方法一: 使用Scanner 实现，调用next()返回一个字符串
 * 方法二：使用System.in 实现，System.in ---> 转换流 ---> BufferedReader 的readLine
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        // System.in 就是 public final static InputStream in = null;
        InputStreamReader isr = new InputStreamReader(System.in);  // System.in 控制台
        BufferedReader bufferedReader = new BufferedReader(isr);

        while(true) {
            String data = null;
            try {
                data = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                System.out.println("程序结束");
                break;
            }

            String upperCase = data.toUpperCase();
            System.out.println(upperCase);
        }

        if(bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
