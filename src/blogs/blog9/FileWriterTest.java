package blogs.blog9;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter descFile = null;
        FileReader srcFile = null; // 注意文件后缀
        try {
            // 1. 创建hello.txt 文件的字符输入流对象，以及 hello2.txt文件的字符输出流对象
            descFile = new FileWriter("src/blogs/blog9/hello2.txt");
            srcFile = new FileReader("src/blogs/blog9/hello.txt");

            // 2. 一边读，一边写
            int len = 0;
            char[] chars = new char[10];
            // 读取hello.txt的数据信息
            while((len = srcFile.read(chars)) != -1) {
                // 将读取到的内容写入到hello2.txt文件中
                descFile.write(chars,0,len);
            }

            // 3. 刷新:将内存中遗留没有写入到文件中的信息，全部强制写入到文件中去
            descFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭IO资源
            // 分开 try,如果两个一起try的话其中一个出现异常了，后面的一个IO就无法关闭了
            if(srcFile != null) {  // 防止 null引用
                try {
                    srcFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(descFile != null) {  // 防止 null引用
                try {
                    descFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static void main3(String[] args) {
        FileWriter fileWriter = null; // 相对路径
        try {
            // 1. 创建输出流对象: FileWriter,并设置 true 将写入的内容追加到文件的末尾中去
            fileWriter = new FileWriter("src/blogs/blog9/hello2.txt",true);

            // 2. 将内存当中的内容写入到文件中
            fileWriter.write("\n");  // 换行
            fileWriter.write("Hello World");
            // 3. 刷新：将内存中没有输出到文件中的内容，强制全部写入到文件中
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 防止 null 引用
            if(fileWriter != null) {
                // 4. 关闭IO资源
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main2(String[] args) {
        FileWriter fileWriter = null; // 相对路径
        try {
            // 1. 创建输出流对象: FileWriter
            fileWriter = new FileWriter("src/blogs/blog9/hello2.txt");

            // 2. 将内存当中的内容写入到文件中
            fileWriter.write(99);
            fileWriter.write("\n");  // 默认是不会换行的，我们需要写入换行
            char[] chars = new char[]{'A','B','c'};
            fileWriter.write(chars);
            fileWriter.write("\n");
            fileWriter.write(new String("Hello World"));
            fileWriter.write("\n");

            // 3. 刷新：将内存中没有输出到文件中的内容，强制全部写入到文件中
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 防止 null 引用
            if(fileWriter != null) {
                // 4. 关闭IO资源
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void main1(String[] args) {
        File file = new File("E:\\Java\\JavaRebuilt\\src\\blogs\\blog9\\hello.txt"); // 绝对路径
        try {
            FileWriter fileWriter = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter2 = new FileWriter("src/blogs/blog9/hello.txt"); // 相对路径
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter3 = new FileWriter("src/blogs/blog9/hello.txt",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
