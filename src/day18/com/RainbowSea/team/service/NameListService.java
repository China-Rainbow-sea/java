package day18.com.RainbowSea.team.service;

import day18.com.RainbowSea.team.domain.Employee;
import static day18.com.RainbowSea.team.service.Data.*;


public class NameListService {
    private Employee[] employees;   // 保存公司所有的员工对象


    /**
     * NameListService()构造器：
     * 根据项目提供的Data类构建相应大小的employees数组
     * 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
     * 将对象存于数组中
     */
    public NameListService() {
        // 无参构造器
        Employee[] employees = new Employee[Data.EMPLOYEES.length];  // Data.EMPLOYEE是 public static finally 记录数组的大小的变量
        // Data.EMPLOYEES.length 的另外一种使用方式:
        // 静态变量的导入包: import static day18.com.RainbowSea.team.service.Data.*; 就可以省略类名直接调用其中的静态变量
        // Employee[] employees1 = new Employee[EMPLOYEES.length];


        /*
        根据不同的Data类中的不同数据的对象(Employee、Programmer、Designer和Architect对象)
        将其存入于数组当中。
         */
        for(int i = 0; i < employees.length; i++ ) {

            // 将字符串转换为基本数据类型，注意已经是字符串了就不要再附加 “双引号”了。
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]); // 该二维数组中的第一个数值存储的就是标识不同对象标志

            switch(type) {
                case EMPLOYEE :      // 普通员工

                    // 将 EMPLOYEES 数组中存储的字符串转换为基本数据类型
                    int id = Integer.parseInt(Data.EMPLOYEES[i][1]);   // EMPLOYEES 数组中存储的ID
                    String name = Data.EMPLOYEES[i][2];  // EMPLOYEES 数组中存储的名字
                    int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
                    double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

                    // 通过读取到  Data.EMPLOYEES 二位数组中的数据将创建对应调用其构造器 new 对象
                    // 并存储到对应的下标位置中的 employees数组中去。
                    // 因为其中所赋值的new: Programmer，Designer，Architect 类都是继承了 Employee类的: 多态性;
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER :    // 程序员
                    break;
                case DESIGNER :      // 设计师
                    break;
                case ARCHITECT :     // 架构师
                    break;

            }

        }
    }



    public NameListService(Employee[] employees) {
        this.employees = employees;
    }


    /**
     * 获取当前所有员工
     * @return  Employee[]
     */
    public Employee[] getAllEmployee() {
        return this.employees;
    }


    /**
     * 获取指定ID的员工对象。
     * @param id 员工的ID
     * @return Employee 指定员工对象
     * @throws TeamException 找不到指定的员工
     */
    public Employee getEmployee(int id) {
        return null;
    }
}
