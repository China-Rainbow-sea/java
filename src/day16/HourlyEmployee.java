package day16;

/**
 * 参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的
 * 员工处理。该类包括：
 *
 * private成员变量wage和hour；
 *
 * 实现父类的抽象方法earnings(),该方法返回wage*hour值；
 *
 * toString()方法输出员工类型信息及员工的name，number,birthday。
 */
public class HourlyEmployee extends Employee {
    private double wage;
    private double hour;




    @Override
    public Double earnings() {
        return this.wage * this.hour;
    }

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, double hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
