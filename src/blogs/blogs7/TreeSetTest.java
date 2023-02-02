package blogs.blogs7;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        // 将 new Comparator()匿名实现类，作为参数传入到 TreeSet 构造器中
        TreeSet<Person3> treeSet = new TreeSet<Person3>(new Comparator<Person3>() {

            // 该定制排序，根据 age 年龄，降序排序
            @Override
            public int compare(Person3 o1, Person3 o2) {
                // 判断是否是对应比较的实例，其实这里我们可以不用判断的，因为使用的泛型限定
                if(o1 instanceof Person3 && o2 instanceof  Person3) {
                    Person3 p1 = (Person3)o1;
                    Person3 p2 = (Person3)o2;  // 向下转型为对应的实例对象，从而获取比较属性

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
        treeSet.add(new Person3("Tom",18));
        treeSet.add(new Person3("zhangsan",20));
        treeSet.add(new Person3("lisi",10));

        Iterator<Person3> iterator = treeSet.iterator();
        while(iterator.hasNext()) {
            Person3 next = iterator.next();
            System.out.println(next);
        }

    }
}

class Person3 implements Comparable<Person3> {
    String name;
    int age;

    public Person3() {
    }

    public Person3(String name, int age) {
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
        if (!(o instanceof Person3)) return false;
        Person3 person3 = (Person3) o;
        return getAge() == person3.getAge() &&
                Objects.equals(getName(), person3.getName());
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
    public int compareTo(Person3 o) {
        // 首先判断该需要比较的参数是否是同一个实例，同一个实例的对象才能比较
        if(o instanceof Person3) {  // 其实这里我们使用了<Person3 o> 泛型限定了，就不需要判断了
            Person3 person3 = (Person3) o;  // 是对应的实例向下转型。
            if(this.age > person3.age) {
                return 1;
            } else if( this.age < person3.age) {
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
        return "Person3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
