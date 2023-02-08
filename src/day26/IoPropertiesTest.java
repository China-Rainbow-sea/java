package day26;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * IO + Properties 的联合应用
 * 非常好的一个设计概念:
 *   以后经常改变的数据，可以单独写到一个文件中，
 *   将来只需要修改这个文件的内容，Java代码不需要改动，不需要重新
 *   编译，服务器也不需要重启，就可以拿到动态的信息。
 *
 *   类似于以上机制的这种文件被称为 配置文件
 *     并且当配置文件中的内容格式是：
 *       key1=value
 *       key2=value
 *      的时候，我们把这种配置文件叫做属性配置文件。
 *      Java规范中有要求：属性配置文件建议以 properties 结尾，但这不是必须的。
 *      这种.properties 结尾的文件在Java中被称为：属性配置文件
 *      其中properties 对象是专门存放属性配置文件内容的一个类。在Map 接口下
 */
public class IoPropertiesTest {
    public static void main(String[] args) {
        /*
        Properties 是一个Map集合，key是value都是String类型
        想将 userinfo 文件中的数据加载到Properties 对象当中。
         */

        // 新建一个输入流对象
        FileReader reader = null;
        Properties properties = null;
        try {
            reader = new FileReader("src/day26/userinfo.properties");

            // 新建一个Map集合
            properties = new Properties();

            // 调用Properties 对象的load方法将文件中的数据加载到Map集合中。
            properties.load(reader); // 文件中的数据顺着管道加载到 Map集合中，其中等号 = 左边做key,右边做value
            // 通过key 来获取对于的value
            String username = properties.getProperty("username");
            System.out.println(username);
            String password = properties.getProperty("password");
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
