package day18.com.RainbowSea.team.service;

import day18.com.RainbowSea.team.domain.Architect;
import day18.com.RainbowSea.team.domain.Designer;
import day18.com.RainbowSea.team.domain.Employee;
import day18.com.RainbowSea.team.domain.Programmer;

/**
 * 关于开发团队成员的管理：添加、删除等
 */
public class TeamService {
    private static int counter = 1;     // 用来为开发团队新增成员自动生成团队中的唯一ID，
    private final int MAX_MEMBER = 5;         // 表示开发团队最大成员数
    private Programmer[] team = new Programmer[this.MAX_MEMBER];    // 用来保存当前团队中的各成员对象
    private int total = 0;        // 记录团队成员的实际人数


    public TeamService() {
        // 无参构造器
        super(); // 调用父类中的无参构造器
    }


    /**
     * getTeam()方法：返回当前团队的所有对象
     * // 返回的的实际存在的队员
     *
     * @return Programmer[]  返回：包含所有成员对象的数组，数组大小与成员人数一致
     */
    public Programmer[] getTeam() {

        // 创建一个程序员元素数组，因为所有类 : Architect(架构师),Designer(设计师) 都继承了该类,多态性
        Programmer[] team = new Programmer[this.total];

        // 拷贝复制，实际存在的队员
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }

        return team;
    }


    /**
     * ：向团队中添加成员
     *
     * @param employee 待添加成员的对象（需要向下转型为 Programmer 添加到数组当中 ）
     * @throws TeamException 自定义异常：编译异常
     */
    public void addMember(Employee employee) throws TeamException {

        // 判断该团队是否满员了
        if (this.total == this.MAX_MEMBER) {
            // 手动抛出异常,throw 编译异常,一般配合 throws 向上抛出异常,调用者处理
            throw new TeamException("该团队成员已满，无法添加了");
        }

        // 判断如果不是程序员，无法添加到该团队当中的
        if (!(employee instanceof Programmer)) {
            // 手动抛出异常 throw
            throw new TeamException("该成员不是开发人员，无法添加");
        }

        // 该员工已在本开发团队中
        if (this.isExit(employee)) {
            // 手动抛出异常 throw 编译异常
            throw new TeamException("该员工已在本开发团队中");
        }

        // 该员工已是某团队成员
        // 这里
        // 左值为确定值，防止 null引用
        // 这里向下转型: 多态，是一定可以向下转型成功的，因为上面已经判断过了. employee instanceof Programmer
        if ("BUSY".equals(((Programmer) employee).getStatus())) {
            throw new TeamException("该员工已是某团队成员");
        }

        // 该员正在休假，无法添加
        // 这里向下转型: 多态，是一定可以向下转型成功的，因为上面已经判断过了. employee instanceof Programmer
        if ("VOCATION".equals(((Programmer) employee).getStatus())) {
            throw new TeamException("该员正在休假，无法添加");
        }

        // 注意必须从小到大，不让大的可能会先进入
        // 团队中至多只能有一名架构师
        // 团队中至多只能有两名设计师
        // 团队中至多只能有三名程序员
        // 修改状态
        int numOfArch = 0;  // 该团队中架构师的个数
        int numOfDes = 0;   // 该团队中设计师的个数
        int numOfPro = 0;   // 该团队中程序员的个数

        // 从小到大的范围判断，因为存在一定的继承关系
        for (int i = 0; i < this.total; i++) {
            // 如果是架构师的实例，++
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {  // 设计师的实例，++
                numOfDes++;
            } else if (team[i] instanceof Programmer) {  // 程序员的实例,++
                numOfPro++;
            }

        }

        // 从小到大的范围判断，因为存在一定的继承关系
        // 架构师
        if (employee instanceof Architect) {
            if (numOfArch >= 1) {  // 大于 1位，
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (employee instanceof Designer) {   // 设计师
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (employee instanceof Programmer) {  // 程序员
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        // 如下是错误的设计
        /*
        如果其中的添加的是: Architect 2 会进入 else if ((employee instanceof Designer) && (numOfDes >= 2)) {
        语句： 报错的是:  throw new TeamException("团队中至多只能有两名设计师");
        而不是  throw new TeamException("团队中至多只能有一名架构师");
        因为 Architect 也是 Designer 子类，instanceof 返回的是 true
         */
        /*if ((employee instanceof Architect) && (numOfArch >= 1)) {
            throw new TeamException("团队中至多只能有一名架构师");
        } else if ((employee instanceof Designer) && (numOfDes >= 2)) {
            throw new TeamException("团队中至多只能有两名设计师");
        } else if ((employee instanceof Programmer) && (numOfPro >= 3)) {
            throw new TeamException("团队中至多只能有三名程序员");
        }*/


        // 最后没有问题，添加到该团队的数组当中共
        // 修改其中的状态
        // 向下转型，一定会成功的，因为上面已经判断过了: employee instanceof Programmer
        ((Programmer) employee).setStatus(Status.BUSY);
        // 该员工在团队中的 MID 设置
        ((Programmer) employee).setMemberId(this.counter++);

        // 添加到团队数组当中
        this.team[this.total] = (Programmer) employee;  // 强制转换位，向下转型。
        // 最后将实际团队中的数量 ++
        this.total++;
    }


    /**
     * 判断该员工是否已经存在于开发团队当中了.
     *
     * @param e 程序员对象
     * @return 已经存在返回 true,不存在返回 false
     */
    private boolean isExit(Employee e) {

        for (int i = 0; i < this.total; i++) {
            if (e.getId() == this.team[i].getId()) {
                return true;   // 找到了，已经存在了
            }
        }
        return false;   // 没有找到，不存在
    }


    /**
     * 从团队中删除成员
     *
     * @param memberId 团队中的 ID,不是公司中的ID
     */
    /*
    判断该成员ID,是否在成员团队当中
    删除前，将其状态修改为 FREE
    移动覆盖前数组信息，
    最后 this.total 实际的个数
     */
    public void removeMember(int memberId) throws TeamException {
        // 判断该成员ID 是否在成员团队当中
        int i = 0;
        for (i = 0; i < this.total; i++) {
            if (this.team[i].getMemberId() == memberId) {
                break;  // 存在，并找到了，退出循环，删除操作
            }
        }

        // 数组循环变量完了，还没有找到，即不存在。
        if (i == this.total) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

        // 删除前将，其状态改为 空闲 FREE
        this.team[i].setStatus(Status.FREE);
        for (int j = i + 1; j < this.total; j++) {
            this.team[j - 1] = this.team[j];
        }

        // 将最后一个数组元素置为 null
        this.team[this.total - 1] = null;
        this.total--;


    }
}
