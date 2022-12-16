package day14;

import org.junit.Test;

import java.util.Date;

/*
测试单元
在需要单元测试的方法中，写上@Test,并在单元测试类中导入: impost org.junit.Test
加载时: 1.如果执行结果没有任何异常,绿条
        2. 如果执行结果出现异常，红条.

 */
public class JunitTest {

    @Test
    public void testEquals() {
        System.out.println("test1");
        String str = new String("hello");
        Object object = (Object)str;
       // Date date = (Date)object;  // 红条,报ClassCastException 类异常。
        // String 与 Date 类没有子类关系，也不是实例对象的关系.无法编译没有问题，但是运行异常.
    }

    @Test
    public void testEquals2() {
        System.out.println("test2");
    }
}
