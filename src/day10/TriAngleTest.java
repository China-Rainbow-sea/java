package day10;

/*
赋值的顺序：
1.默认初始化
2.显式初始化
3.构造器初始化
4.通过 "对象.方法 / 对象.属性"的方式,赋值、

               javaBean
 javaBean是一种Java语言写成的可重用组件。
 所谓的javaBean，是指符合如下标准的java 类
 > 类是公共的
 > 有一个无参的公共的构造器
 > 有属性,且有对应的get,set 方法
 用户可以使用javaBean将功能,处理,值,数据库访问和其他任何可以用java代码创造的对象进行打包,并且其他的开发
 者可以通过内部的jsp页面,servlet ，其他javaBean,applet 程序或者应用来使用这些对象。用户可以认为javaBean提供了
 一种随时随地的赋值和粘贴的功能,而不用关心任何改变。
 */
public class TriAngleTest {
    public static void main(String[] args){
        TriAngle triAngle = new TriAngle(3,4); // 调用含有两个参数的构造器,创建对象
        System.out.println(triAngle.area());
    }
}
