package day28;

import org.junit.Test;

/**
 * 动态代理模式
 */
public class StaticProxyTest {

    /**
     * 静态代理类举例:
     * 特点: 代理类和被代理类在编译期间,就确定下来了.
     */
    @Test
    public void test() {
        // 创建被代理类的对象
        ClothFactory nike = new NikeClothFactory();

        // 创建代理类的对象
        ClothFactory proxy =  new ProxyClothFactory(nike);

        proxy.produceCloth();

    }

}


/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory {

    private ClothFactory factory; // 用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

/**
 * 被代理类
 */
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike 工厂生产一批运动服");
    }
}

interface ClothFactory {
    public void produceCloth();
}
