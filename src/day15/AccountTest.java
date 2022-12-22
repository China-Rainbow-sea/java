package day15;


/**
 * 编写一个类实现银行账户的概念,包含的属性有"账号"，"密码"，"存款"
 * 定义封装这些属性的方法，账号要自动生成
 *   编写主类: 使用银行账户类，输入，输出3个储户的上述信息
 *   考虑: 哪些属性可以设计成 static 属性
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct1 = new Account();
        Account acct2 = new Account("123",2000);

        Account.setInterestRate(0.012);
        Account.setMinMoney(100);

        System.out.println(acct1);
        System.out.println(acct2);

        System.out.println(acct1.getInterestRate());
        System.out.println(acct1.getMinMoney());

        System.out.println("**********************");
        System.out.println(acct2.getInterestRate());
        System.out.println(acct2.getMinMoney());


    }


}


class Account{
    private int id;
    private String pwd;
    private double balance;
    private static double interestRate;
    private static double minMoney = 1.0;
    private static int init = 1001;   // 用于自动生成 id 使用的

    public Account() {
        id = init++;
    }

    /*public Account(String pwd,double balance) {
        id = init++;
        this.pwd = pwd;
        this.balance = balance;
    }
*/
    // 优化

    public Account(String pwd,double balance) {
        this();  // 调用构造器方法，必须是构造器调用构造器方法(),必须放在第一行的位置才可以被调用
        this.pwd = pwd;
        this.balance = balance;
    }


    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }


    // 静态属性对应的set/get方法都是 static 的方法的
    public static double getMinMoney() {
        return minMoney;
    }

    public static double getInterestRate() {
        return interestRate;
    }


    // 静态属性对应的set/get方法都是static 的方法的
    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    public static void setMinMoney(double minMoney) {
        Account.minMoney = minMoney;
    }

    @Override
    public String toString() {
        // 注意: 对于 toString 一般重写的不会包含 static 静态属性
        return "Account{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
