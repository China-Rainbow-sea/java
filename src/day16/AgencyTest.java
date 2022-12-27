package day16;

/**
 * 代理模式:
 */
public class AgencyTest {
    public static void main(String[] args) {
        Stars stars = new Proxys(new RealStars());
        stars.confer();
        stars.signContract();
        stars.bookTicket();
        stars.sing();
        stars.collectMoney();
    }
}


interface Stars{
    public abstract void confer();// 面谈

    public abstract void signContract();// 签合同

    public abstract void bookTicket();// 订票

    public abstract void sing();// 唱歌

    public abstract void collectMoney();// 收钱
}


class RealStars implements Stars{

    @Override
    public void confer() {

    }

    @Override
    public void signContract() {

    }

    @Override
    public void bookTicket() {

    }

    @Override
    public void sing() {
        System.out.println("歌手唱歌");
    }

    @Override
    public void collectMoney() {

    }
}


class Proxys implements Stars{
    private RealStars realStars;

    public Proxys(RealStars realStars) {
        this.realStars = realStars;   //
    }

    public void confer() {
        System.out.println("经纪人面谈");
    }

    public void signContract() {
        System.out.println("经纪人签合同");
    }

    public void bookTicket() {
        System.out.println("经纪人订票");
    }

    public void sing() {
        // 调用另外真正代理的歌手重写的 sing()方法
        this.realStars.sing();
    }

    public void collectMoney() {
        System.out.println("经纪人收钱");
    }


}
