package day25;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DAOS<T> {
    private Map<String,T> map = null;

    public DAOS() {
        // 构造器为其Map集合初始化
        this.map = new HashMap<>();
    }

    // 保存 T 类型的对象到Map成员变量中
    public void save(String id,T entity) {
        map.put(id,entity);
    }

    // 从map中获取id对应的对象
    public T get(String id) {
        return map.get(id);
    }

    // 替换Map中的 key 为 id 的内容，改为 entity对象
    public void update(String id,T entity) {
        if(map.containsKey(id)) {  // 首先判断该修改的 key 是否存在，
            // 存在通过 put()添加覆盖
            map.put(id,entity);
        }
    }

    // 返回map中存放的所以 T 对象
    public List<T> list() {
        Collection<T> values = map.values();
        List<T> list = new ArrayList<T>();
        // 注意了: Collection 是 List 的父类接口，如果List 对象不是 Collection 的实例
        // 是无法将一个父类强制(向下)为子类的，(这里两个都是接口，不可能有实例的)
        // 通过取出所以的values 值赋值到一个新创建的 List 对象当中再返回。
        for (T t : values) {
            list.add(t);
        }
        return list;

    }

    // 删除指定id对象
    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User() {

    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 因为存储的是在Map当中所以，Map当中的Key 存储对象需要重写 equals() 和 hashCode() 方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getAge() == user.getAge() &&
                Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge(), getName());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}