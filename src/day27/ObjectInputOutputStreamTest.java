package day27;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
 * 使用ObjectOutputStream实现
 * 序列化机制：
 *   对象序列化机制允许把内存中的Java对象转换成平台无关的二进制，从而允许把这种
 *   二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点
 *   当其它程序获取了这种二进制流，就可以恢复成原来的Java对象。
 */
public class ObjectInputOutputStreamTest {

    @Test
    public void test() {
        ObjectOutputStream objectOutputStream = null;
        try {
            // 1.
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/day27/hello3"));
            // 2.
            objectOutputStream.writeObject(new Person("Tom", 999));
            // 刷新
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 反序列化: 将磁盘文件中的对象还原为内存中的一个java对象
     * ObjectOutputStream 和 ObjectInputStream不能序列化 static 和 transient 修饰的成员变量。
     */
    @Test
    public void test2() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("src/day27/hello3"));
            // 读取其中的信息
            Person peron = (Person)objectInputStream.readObject();  // 这里因为我们知道序列化的是什么类型的所以可以强制转换
            System.out.println(peron);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}


/**
 * Person 需要满足如下的要求：方可序列化
 * 1.需要实现接口，Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3. 除了当前Person 类需要实现 Serializable 接口之外，还必须保证其内部所有属性
 *   也必须是可序列化的。(默认情况下，基本数据类型可序列化)
 */
class Person implements Serializable {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}