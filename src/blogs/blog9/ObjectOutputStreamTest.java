package blogs.blog9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectOutputStreamTest {
    public static void main(String[] args) {
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/blogs/blog9/temp");

            // 1.创建 ObjectInputStream 反序列化输入流对象，构造器参数是 InputStream
            objectInputStream = new ObjectInputStream(fileInputStream);

            // 2. 读取存储序列信息的文件到内存当中
            // 因为这里我们知道该文件中存储的是 List<Person> 集合类型的所以可以直接强制转化
            List<Person> list = (List<Person>)objectInputStream.readObject();

            // 遍历集合
            for (Person person : list) {
                System.out.println(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭IO资源
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main3(String[] args) {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/blogs/blog9/temp");

            // 1. 创建 ObjectOutputStream 序列化输出流: 注意构造器的参数是 OutputStream
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // 2. 创建多个 Person 对象类型，存储到 List 集合中
            Person person1 = new Person("Tom",18,001);
            Person person2 = new Person("zhangsan",28,002);
            Person person3 = new Person("lisi",20,003);

            // <Person>泛型限定存储对象类型
            List<Person> list = new ArrayList<Person>();
            // 添加元素
            list.add(person1);
            list.add(person2);
            list.add(person3);

            // 3. 序列化:将存储到 List集合中的元素，写入到 temp 硬盘文件中
            objectOutputStream.writeObject(list);

            // 4. 刷新:将遗留在内存中没有写入到文件的信息，强制全部写入到文件中，防止数据丢失
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭IO资源
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main2(String[] args) {
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/blogs/blog9/temp"); // 注意文件后缀

            // 1. 创建反序列化输入对象
            // 注意: 这里的参数是: InputSteam ，而FileInputStream 实现了该接口
            objectInputStream = new ObjectInputStream(fileInputStream);

            // 2.读取其中序列化对象信息
            // Object object = objectInputStream.readObject();
            // 这里因为我们知道该文件中序列化的对象是 Person类型的，所以可以直接进行强制转化
            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭IO资源
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    public static void main1(String[] args) {

        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/blogs/blog9/temp");
            // 1. 创建 ObjectOutputStream 序列化输出流对象
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

             Person person = new Person("Tom", 99,001);

             //2. 将自定义的Person 对象序列化:存储到硬盘文件当中去.
            objectOutputStream.writeObject(person);

            // 3. 刷新
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4 关闭IO资源
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


// 该自定义类实现 java.io.Serializable 接口
class Person implements Serializable {
    String name;
    transient int age;

    // 多加一个属性
    int id;

    // 显式定义了 serialVersionUID 的版本号值
    private static final long serialVersionUID = 1L;


    public Person() {

    }


     public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }


}


