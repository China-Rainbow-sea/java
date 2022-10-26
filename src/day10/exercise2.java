package day10;

public class exercise2 {
    public static void main(String[] args){
        Bank bank = new Bank();
        bank.addCustomer("Tom","Jane");
        bank.addCustomer("李华","张三");

        bank.getCustomers(0).getAccount().deposit(100000000000000000000000000.0);
        // getCustomers(0)第一个用户的账号信息
        // getAccount该用户的账号管理.deposit 存钱
        bank.getCustomers(0).getAccount().withdraw(1000000.0);

        double balance = bank.getCustomers(0).getAccount().getBalance();

        System.out.println("客户："+bank.getCustomers(0).getFirstName()+"该账户余额为"+bank.getCustomers(0).getAccount().getBalance());

        System.out.println("银行客户的个数为:"+bank.getNumberOfCustomer());


    }
}

// 账户
class Account{
    private double balance;  // 余额

    public Account(){
        // 无论是否使用空构造器,一般都会创建一个,提高代码的健壮性
    }

    public Account(double init_balance){
        this.balance = init_balance;
    }

    public double getBalance(){
        return this.balance;
    }


    // 存储
    public void deposit(double amt){
        if( amt > 0){
            this.balance = amt;
            System.out.println("存储成功");
        }
        System.out.println("存款成功");

    }

    // 提取
    public void withdraw(double amt){
        if( this.balance >= amt){
            System.out.println("取款"+amt+",成功");
        } else{
            System.out.println("余额不足");
        }
    }


}



class Customer{
    private String firstName;
    private String lastName;
    private Account account;  // 自定义类的引用类型

    public Customer(){
        // 无论是否使用，无参构造器都创建
    }

    public Customer(String f,String l){
        this.account = new Account();  // 注意引用类型的使用，需要初始化(new 对象),不然就是null 引用报错
        this.firstName = f;
        this.lastName = l;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setAccount(Account acct){
        this.account = acct;
    }

    public Account getAccount(){
        return this.account;
    }


}



class Bank{
//    private Customer[] customers = new Customer[10]; // 定义Customer类引用类型的数组,并初始化
    private Customer[] customers; // 定义的式Customer类引用类型的数组,需要注意的是,数组里面的元素是
                                  // 类引用类型,需要初始化(new 对象后才能使用),不然默认Customer类引用
                                  // 类型的值默认是 null 是无法使用的,null引用报错
    private int numberOfCustomer;

    public Bank(){
        // 无论是否使用无参构造器,都创建
        this.customers = new Customer[10];  // 为Customer类类型数组中的引用类型元素初始化 new对象,防止null引用报错
    }

    public void addCustomer(String f,String l){
        Customer customer = new Customer(f,l);
        this.customers[this.numberOfCustomer++] = customer; // 将用户信息存入到数组中去


    }

    public int getNumberOfCustomer(){
        return this.numberOfCustomer;
    }

    public Customer getCustomers(int index){
        if( index >= 0 && index < this.numberOfCustomer){
            return this.customers[index];
        } else {
            return null;
        }

    }


}
