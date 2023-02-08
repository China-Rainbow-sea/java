package day26;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 序列化：
 * 参与序列化和反序列化的对象，必须实现Serializable 接口
 * 3 注意: 通过源代码发现: Serializable 接口只是一个标志接口
 *   public interface Serializable {
 * }
 *
 * 这个接口当中什么代码都没有。
 * 那么它起到一个什么作用呢
 *   起到一个标识作用，标志的作用：Java虚拟机看到这个类实现了这个接口，可能会对这个类进行特殊处理。
 *   Serializable 这个标志接口是给java虚拟机参考的，Java虚拟即看到这个接口之后，会为该类自动生成一个
 *   序列化版本号：
 *
 *   4. 序列化版本号有什么用呢？
 *     java.io.InvalidClassException:
 *     com.bjpwernode.java.bean.Stident
 *     local class incompatible;
 *     private static final long serialVersionUID = -456;  // 十年后
 *     private static final long serialVersionUID = -123;  // 十年前的
 *
 *     小鹏编写了一个类：com.bjpowrnode.java.bean.Student implements serializable
 *     胡浪编写了一个类: com.bjpowrnode.java.bean.Student implements serializable
 *     不同的人编写了同一个类，但 “这两个类确实不是同一个类，”这个时候序列化版本就起上作用了。
 *     对于Java虚拟机来说，Java虚拟机是可以区分开这两个类的，因为这两个类都实现了Serializable接口
 *     都有默认的序列化版本号，他们的序列化版本号不一样，所以区分开了。
 *
 *     请思考：
 *       这种自动生成序列化号有什么用
 *       这种自动生成是序列化版本号：一旦代码确定之后：不能进行后续的修改。
 *       因为只要修改，必然会重新编译，此时会生成全新的序列化版本号，这个时候java虚拟机会认为一个
 *       全新的类，（这样就不好了）
 *
 *     最终结论：
 *       凡是一个类实现了Serializable 接口，建议该类提供了一个固定不变的序列化版本号:
 *       这样，以后这个类即使代码修改了，但是版本号不变，Java虚拟机会认为是同一个类。
 *
 */
public class ObjectOutputStreamTest {
    public static void main1(String[] args) {
        // 创建Java对象
        Student student = new Student("Tom",123);
        ObjectOutputStream objectOutputStream = null;  //

        try {
            // 序列化:  // 注意文件后缀
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/day26/temp"));
            // 序列化对象:
            objectOutputStream.writeObject(student);

            // 刷新
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 反序列化：从硬盘中读取到该对象的类型数据
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("src/day26/temp"));
            // 开始反序列化：读
           //  Object object = ois.readObject();
           // System.out.println(object);

            Student student =(Student) ois.readObject();  // 因为我们知道该存储的类型是什么所有可以直接强制转换
            System.out.println(student);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 一次性序列化多个对象
     *  可以，可以将对象放到集合当中，序列化集合
     */
    public static void main3(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("Tom",999));
        list.add(new Student("lihua",888));
        list.add(new Student("zhangsan",777));
        ObjectOutputStream objectOutputStream = null;  //

        try {
            // 注意后缀文件
            objectOutputStream = new ObjectOutputStream( new FileOutputStream("src/day26/temp"));

            // 序列化一个集合，这个集合对象中放了很多其他对象
            objectOutputStream.writeObject(list);

            // 刷新
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 读取文件中的多个序列化对象
     */
    public static void main5(String[] args) {
        ObjectInputStream objectInputStream = null;  // 注意后缀
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("src/day26/temp"));

            List<Student> list = (List<Student>)objectInputStream.readObject();

            for (Student student : list) {
                System.out.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}


/**
 * java.io.NotSerializableException: day26.Student Student 对象不支持序列化:
 * 想要实现序列化的对象：必须实现 Serializable 接口，其中的任何 一般都是自定义的类
 *
 * 当过了很久，Student 这个类源代码改动了。
 * // 源代码改动之后，需要重新编译，编译之后生成了全新的字节码文件
 * 并且class文件再次运行的时候，Java虚拟机生成的序列化版本号也会发生相应的改变。
 */
class Student implements Serializable {

    // Java虚拟机看到Serializable接口之后，会自动生成一个序列化版本号：
    // 这里没有手动写出来，Java虚拟机会默认提供这个序列化版本号；
    // 建议将序列化版本号手动的写出来，不建议自动生成。
    private static final long serialVersionUID = 1L; // Java虚拟机识别一个类的时候先通过类名，如果类名一致。再比较判断序列化号是否一致。

    // transient 关键字表示游离的，不参与序列化。
    transient String name;  // name 不参与序列化操作
    int age;
    static int no;  // static 静态是无法序列化的，因为static的是归类管的，不归对象管。
    // 序列化的是对象，不是类。
    int id;




    public Student() {
    }

    public Student(String name, int age) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}