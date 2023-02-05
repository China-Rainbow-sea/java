package blogs.blog8;

import java.util.ArrayList;

public class GenericTest {
    // 使用上泛型
    public static void main(String[] args) {
        // 泛型限定了存储类型，泛型指定定义引用类型，基本数据类型不行
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // 使用了泛型: 就会进行类型检查，保证数据的安全
        arrayList.add(99);  // 包装类，自动装箱
        arrayList.add(78);
        arrayList.add(76);
        arrayList.add(89);
        arrayList.add(88);

        // arrayList.add("Tom"); // 存储不符合泛型的数据，编译无法通过。
        for (Integer integer : arrayList) {
            int stuScore = integer;  // 不需要强制转换自动拆箱

            System.out.println(stuScore);
        }
    }



    // 没有使用泛型
    public static void main1(String[] args) {
        // 定义了泛型没有使用的话，默认是 Object 类型存储
        ArrayList arrayList = new ArrayList();

        // 添加成绩
        arrayList.add(99);
        arrayList.add(89);
        arrayList.add(79);

        // 问题一:存储的类型不安全
        // 不小心添加了一个学生的姓名
        arrayList.add("Tom");

        for (Object o : arrayList) {
            // 问题二: 强转时，可能出现ClassCastException 异常
            int stuScore = (Integer)o;  // 因为你存储的类型可能与强制转换的类型，没有继承关键，实例关系
            // 导致转换失败.
            System.out.println(stuScore);
        }
    }
}
