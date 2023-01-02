package day18.com.RainbowSea.team.service;


/**
 * 自定义枚举类，通过单例的设计模式的思想
 */
public class Status {
    private final String NAME;

    // 注意附加上 final 防止被修改了.
    public static final Status FREE = new Status("FREE");          // 空闲的
    public static final Status BUSY = new Status("BUSY");          // 已加入开发团队
    public static final Status VOCATION = new Status("VOCATION");  // 正在休假

    // 将构造器私有化，防止: 不让其在后面私有化,通过而是通过 public static 访问和类一起只加载一次，
    // 所有对象共用.
    private Status(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return NAME;
    }
    
    @Override
    public String toString() {
        return this.NAME;
    }
}
