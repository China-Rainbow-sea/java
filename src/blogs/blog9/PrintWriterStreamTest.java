package blogs.blog9;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrintWriterStreamTest {
    public static void main(String[] args) {
        // System.in 就是 public final static InputStream in = null;
        InputStreamReader isr = new InputStreamReader(System.in);  // System.in 控制台
        // 转换为该字符输出流，可以读取一行的信息
        BufferedReader bufferedReader = new BufferedReader(isr);

        while(true) {
            String data = null;
            try {
                data = bufferedReader.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }

                // 将字符转换为大写字符
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if(bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main2(String[] args) {
        log("调用了System类的gc()方法，建议启动垃圾回收");
        log("调用了UserService的doSome()方法");
        log("用户尝试进行登录，验证失败");

    }

    public static void log(String msg) {
        // 1. 创建一个输出的字节的文件对象，用于 System的重定向
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new FileOutputStream("src/blogs/blog9/log.txt",true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 2.改变 System.out()的输出方向使用:SetOut()方法改为重定向到 printSteam的文件中
        System.setOut(printStream);

        // 3. 设置输入的日期时间
        Date date = new Date();  // 获取当前系统的时间(毫秒值)时间戳
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS");
        // 将 Date 转换为规定格式的字符串
        String strTime = simpleDateFormat.format(date);
        System.out.println(strTime +": " + msg);

        // 4. 关闭IO资源
        System.out.close();
    }
}
