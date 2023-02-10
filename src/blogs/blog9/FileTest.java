package blogs.blog9;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("src/blogs/blog9/test");
        boolean b = file.delete();  // test 目录下不能有文件/目录，有的话无法删除
        System.out.println(b);
    }


    public static void main7(String[] args) {
        File file = new File("src/blogs/blog9/test/test2/");
        boolean b = file.mkdirs();  // 如果对应的 test2目录的上级目录test不存在，则目录一并都创建
        System.out.println(b);
    }


    public static void main6(String[] args) {
        File file = new File("src/blogs/blog9/hello.txt");

        boolean b = false;
        try {
            b = file.createNewFile();  // 文件存在不创建，不存在文件创建
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }


    /**
     * renameTo() 文件的剪切并重命名
     * @param args
     */
    public static void main5(String[] args) {
        File file = new File("src\\blogs\\blog9\\hello.txt");
        File dest = new File("E:\\临时文件\\temp\\test.txt");
        boolean b = file.renameTo(dest);  // 将file文件剪切到 dest 中并重命名
        System.out.println(b);

    }


    public static void main4(String[] args) {
        File file = new File("src\\blogs\\blog9\\hello.txt"); // 注意转义以及文件后缀(该文件实际存在的)
        File file2 = new File("src/blogs/blog9/hello3.txt"); // 左斜杆也是可以的 (该文件不存在的)

        System.out.println(file.isDirectory()); // 判断是否是文件目录
        System.out.println(file.isFile());  // 判断是否为文件
        System.out.println(file.exists()); // 判断该文件/目录是否实际存在
        System.out.println(file.canRead());  // 判断该我呢见是否可读的
        System.out.println(file.canWrite()); // 判断该文件是否是可写的
        System.out.println(file.isHidden()); // 判断该文件是否隐藏的

        System.out.println("*************************** file2 *************************");
        System.out.println(file2.isDirectory()); // 判断是否是文件目录
        System.out.println(file2.isFile());  // 判断是否为文件
        System.out.println(file2.exists()); // 判断该文件/目录是否实际存在
        System.out.println(file2.canRead());  // 判断该我呢见是否可读的
        System.out.println(file2.canWrite()); // 判断该文件是否是可写的
        System.out.println(file2.isHidden()); // 判断该文件是否隐藏的
    }


    /**
     * File 文件目录
     */
    public static void main3(String[] args) {
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
