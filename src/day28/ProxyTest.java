package day28;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类:
 */
public class ProxyTest {
    @Test
    public void test() {
        SuperMan superMan = new SuperMan();
        // proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getFroxyInstance(superMan);
        proxyInstance.getBelief();
        proxyInstance.eat("四川麻辣烫");
    }
}


// 代理类
class ProxyClothFactorys implements  Human {
    private ClothFactory factory; // 用被代理类对象进行实例化

    public ProxyClothFactorys(ClothFactory factory) {
        this.factory = factory;
    }

    public ProxyClothFactorys() {
        // 无参构造器,用于反射上的使用
    }

    @Override
    public String getBelief() {
        return null;
    }

    @Override
    public void eat(String food) {

    }
}


// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

// 代理类和被代理类都需要实现该接口,代理类 与 被代理类的联系桥梁
interface Human {
    String getBelief();
    void eat(String food);
}


/*
想要实现动态代理:需要解决的问题: ??
问题一: 如何根据加载到内存中的被代理类,动态的创建一个代理类及其对象.
问题二: 当通过代理类的对象调用方法时,如何动态的去调用被代理类中同名方法.
 */

class ProxyFactory {
    // 调用此方法,返回一个代理类的对象,解决问题一
    public static Object getFroxyInstance(Object object) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;  // 需要使用被代理类的对象进行赋值

    public void bind(Object object) {
        this.obj = object;
    }

    // 当我们通过代理类的对象,调用方法a时,就会自动的调用如下的方法: invoke()
    // 将被代理类要执行的方法 a 的功能就声明在 invoke()中.
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method: 即为代理对象调用的方法,此方法也就作为了被代理类对象要调用的方法
        // obj 被代理的对象
        Object invoke = method.invoke(obj, args);
        // 上述方法的返回值就作为当前类中的 invoke()的返回值
        return invoke;
    }
}