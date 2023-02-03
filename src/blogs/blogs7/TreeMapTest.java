package blogs.blogs7;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        // 创建一个 TreeMap 集合对象，将匿名实现的比较器(定制排序)，作为参数，传递给构造器
        TreeMap<Person6,Integer> treeMap = new TreeMap<Person6,Integer>(new Comparator<Person6>() {
            @Override
            public int compare(Person6 o1, Person6 o2) {
                // 判断是否是对应比较的实例，其实这里我们可以不用判断的，因为使用的泛型限定
                if(o1 instanceof Person6 && o2 instanceof  Person6) {
                    Person6 p1 = (Person6)o1;
                    Person6 p2 = (Person6)o2;  // 向下转型为对应的实例对象，从而获取比较属性

                    if(p1.age > p2.age) {
                        return -1;
                    } else if(p1.age < p2.age) {
                        return 1;
                    } else {
                        return 0;
                    }

                }
                // throw 可以代替 return
                throw new RuntimeException("类型不一致");  // 抛出运行时异常
            }
        });

        // 添加元素
        treeMap.put(new Person6("lihua",18),99);
        treeMap.put(new Person6("zhangsan",20),89);
        treeMap.put(new Person6("lisi",25),79);
        treeMap.put(new Person6("wangwu",19),69);

        // 遍历集合
        // 遍历 TreeMap 集合
        // 获取到key-value 存储的 Set Entry 内部类集合对象
        Set<Map.Entry<Person6, Integer>> entries = treeMap.entrySet();
        // 获取到该 Set Entry 内部类集合的迭代器
        Iterator<Map.Entry<Person6, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Person6, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

    }

    public static void main1(String[] args) {
        // 创建TreeMap 集合对象，其中 Key 存储的类为自定义 Person6
        TreeMap<Person6,Integer> treeMap = new TreeMap<Person6,Integer>();

        // 添加元素
        treeMap.put(new Person6("lihua",18),99);
        treeMap.put(new Person6("zhangsan",20),89);
        treeMap.put(new Person6("lisi",25),79);
        treeMap.put(new Person6("wangwu",19),69);

        // 遍历集合
        // 遍历 TreeMap 集合
        // 获取到key-value 存储的 Set Entry 内部类集合对象
        Set<Map.Entry<Person6, Integer>> entries = treeMap.entrySet();
        // 获取到该 Set Entry 内部类集合的迭代器
        Iterator<Map.Entry<Person6, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()) {
            Map.Entry<Person6, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }


    }
}

class Person6 implements Comparable<Person6>{
    String name;
    int age;

    public Person6() {
    }

    public Person6(String name, int age) {
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



    // 当对象中的 name 和 age 属性值相同返回 true,否则返回 fasle
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person6)) return false;
        Person6 person6 = (Person6) o;
        return getAge() == person6.getAge() &&
                Objects.equals(getName(), person6.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    /**
     * 升序的比较规则:
     * this > 参数 ，返回 > 0
     * this < 参数，返回 < 0
     * this == 参数，返回 == 0;
     * 降序反过来：
     * this > 参数 ，返回 < 0
     * this < 参数，返回 > 0
     * this == 参数，返回 == 0;
     */
    @Override
    public int compareTo(Person6 o) {
        // 首先判断该需要比较的参数是否是同一个实例，同一个实例的对象才能比较
        if(o instanceof Person6) {  // 其实这里我们使用了<Person3 o> 泛型限定了，就不需要判断了
            Person6 person6 = (Person6) o;  // 是对应的实例向下转型。
            if(this.age > person6.age) {
                return 1;
            } else if( this.age < person6.age) {
                return -1;
            } else {
                return 0;
            }
        } else {
            // throw 可以替代 return
            throw new RuntimeException("类型不一致");  // 抛出运行时异常
        }
    }

    @Override
    public String toString() {
        return "Person6{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}