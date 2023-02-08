package day26;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main1(String[] args) {
        File file = new File("src/day26/temp1");
        System.out.println(file.exists());  // 判断带路径下的temp文件是否存在，存在返回 true

        if (!file.exists()) {  // 判断该路径下的文件(带后缀)，或者目录是否存在。
            /*// 如果文件不存在，则以文件的形式创建出来。
            try {

                file.createNewFile();  // 创建一个新文件

            } catch (IOException e) {
                e.printStackTrace();
            }*/

            // 如果文件不存在/目录不存在，创建目录
            if (!file.exists()) {
                file.mkdir();  // 创建单个目录
            }
        }
    }


    /**
     * 创建多重目录吗
     *
     * @param args
     */
    public static void main2(String[] args) {
        File file = new File("src/day26/a/b");

        System.out.println(file.exists());
        if (!file.exists()) {
            // 创建多重的形式新建
            file.mkdirs();
        }

    }

    /**
     * 获取文件的路径
     * @param args
     */
    public static void main3(String[] args) {
        File file = new File("src/day26/temp");  // 注意后缀名
        // 获取文件的父路径
        String parent = file.getParent();
        System.out.println(parent);
        // 获取该文件的绝对路径
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(file.getAbsoluteFile());
        // 获取文件名
        System.out.println("获取文件名：" + file.getName());

        // 判断是否是一个目录
        System.out.println(file.isDirectory());

        // 判断是否是一个文件
        System.out.println(file.isFile());

        // 获取文件最后一次修改时间
        long haoMiao = file.lastModified(); // 这个是毫秒值从1970年到现在的毫秒数
        // 将毫秒数转换成日期？？？
        Date time = new Date(haoMiao);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String format = sdf.format(time);
        System.out.println(format);

        // 获取文件的大小
        System.out.println(file.length());  // 单位字节
    }


    /**
     * File中的ListFiles 方法
     * @param args
     */
    public static void main(String[] args) {
        // File[] listFies()
        // 获取当前目录下所有的文件
        File f = new File("src/day26");

        File[] files = f.listFiles();

        for (File file : files) {
            //System.out.println(file.getAbsolutePath());  // 获取到该文件的绝对路径
            System.out.println(file.getName());  // 获取到该文件的文件名
        }
    }

}
