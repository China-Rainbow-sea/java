package day18.com.RainbowSea.team.service;


/**
 * 自定义异常类，编译异常
 */
public class TeamException extends Exception{
    static final long serialVersionUID = 33875169931222998L;  // 序列号

    public TeamException() {
        super(); // 调用父类的无参构造器
    }

    public TeamException(String mag) {
        super(mag);    // 调用父类的构造器
    }
}
