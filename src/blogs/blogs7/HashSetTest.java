package blogs.blogs7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        // 创建 HashSet 对象,Set 接口，HashSet 实现类，多态
        Set<Animal> set = new HashSet<Animal>();
        set.add(new Animal("小狗",3));
        set.add(new Animal("大象",10));
        set.add(new Animal("小鸟",5));
        set.add(new Animal("小狗",3));

        // 获取到该集合的迭代器
        Iterator<Animal> iterator = set.iterator();
        while(iterator.hasNext()) {
            Animal animal = iterator.next();
            System.out.println(animal);
        }
    }




    public static void main1(String[] args) {
        // 创建 HashSet 对象
        HashSet<Integer> hashSet = new HashSet<Integer>();

        // 添加元素数据
        hashSet.add(123);
        hashSet.add(123);
        hashSet.add(456);
        hashSet.add(789);

        // 遍历
        Iterator<Integer> iterator = hashSet.iterator();  // 获取该集合的迭代器，需要和集合结构同步
        while(iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer);
        }

    }
}


class Animal {
    String name;
    int age;

    public Animal() {

    }

    public Animal(String name, int age) {
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


    // 比较的是两个属性 name 和 age 值相同时，返回 true,否则返回 false.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getAge() == animal.getAge() &&
                Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}