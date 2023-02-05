package blogs.blog8;

import java.util.ArrayList;
import java.util.List;

public class GenericTest6 {
    public static void main(String[] args) {
        List<?> list = new ArrayList<>();
    }

    public static void main5(String[] args) {
        List<?> list3 = null;
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // 将 List<Integer> 引用赋值给 List<?>
        list3 = list2;

        // 向 List<?> 添加数据
        //list3.add(99);
    }

    public static void main4(String[] args) {
        List<?> list3 = null;
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        // 将 List<String> 引用赋值给 List<?>
        list3 = list;
        // 获取值
        Object o = list3.get(0);
        System.out.println(o);
        Object o2 = list3.get(1);
        System.out.println(o2);

        System.out.println("*******************************");

        List<Integer> list2 = new ArrayList<>();
        list2.add(99);
        list2.add(999);

        // 将 List<Integer> 引用赋值给 List<?>
        list3 = list2;
        // 获取值
        Object o3 = list3.get(0);
        System.out.println(o3);
        Object o4 = list3.get(1);
        System.out.println(o4);


    }

    public static void main3(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        fun(arrayList);  // <String>
        fun(arrayList2); // <Integer>
    }

    public static void fun(List<?> list) {

    }


    public static void fun1(List<String> list) {

    }

    public static void fun2(List<Integer> list) {

    }


    public static void main1(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList = arrayList2;


    }


    public static void main2(String[] args) {
        Object obj = null;
        String str = null;
        obj = str;

    }


}

