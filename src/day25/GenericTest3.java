package day25;


import org.junit.Test;

import java.util.List;

/**
 * 泛型的使用情景
 */
public class GenericTest3 {

    @Test
    public void test() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());  // 限定了存储类型为泛型中的Customer
    }
}

class DAO<T> {
    // 添加一条记录
    public void add(T t) {

    }

    // 删除一条记录
    public boolean remove(int index) {
        return false;
    }

    // 修改一条记录
    public void update(int index,T t) {

    }

    //查询一条记录
    public T getIndex(int index) {
        return null;
    }

    // 查询多条记录
    public List<T> getForList(int index) {
        return null;
    }

    // 泛型方法，获取到其中一共有多少条记录(long)，获取最大的员工入职时间(Date)
    // <E> 泛型方法的标志，E 表示泛型
    public <E> E getValue() {
        return null;
    }
}

class CustomerDAO extends DAO<Customer> {


}

class Customer {

}
