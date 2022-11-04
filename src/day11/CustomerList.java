package day11;


/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 */
public class CustomerList {

    private Customer[] customers;  // 定义数组类型的类的属性,用于存放Customer数据
    private int total = 0;   // 存放该数组中的客户信息的总个数

    public CustomerList() {
        // 无参构造器,一般构造器的权限和该定义的类的权限一致,构造器不可以private 私有化(私有化了还如何调用构造器实例化对象了)
    }

    public CustomerList(int totalCustomer) {
        this.customers = new Customer[totalCustomer];  // 为该类的Customer数组设定大小
    }



    /**
     * 用途: 将参数 customer 添加到数组中最后一个客户端对象记录下来
     * 参数：customer 要添加的对象
     * @param customer
     * @return 添加成功 true , 添加失败false
     */
    public boolean addCustomer(Customer customer) {
        if(this.total >= this.customers.length) {
            return false;  // 数据已满无法添加了
        }
        this.customers[total] = customer;  // 将对象赋值添加到数组中去
        this.total++;   // 同时添加计数个数
        return true;
    }



    /**
     * 用途: 修改指定编号的数据内容
     *
     * @param index, customer
     * @return 修改数据成功true,失败false
     */
    public boolean replaceCustomer(int index,Customer customer) {
        /*
        通过修改数组中原来存放的数值customer的地址,赋值为修改后的新的 customer的对象的地址，
        旧的customer因为没有被引用了被 jvm 回收了,
         */
        // 首先判断输入的编号是否合理是否存在越界的可能性
        if(index < 0 || index >= this.total) {
            return false;
        }
        this.customers[index] = customer;
        return true;
    }



    /**
     * 用途删除指定编号的数据信息
     * @param index
     * @return delete成功true, delete失败false
     */
    public boolean deleteCustomer(int index) {
        /*
        通过将后面的下标的数据从后往前移动,到达一个将旧的数据的覆盖,再将最后一个存在数据的下标位置置为null
         */
        // 判断该下标是否合理
        if(index < 0  || index >= this.total) {
            return false;
        }

        for(int i = index; i < this.total-1; i++) {
            this.customers[i] = this.customers[i+1]; // 注意这里存在一个i+1,所以 i 不可以取到最后一个下标位置
        }
        this.customers[total-1] = null; // 为最后一个数据被移动置为到前面了,置为null
        this.total--;  // 个数减少
        return true;
    }



    /**
     * 返回所有记录的所有客户端的信息
     * @return Customer[]
     */
    public Customer[] getAllCustomer() {
        // 通过将原customer含有的数据进行一个赋值的copy数组操作
        Customer[] copyCustomer = new Customer[this.total];
        for(int i = 0; i < this.total; i++) {
            copyCustomer[i] = this.customers[i];
        }
        return copyCustomer;
    }



    /**
     * 作用:查询指定下标的客户信息
     * @param index
     * @return Customer
     */
    public Customer getIndexCustomer(int index) {
        // 首先判断 index 所查询的下标的客户信息是否合理
        if(index < 0 || index >= this.total) {
            return null;
        }

        return this.customers[index];
    }


    /**
     * 作用：查询从客户的总数
     * @return
     */
    public int getTotal() {
        return this.total;
    }

}
