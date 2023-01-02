package day18.com.RainbowSea.team.view;

import day18.com.RainbowSea.team.domain.Employee;
import day18.com.RainbowSea.team.domain.Programmer;
import day18.com.RainbowSea.team.service.NameListService;
import day18.com.RainbowSea.team.service.TeamException;
import day18.com.RainbowSea.team.service.TeamService;
import day18.com.RainbowSea.team.utility.TSUtility;

import java.util.Scanner;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();

    }

    /**
     * 菜单的调用
     */
    public void enterMainMenu() {
        boolean loop = true;
        char menu = 0;
        while (loop) {

            // 当 menu != '1'的时候显示，因为 '1' 选择是显示 团队列表的
            if (menu != '1') {
                listAllEmployees();
            }

            System.out.print("1-团队列表 2-添加团队成员 3-删除团队 4-退出 请选择(1-4): ");
            menu = TSUtility.readMenuSelection();  // 1~4 的选择

            switch (menu) {
                case '1':       // 团队列表
                    this.getTeam();
                    break;
                case '2':       // 添加团队成员
                    this.addMember();
                    break;
                case '3':       // 删除团员
                    this.deleteMember();
                    break;
                case '4':       // 退出
                    System.out.println("退出");
                    System.out.print("你确定退出(Y/N): ");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("你的输入有误请重新输入");
                    break;
            }
        }
    }

    /**
     * 以表格形式列出公司所有成员
     */
    private void listAllEmployees() {
        System.out.println("***************************************开发团队调度软件****************************************");
        Employee[] employees = listSvc.getAllEmployee();
        // 开发团队无一人
        if (employees == null || employees.length == 0) {
            System.out.println("公司中没有任何员工信息");
        }

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

    }


    /**
     * 显示团队成员列表操作
     */
    private void getTeam() {
        System.out.println("***********************************团队成员列表*************************");

        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队目前没有成员");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }


        System.out.println("***********************************************************************");
    }


    /**
     * 实现添加成员操作
     */
    private void addMember() {
        System.out.println("*************************************添加成员***************");
        System.out.print("请输入要添加的员工的ID: ");
        int id = TSUtility.readInt();

        try {
            Employee emp = listSvc.getEmployee(id);
            teamSvc.addMember(emp);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因: " + e.getMessage());
        }
        // 按回车键继续
        TSUtility.readReturn();
    }


    /**
     * 实现删除成员操作
     */
    private void deleteMember() {
        System.out.println("**************************删除员工********************");
        System.out.print("请输入要删除的员工的TID: ");
        int memberId = TSUtility.readInt();

        System.out.print("确认是否删除(Y/N): ");
        char isDelete = TSUtility.readConfirmSelection();

        if(isDelete == 'N') {
            return ;
        }

        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因: "+e.getMessage());
        }

        // 按回车键继续
        TSUtility.readReturn();
    }

}
