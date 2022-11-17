package day13;

public class CheckAccount extends Account{
    private double overdraft;   // 可透支额度
    public CheckAccount () {
        // 无参构造器
        super();
    }


    public CheckAccount(int id, double balance, double annualInterestRate,double overdraft) {
        super(id, balance, annualInterestRate);  // 调用父类中的构造器,赋值初始化
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    /**
     * 取款操作
     * @param amount
     */
    @Override
    public void withdraw(double amount) {
        // 先判断本金是否够用
        if(amount <= super.getBalance()) {
            super.setBalance(getBalance()-amount);
        } else if(amount <= this.overdraft + super.getBalance()) {
            this.overdraft -= (amount - super.getBalance());
            super.withdraw(getBalance()); // 将本金取空
            // 或者将本金置为 0
//            setBalance(0);
        } else {
            System.out.println("超过可透支额的限额 !!!");
        }
    }
}
