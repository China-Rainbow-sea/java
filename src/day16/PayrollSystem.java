package day16;


import java.util.Calendar;

/**
 * 定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各
 * 类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象生日。
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem {
    public static void main(String[] args) {


        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);  // 获取当前的月份
        System.out.println(month);  // 注意 一月份是 0 从 0 开始的
        Employee[] employees = new Employee[2];

        employees[0] = new SalariedEmployee("马森",1002,new MyDate(1992,2,28),10000);

        employees[1] = new HourlyEmployee("Tom",1003,new MyDate(2003,12,9),60,300);

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
            double salary = employees[i].earnings();
            System.out.println("月工资为: "+salary);

            // month+1 因为获取到的月份是从 0 开始的
            if((month+1) == employees[i].getBirthday().getMonth()) {
                System.out.println("生日快乐！奖励100元");
            }
        }
    }
}
