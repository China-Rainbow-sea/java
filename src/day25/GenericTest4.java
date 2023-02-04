package day25;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 泛型的继承方面的体现:
 * 虽然类A(Object) 是 类A(String) 的父类，但是G<A>(List<Object>)  和 G<B>(List<String>)二者不具备父类关系，二者是并列关系。
 *
 */
public class GenericTest4 {

    @Test
    public void test() {
        Object obj = null;
        String str = null;
        obj = str;  // 没有使用泛型可以转换，Object 是 String 父类

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
    }

    @Test
    public void test2() {
        List<Object> list1 = null;
        List<String> list2 = null;
        // 此时存储泛型的 List1 和 List2 的类型不具有父类关系。
        // list1 = list2;  // 无法转换
        // 相等于如下的情况
        Date date = null;
        String str = null;
       //  date = str; 两者之间并没有多态的实例化关系，也不是继承关系，是并列的关系
    }

    @Test
    public void test3() {
        List<String> list1 = null;
        ArrayList<String> list2 = null;
        List<String> list3 = null;
        list1 = list2;
        list1 = list3;

        List<String> list4 = new ArrayList<String>();

    }


    /**
     * 通配符的使用 ?
     * 通配符 ？
     * 类A(Object) 是类B(String)的父类，G<A>(List<Object>) 和G<B>(List<String>) 是没有关系的，二者共同的父类是 G<?></?>
     */
    @Test
    public void test4() {
        List<Object> list1 = null;
        List<String> list2 = null;

        // ? 通配符的使用
        List<?> list = null;
        list = list1;
        list = list2;
    }

    public void show1(List<String> list) {

    }
    public void show2(List<Object> list) {

    }

    @Test
    public void test5() {
        List<?> list = null;
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("AA");
        list2.add("BB");
        list2.add("CC");
        list = list2;

        this.Print(list);

        // 添加(写入): 通配符list<?> 添加转换后的元素数据，
        // 对于List<?> 就转换后就不能其内部添加数据了
        // 除了添加 null 之外。
       // list.add("DD"); 无法添加数据，编译报错
        list.add(null);  // 但是可以添加 null
        System.out.println("*****************");
        // 读取(): 允许读取数据，读取的数据类型为Object 类型
        Object o = list.get(1);
        System.out.println(o);


    }

    // 通配符泛型参数
    public void Print(List<?> list) {
        Iterator<?> iterator = list.iterator();

        while(iterator.hasNext()) {
            Object o = iterator.next();  // 通配符默认返回 Object
            System.out.println(o);
        }
    }

}
