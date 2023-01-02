package day18.com.RainbowSea.team.domain;


import day18.com.RainbowSea.team.service.Status;

/**
 * 程序员类
 */
public class Programmer extends Employee {
    private int memberId;        // 加入对应开发团队的的 TID
    private Status status = Status.FREE;       // 该程序员的状态信息
    private Equipment equipment; // 该程序员的设备信息

    public Programmer() {
        super();   // 调用父类中的无参构造器
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);   // 调用父类中的无参构造器
        this.equipment = equipment;
    }

    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String toString() {
        return super.getDetails() + "\t程序员\t" + this.status + "\t\t\t\t\t\t\t\t\t\t\t\t"
                + this.equipment.getDescription();
        // this.equipment.getDescription() 每个Programmer程序员类都实现了 Equipment 这个接口中的抽象方法
    }


    /** 统一的一个前四个信息的打印显示
     *
     * @return String
     */
    public String getTeamBaseDetails() {
        return this.memberId + "/" + super.getId() + "\t\t" + super.getName() + "\t" + super.getAge() +
                "\t\t" + super.getSalary();
    }

    public String getDetailsForTeam() {
        return this.getTeamBaseDetails() + "\t程序员\t";
    }
}
