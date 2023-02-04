package day25;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法: 在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
 * // 换句话说：泛型方法所属的类是不是泛型类都没有关系，同样可以定义泛型方法。
 */
public class GenericTest {
    @org.junit.Test
    public void test() {
        Integer[] arr = new Integer[]{1,2,3,4,5,6};
        // 泛型方法在调用时，会根据所传的参数，指明泛型参数的类型，Ctrl + p 查看方法参数类型
        List<Integer> list = new MyClass().copyFromArrayToList(arr);
        list.forEach(System.out::println);
    }

    @Test
    public void test2() {
        String[] arr = new String[]{"h","e","l","l","o"};
        // 调用静态泛型方法,在调用泛型方法时，确定该泛型方法中泛型的具体类型
        List<String> list = MyClass.copyFromArrayToList2(arr);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

class MyClass {

    int num;

    /**
     * 将数组转换为 ArrayList 集合存储
     * @param arr
     * @param <E>
     * @return
     */
    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> arrayList = new ArrayList<E>();

        for(E e :arr) {
            arrayList.add(e);
        }

        return arrayList;
    }


    // 泛型方法中只要不存在类中定义的泛型，可以设置为静态的
    // 因为静态泛型方法，是在调用的时候才确定的。并非在实例化类后确定的
    public static <E> List<E> copyFromArrayToList2(E[] arr) {
        ArrayList<E> arrayList = new ArrayList<E>();

        for(E e :arr) {
            arrayList.add(e);
        }

        return arrayList;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "num=" + num +
                '}';
    }
}