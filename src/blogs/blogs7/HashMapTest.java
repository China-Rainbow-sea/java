package blogs.blogs7;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put(null,null);
        hashMap.put(null,null);
        hashMap.put(null,null);
        hashMap.put("1",null);
        hashMap.put("2",null);
        hashMap.put("3",null);

        // 遍历HashMap 集合
        Set<Map.Entry<String,Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String,Integer> entry : entries) {
            System.out.println(entry);
        }
    }

    public static void main1(String[] args) {
        HashMap<Person5,Integer> hashMap = new HashMap<Person5, Integer>();
        hashMap.put(new Person5("Tom",19),1);
        hashMap.put(new Person5("Tom",19),1);
        hashMap.put(new Person5("Tom",19),1);
        hashMap.put(new Person5("zhangsan",23),4);
        hashMap.put(new Person5("lihua",20),5);

       // 遍历HashMap 集合
        Set<Map.Entry<Person5,Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Person5,Integer> entry : entries) {
            System.out.println(entry);
        }

    }
}


class Person5 {
    String name;
    int age;

    public Person5() {
    }

    public Person5(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person5)) return false;
        Person5 person5 = (Person5) o;
        return age == person5.age &&
                Objects.equals(name, person5.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person5{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
