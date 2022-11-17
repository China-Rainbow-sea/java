package day13;

/**
 * 测试 Account 类
 */
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(111,2000,0.045);

        account.withdraw(3000);
        System.out.println("您的余额为: "+account.getBalance());
        account.withdraw(5000);
        System.out.println("你的余额为: "+account.getBalance());
        account.deposit(3000);
        System.out.println("您的余额为："+account.getBalance());

        System.out.println("月利率为: "+account.getAnnualInterestRate()*100+"%");
    }

}
