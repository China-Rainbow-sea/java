package day24;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 定义一个Employee列
 *该类包含: private成员遍历name,age,birthday 其中birthday 为myDate 类的对象
 * 并为每一个属性定义 getter,setter 方法:
 * 并重写toString 方法输出 name,age,birthday
 */
public class Exercise {

    // 问题一: 使用自然排序
    @Test
    public void test() throws ParseException {
        // TreeSet 存储的对象必须是一致的。
        TreeSet set = new TreeSet();
        Employee e1 = new Employee("liudehua",55,new SimpleDateFormat("YYYY-MM-dd").parse("1990-05-23"));
        Employee e2 = new Employee("zhangxueyou",55,new SimpleDateFormat("YYYY-MM-dd").parse("1987-05-4"));
        Employee e3 = new Employee("guofucheng",55,new SimpleDateFormat("YYYY-MM-dd").parse("1954-8-12"));
        Employee e4 = new Employee("liming",55,new SimpleDateFormat("YYYY-MM-dd").parse("1978-12-4"));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);

        for (Object o : set) {
            System.out.println(o);
        }
    }


    // 问题二: 按生日日期先后排序
    @Test
    public void test2() throws ParseException {
        // TreeSet 存储的对象必须是一致的。
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof  Employee) {
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;

                    Date date1 = e1.getBirthday();
                    Date date2 = e2.getBirthday();

                    // 比较年
                    return date1.compareTo(date2);
                }

                throw new RuntimeException("类型不一致"); // 手动抛出运行异常
            }
        });
        Employee e1 = new Employee("liudehua",55,new SimpleDateFormat("YYYY-MM-dd").parse("1990-05-23"));
        Employee e2 = new Employee("zhangxueyou",55,new SimpleDateFormat("YYYY-MM-dd").parse("1987-05-4"));
        Employee e3 = new Employee("guofucheng",55,new SimpleDateFormat("YYYY-MM-dd").parse("1954-8-12"));
        Employee e4 = new Employee("liming",55,new SimpleDateFormat("YYYY-MM-dd").parse("1978-12-4"));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }


    /**
     * 在List内去除重复数字值，要求尽量简单
     */
    @Test
    public void test3() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(3));

        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("***********************");
        // 去重复
        HashSet set = new HashSet();  // 创建 hashSet 对象不可重复
        set.addAll(list);  // 添加集合元素,将 list 集合中的数据添加到HashSet集合中，不可重复添加相同的数据

        List list2 = new ArrayList(set);  // 再将已经去除重复的数据，创建一个新的List 对象
        for (Object o : list2) {
            System.out.println(o);
        }
    }


    @Test
    public void test6() {
        HashSet set = new HashSet();
        Person p1 = new Person("AA",1001);
        Person p2 = new Person("BB",1002);

        set.add(p1);
        set.add(p2);
        System.out.println(set);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);

        set.add(new Person("CC",1001));
        System.out.println(set);

        set.add(new Person("AA",1001));
        System.out.println(set);

    }
}

class Employee implements Comparable{
    private String name;
    private int age;
    private Date birthday;

    public Employee() {

    }

    public Employee(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee) {
            Employee e = (Employee)o;
            return this.name.compareTo(e.getName());
        }

        throw new RuntimeException("类型不一致");
    }
}
