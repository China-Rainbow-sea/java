package day11;

import java.util.Scanner;

/**
 * CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，
 * 并提供相应的添加、修改、删除和遍历方法，供CustomerView调用
 */
public class CustomerView {
    private Scanner scanner = new Scanner(System.in); // 在类当中实例化对象的属性
    private CMUtility cmUtility = new CMUtility();  // 在类当中实例化对象的属性
    private CustomerList customerList = new CustomerList(10); // 在类当中实例坏对象的类属性,并赋值10大小容量
    private boolean sign = true;

    public CustomerView() {
        // 先在构造器中创建customer添加数据,并赋值
        Customer customer = new Customer("李华",'男',19,"123","987");
        customerList.addCustomer(customer);
    }


    /**
     * 界面菜单的实现:
     */
    public void enterMainMenu() {
        while(sign) {
            System.out.println("**************** 客户信息管理软件 **************");
            System.out.println("                    1. 添加客户                ");
            System.out.println("                    2. 修改客户                ");
            System.out.println("                    3. 删除客户                ");
            System.out.println("                    4. 客户列表                ");
            System.out.println("                    5. 退    出                ");
            System.out.print("请选择(1-5): ");
            char choice = cmUtility.readMenuSelection();
            switch(choice) {
                case '1':
                    this.addNewCustomer();
                    break;
                case '2':
                    this.modifyCustomer();
                    break;
                case '3':
                    this.deleteCustomer();
                    break;
                case '4':
                    this.listAllCustomer();
                    break;
                case '5':
                    this.exitCustomer();
                    break;
                default:
                    break;   // 实际上并不会执行的,只是提高代码的完整性,以及 一个预防
            }

        }
    }


    /**
     * 添加客户
     */
    private void addNewCustomer() {
        System.out.println("**************** 添加客户 **************");
        System.out.print("姓名: ");
        String name = cmUtility.readString(10);
        System.out.print("性别: ");
        char gender = cmUtility.readChar();
        System.out.print("年龄: ");
        int age = cmUtility.readInt();
        System.out.print("电话: ");
        String phone = cmUtility.readString(13);
        System.out.print("邮箱: ");
        String email = cmUtility.readString(30);
        System.out.println("***************************************");

        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(customer); // 将创建的对象的地址促存储到对应的数组当中

        if(isSuccess) {
            System.out.println("添加成功");
        } else {
            System.out.println("客户目录,已满无法再添加了");
        }

    }



    /**
     *修改客户
     */
    public void modifyCustomer() {
        System.out.println("**************** 修改客户 **************");
        Customer indexCustomer = null;
        int num = 0;
        while(true) {
            System.out.print("请选择待修改的客户编号:(-1退出): ");
            num = scanner.nextInt();

            if(-1 == num) {
                return ; // 退出修改客户
            }

            // 查询该编号的用户是否存在
            indexCustomer = customerList.getIndexCustomer(num - 1);
            if(null == indexCustomer) {
                System.out.println("该编号的用户不存在");
            } else {
                // 存在跳出循环,修改数据
                break;
            }
        }

        // 修改用户信息:
        // 如果输入的是空格,则赋值原来的数据
        System.out.print("姓名: ");
        String name = cmUtility.readString(10,indexCustomer.getName()); // 如果输入的是空格,则赋值原来的数据
        System.out.print("性别: ");
        char gender = cmUtility.readChar(indexCustomer.getGender());
        System.out.print("年龄: ");
        int age = cmUtility.readInt(indexCustomer.getAge());
        System.out.print("电话: ");
        String phone = cmUtility.readString(13,indexCustomer.getPhone()); // 如果输入的是空格,则赋值为原来的数据
        System.out.print("邮箱: ");
        String email = cmUtility.readString(30,indexCustomer.getEmail());

        Customer customer = new Customer(name,gender,age,phone,email); // 将修改的信息创建一个新对象保存起来.
        // 再赋值到,需要修改的数组下标位置,将旧的customer类对象的值给覆盖掉,而旧的customer的对象的因为没有被引用了,被jvm自动释放了
        boolean isRepalaced = customerList.replaceCustomer(num-1, customer); // 注意数组的实际下标位置是从 0 开始的.
        if(isRepalaced) {
            System.out.println("**************** 修改成功 **************");
        } else {
            System.out.println("**************** 修改失败 **************");
        }

    }


    /**
     * 删除客户
     */
    public void deleteCustomer() {
        int number = 0;
        for(;;) {
            System.out.print("请选择待删除客户编号(-1退出): ");

            number = cmUtility.readInt();  // 判断输入的是编号整数类型

            Customer customer = customerList.getIndexCustomer(number-1);  // 判断该编号的是否存在客户端的信息

            if(null == customer) {
                System.out.println("该编号的用户不存在");
            } else {
                break;  // 找到了跳出循环,做删除的处理操作,
            }
        }

        // 删除操作
        System.out.print("确认删除吗(Y/N): ");
        char isDelete = cmUtility.readConfirmSelection();
        if('Y' == isDelete) {
            boolean deleteSuccess = customerList.deleteCustomer(number - 1);//  注意实际用户输入的编号和数组的下标位置
            if(deleteSuccess) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } else {
            return ; // 选择 N 退出
        }

    }



    /**
     * 查询客户列表
     */
    public void listAllCustomer() {
        System.out.println("**************** 客户列表 **************");
        if(0 == customerList.getTotal()) {
            System.out.println("没有客户记录");
        }
        else {
            Customer[] customers = customerList.getAllCustomer();

            System.out.println("编号  姓名  性别  年龄 电话 邮箱");
            for(int i = 0;i< customerList.getTotal(); i++) {
                Customer customer = customerList.getIndexCustomer(i);  // 获取到对应的类中的属性Customer类属性
                System.out.println((i+1)+"  \t"+customer.getName()+"\t"+customer.getGender()+"\t"
                        +customer.getAge()+"\t"+customer.getPhone()+"\t"+customer.getEmail());
            }
        }
        System.out.println("***************************************");
    }


    /**
     * 退出系统
     */
    public void exitCustomer() {
        System.out.print("是否确认退出(Y/N): ");
        char isExit = CMUtility.readConfirmSelection();

        if(isExit == 'Y') {  // 注意字符串的比较,比较的是数值
            this.sign = false;
        }

    }



}
