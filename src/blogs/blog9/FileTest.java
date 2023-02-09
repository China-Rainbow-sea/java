package blogs.blog9;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

    /**
     * File 文件目录
     */
    public static void main(String[] args) {
        File file = new File("src/blogs/blog9"); // 也可以使用 左斜杆
        String[] list = file.list();  // 返回获取指定目录下的所有文件或者文件目录的名称数组
        for (String s : list) {
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for(File f : files) {
            System.out.println(f);
        }
    }


    /**
     * File 构造器的使用
     */
    public static void main1(String[] args) {
        // 构造器一:
        // 绝对路径: 带盘符
        File file = new File("E:\\Java\\JavaRebuilt\\src\\blogs\\blog9"); // 双右斜杆表示一个 \ (转义)
        // 相对路径: IDEA默认是Project的根目录，不是模块Module的根目录，
        // 也可以使用：左斜杆表示路径分隔符
        System.out.println(file);
        File file2 = new File("src/blogs/blog9"); // 这里是在src的包下(src 和 Module 模块是同级的)
        System.out.println(file2);

        // 构造器二:
        // 第一个参数是第二个参数的父路径，第二个参数是子路径
        File file3 = new File("E:\\Java\\JavaRebuilt\\src\\blogs","blog9");
        System.out.println(file3);

        // 构造器三:
        // 第一个参数是 File 类对象(这里是第二个参数的父路径的File对象)，第二个参数是子路径
        File file4 = new File(file3,"blog9");
        System.out.println(file4);

    }


    /**
     * File 获取文件属性的功能
     */
    public static void main2(String[] args) {
        File file = new File("src\\blog9\\hello.txt"); // 注意转义以及文件后缀
        File file2 = new File("src/blog9/hello3.txt"); // 左斜杆也是可以的

        String absolutePath = file.getAbsolutePath();  // 返回绝对路径,以String的形式返回
        System.out.println(absolutePath);
        File absoluteFile = file.getAbsoluteFile();  // 返回绝对路径,以File 对象的形式返回
        System.out.println();
        System.out.println(file.getPath());  // 返回此路径名/目录名
        System.out.println(file.getName()); // 返回该文件名/目录名
        System.out.println(file.getParent()); // 返回该上层文件/目录名称
        System.out.println(file.length());  // 返回文件长度即文件的大小(字节)
        long l = file.lastModified();  // 返回该文件的最后一次修改的时间值(毫秒值)时间戳
        // 将时间戳转换为Date，再转换为 指定格式的字符串
        Date date = new Date(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm SSS");
        String format = simpleDateFormat.format(date);
        System.out.println(format);

    }


}
