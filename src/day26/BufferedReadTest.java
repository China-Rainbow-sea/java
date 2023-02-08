package day26;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BufferBread :
 *    带有缓冲区: 字符输入流
 *    使用这个流的时候不需要自定义char数组，或者说不需要自定义byte数组，自带缓冲
 */
public class BufferedReadTest {
    public static void main1(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader("src/day26/temp"); // 注意后缀
            // 当一个流的构造方法中需要一个流的时候，这个被传进来的流叫做：节点流
            //外部负责包装的这个类，叫做: 包装流，还有一个名字叫做: 处理流
            // 像当前这个程序来说: FileReader就是一个节点流，BufferedReader 就是一个包装流
            bufferedReader = new BufferedReader(fileReader);

            // 读一行:
            // readLine() 读取一行数据: 到底文件的末尾返回 null
            /*StringBuilder s = new StringBuilder(" ");
            while(!(s.append(bufferedReader.readLine())).equals("null")) {
                System.out.println(s);
            }*/

            String s = null;

            // readLine() 方法读取一个文本行，但不带换行符
            while( (s = bufferedReader.readLine()) != null) {
                System.out.print(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null) {
                // 关闭流:
                // 对于包装类来说: 只需要关闭最外层流就行，里面的节点就会自动关闭，(可以从源码中看到)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 字节转换流
     * InputStreamReader()  将字节流转换为字符流
     * @param args
     */
    public static void main2(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            /*// 字节流:
            FileInputStream fileInputStream = new FileInputStream("src/day26/temp"); // 注意带后缀
            // 这个构造方法只能传一个字符流，不能传字节流
            // 通过转换流，进行转换 InputStreamReader 继承了 Reader 抽象类
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            // inputStreamRead 就是一节点流，BufferedReader 就是一个包装流
            bufferedReader = new BufferedReader(inputStreamReader);*/
            // 也可以合并
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/day26" +
                    "/temp")));

            String s = null;

            while((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null) {
                // 关闭最外层的，包装流，缓冲流,自动会关闭内部的流
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * BufferedWriter 带有缓冲区的字符输出流
     * @param args
     */
    public static void main(String[] args) {
        BufferedWriter bufferedWriter = null;
        try {
            //bufferedWriter = new BufferedWriter(new FileWriter("src/day26/temp",true));
            // 使用 OutputStreamWriter 将字节输出流 转换为 字节输出流
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/day26/temp",true)));

            // 开始写: 将内存当中的数据写入到文件中
            bufferedWriter.write("\n");  // 换行
            bufferedWriter.write("hello world");
            bufferedWriter.write("\n");
            bufferedWriter.write("你好世界");

            // 刷新 缓冲区会自动刷新
            //  bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedWriter != null) {
                // 关闭最外出的流就可以了，缓冲流会自动关闭内部的流
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
