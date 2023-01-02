package day18.com.RainbowSea.team.service;

import day18.com.RainbowSea.team.domain.*;

//import static day18.com.RainbowSea.team.service.Data.*;


public class NameListService {
    // 创建引用类类型的数组，数组的元素是 employees 接口类型
    private Employee[] employees;   // 保存公司所有的员工对象


    /**
     * NameListService()构造器：
     * 根据项目提供的Data类构建相应大小的employees数组
     * 再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
     * 将对象存于数组中
     */
    public NameListService() {
        // 无参构造器
        employees = new Employee[Data.EMPLOYEES.length];  // Data.EMPLOYEE是 public static finally 记录数组的大小的变量
        // Data.EMPLOYEES.length 的另外一种使用方式:
        // 静态变量的导入包: import static day18.com.RainbowSea.team.service.Data.*; 就可以省略类名直接调用其中的静态变量
        // Employee[] employees1 = new Employee[EMPLOYEES.length];


        /*
        根据不同的Data类中的不同数据的对象(Employee、Programmer、Designer和Architect对象)
        将其存入于数组当中。
         */
        for (int i = 0; i < employees.length; i++) {

            // 从数组中获取到员工的类型: Employee、Programmer、Designer和Architect
            // 将字符串转换为基本数据类型，注意已经是字符串了就不要再附加 “双引号”了
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]); // 该二维数组中的第一个数值存储的就是标识不同对象标志

            // 如下是所有创建对象(调用构造器)时共用的参数信息，变量的声明
            // 将 EMPLOYEES 数组中存储的字符串转换为基本数据类型
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);   // EMPLOYEES 数组中存储的ID
            String name = Data.EMPLOYEES[i][2];  // EMPLOYEES 数组中存储的名字
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);
            double bonus = 0;

            switch (type) {
                case Data.EMPLOYEE:      // 普通员工

                    // 通过读取到  Data.EMPLOYEES 二位数组中的数据将创建对应调用其构造器 new 对象
                    // 并存储到对应的下标位置中的 employees数组中去。
                    // 因为其中所赋值的new: Programmer，Designer，Architect 类都是继承了 Employee类的: 多态性;
                    employees[i] = new Employee(id, name, age, salary); // 存储到数组当中去
                    Equipment equipment = null;
                    break;
                case Data.PROGRAMMER:    // 程序员
                    // 获取到 Data.EQUIPMENTS[][] 员工设备配置信息的数组中的信息：通过 下标
                    equipment = this.createEquipment(i);
                    Programmer programmer = new Programmer(id, name, age, salary, equipment);
                    employees[i] = programmer;   // 存储到数组当中去
                    break;
                case Data.DESIGNER:      // 设计师
                    equipment = this.createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    Designer designer = new Designer(id,name,age,salary,equipment,bonus);
                    employees[i] = designer;   // 存储到数组当中去
                    break;
                case Data.ARCHITECT:     // 架构师
                    equipment = this.createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    Architect architect = new Architect(id,name,age,salary,equipment,bonus,stock);
                    employees[i] = architect;   // 存储到数组当中去
                    break;

            }

        }
    }


    public NameListService(Employee[] employees) {
        this.employees = employees;
    }

    /**
     * 获取到Data.EQUIPMENTS 数组数据信息中指定下标中 index 的信息
     *
     * @param index 数组下标
     * @return Equipment 接口(多态性)
     */
    private Equipment createEquipment(int index) {
        // 对应员工的机器配置:
        int key = Integer.parseInt(Data.EQUIPMENTS[index][0]);

        String modelOrName = Data.EQUIPMENTS[index][1];
        switch (key) {
            case Data.PC:        // 21
                String display = Data.EQUIPMENTS[index][2];
                PC pc = new PC(modelOrName, display);
                return pc;
            case Data.NOTEBOOK:  // 22
                double price = Double.parseDouble(Data.EQUIPMENTS[index][2]);
                NoteBook noteBook = new NoteBook(modelOrName, price);
                return noteBook;
            case Data.PRINTER:   // 23
                String type = Data.EQUIPMENTS[index][2];
                Printer printer = new Printer(modelOrName, type);
                return printer;
        }

        return null;
    }

    /**
     * 获取当前所有员工
     *
     * @return Employee[]
     */
    public Employee[] getAllEmployee() {
        return this.employees;
    }


    /**
     * 获取指定ID的员工对象。
     *
     * @param id 员工的ID
     * @return Employee 指定员工对象
     * @throws TeamException 找不到指定的员工
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < this.employees.length; i++) {
            if(id == employees[i].getId()) {  // 找到了。
                return employees[i];
            }
        }


        // 没有找到报错异常,// 一般自定义的异常类，基本上是配合 throws 向上抛出异常给调用者处理，
        throw new TeamException("找不到指定的员工");
    }
}
