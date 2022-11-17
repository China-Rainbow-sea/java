package day13;

public class Account {
    private int id;   // 账号
    private double balance ; // 余额
    private double annualInterestRate;  // 年利息

    public Account() {
        // 无参构造器
    }


    public Account(int id, double balance,double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }


    /**
     * 计算月利率
     * @return double
     */
    public double getMonthlyInterest() {
        return this.annualInterestRate / 12 ;
    }

    /**
     * 取款方式
     * @param amount
     */
    public void withdraw (double amount) {
        if(amount >= 0 && amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("余额不足");
        }
    }


    /**
     * 存钱
     * @param amount
     */
    public void deposit (double amount) {
        if(amount >= 0) {
            this.balance += amount;
        } else {
            System.out.println("你存入的金额不对");
        }
    }

}
