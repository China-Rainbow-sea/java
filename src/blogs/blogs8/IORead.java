package blogs.blogs8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class IORead {


    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String user = resourceBundle.getString("user");
        System.out.println(user);
        String password = resourceBundle.getString("password");
        System.out.println(password);
    }


    /**
     * 直接返回字节输入流接口
     * @param args
     */
    public static void main3(String[] args) {
        // 直接在 src目录下没有包含任何子目录，可以直接写文件名+ 后缀，而如果有子目录，需要指明子目录下的文件名+后缀名
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");

        // 创建 Properties 集合对象，通过流获取指定配置文件中的键值对信息
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String user = properties.getProperty("user");
        System.out.println(user);
        String password = properties.getProperty("password");
        System.out.println(password);

        // 关闭IO资源
        if (inputStream != null) {

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    /**
     * 获取文件的绝对路径的方式
     *
     * @param args
     */
    public static void main2(String[] args) {
        FileInputStream f = null;
        try {
            // 获取到该配置文件的的绝对路径
            String path = Thread.currentThread().getContextClassLoader().getResource("blogs/blogs8/jdbc.properties").getPath();
            //  通过该获取的文件的绝对路径创建 字节输入流对象
            f = new FileInputStream(path);

            // 创建Map集合中的 Properties 对象
            Properties properties = new Properties();
            properties.load(f);

            // 通过 key 读取对应的键值对
            String user = properties.getProperty("user");
            System.out.println(user);
            String password = properties.getProperty("password");
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭IO资源
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main1(String[] args) {
        FileInputStream f = null;
        try {
            // 创建字节输入流对象
            // 在IDEA 中的默认相对路径是在 src 同级目录下的
            f = new FileInputStream("src/blogs/blogs8/jdbc.properties");

            // 创建Map集合中的 Properties 对象
            Properties properties = new Properties();
            properties.load(f);

            // 通过 key 读取对应的键值对
            String user = properties.getProperty("user");
            System.out.println(user);
            String password = properties.getProperty("password");
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭IO资源
            if (f == null) {
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


