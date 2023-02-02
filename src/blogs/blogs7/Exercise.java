package blogs.blogs7;

import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(1);

        System.out.println(list);

        // 去重复
        list = duplicateList(list);
        System.out.println(list);

    }

    // 去重复
    public static List duplicateList(List list) {
        // 将list 作为参数，创建 HashSet 集合对象，HashSet 无法添加重复数据
        HashSet<Integer> hashSet = new HashSet<>(list);
        // 再返回一个：hashSet 以及去完冲重复数据的对象作为参数，创建一个新的 ArrayList 集合返回
        return new ArrayList<Integer>(hashSet);
    }


    public static void main1(String[] args) {
        HashSet set = new HashSet();
        Person p1 = new Person("AA", 1001);
        Person p2 = new Person("BB", 1002);

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";
        if (set.remove(p1)) {
            System.out.println("移除成功");
        }
        System.out.println(set);

        set.add(new Person("CC",1001));
        System.out.println(set);

        set.add(new Person("AA",1001));
        System.out.println(set);

    }
}


class Person {
    String name;
    int id;

    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
