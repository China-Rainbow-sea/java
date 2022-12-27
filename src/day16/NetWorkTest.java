package day16;

/**
 * 接口的应用: 代理模式
 */
public class NetWorkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer p  = new ProxyServer(server);
        p.browse();

    }
}


interface NetWork{
    // 抽象方法
    public abstract void browse();
}

// 代理类
class ProxyServer implements NetWork{
    private NetWork work;


    public ProxyServer(NetWork netWork) {
        this.work = netWork;
    }

    public void check(){
        System.out.println("联网之前的检查工作");
    }

    @Override
    public void browse(){
        check();
        work.browse();   // 调用子类重写的对应的抽象方法
    }

}

// 被代理类
class Server implements NetWork{
    @Override
    public void browse(){
        System.out.println("真实的服务器访问网络");
    }
}