package day25;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 泛型的使用
 * 1.jdk5 新增的特性
 * 2. 集合接口或集合类在jdk5.0 时都修改为带泛型的结构。
 * 3. 在实例化集合类时，可以指明具体的泛型类型。
 * 4. 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构(比如：方法，构造器，属性)
 * 注意点: 泛型的类型必须时类，不能是基本数据类型，需要用到基本数据类型的位置，na
 * 如果实例化时，没有指明泛型的类型，默认类型为java.lang.Object 类型
 */
public class GenericityTest {
    @Test
    public void test() {
        ArrayList  arrayList = new ArrayList();
        // 需求：存放学生的成绩
        arrayList.add(78);
        arrayList.add(76);
        arrayList.add(89);
        arrayList.add(88);

        // 问题一: 类型不安全
        arrayList.add("Tom");  // 成绩却可能被存储到字符串，

        for (Object o : arrayList) {
            // 问题二: 强转时，可能出现ClassCastException 异常
            int stuScore = (Integer)o;  // 因为你存储的类型可能与强制转换的类型，没有继承关键，实例关系
            // 导致转换失败.
            System.out.println(stuScore);
        }
    }


    // 在集合中使用泛型的情况
    @Test
    public void test2() {
        // 泛型限定了存储类型，泛型指定定义引用类型，基本数据类型不行
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        // 使用了泛型: 就会进行类型检查，保证数据的安全
        // list.add("Tom"); // 存储不符合泛型的数据，编译无法通过。
        arrayList.add(99);
        arrayList.add(78);
        arrayList.add(76);
        arrayList.add(89);
        arrayList.add(88);

        arrayList.forEach(System.out::println);


    }

    // 在集合中使用泛型的情况: HashMap
    @Test
    public void test3() {
        // 泛型只能定义引用类型，不能定义基本数据类型
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("Tom",99);
        hashMap.put("zhangsan",90);
        hashMap.put("lihua",99);

        //hashMap.put(99,0); // 类型与限定的泛型不一致，编译无法通过

        // Map.Entry<String,Integer> 泛型的嵌套
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + next.getValue());
        }
    }


    @Test
    public void test4() {
        Employee employee = new Employee();
        System.out.println(employee.compareTo(new Employee()));
    }
}



class Employee implements Comparable<Employee>{
    String name;
    int age;



    // 泛型排序
    @Override
    public int compareTo(Employee o) {
        //return ((Integer)o.age).compareTo(o.age);
        return  new Integer(o.age).compareTo(o.age);
    }
}