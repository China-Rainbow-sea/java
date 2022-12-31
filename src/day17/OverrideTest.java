package day17;


import java.io.IOException;

/**
 * 方法重写的规则之一:
 *  子类重写的方法抛出的异常类型 <= 父类被重写的方法抛出的异常类型
 *  因为: 如果子类所抛出的异常类型 大于 父类被重写的异常类型，父类编译时异常处理时(因为多态性，运行才知道结果)，
 *  就无法处理比子类所抛出的更大的异常了.
 *
 *  // 注意的是: 子类重写的方法，可以不抛出异常，因为是 <= 吗，也可以无限没有。
 *
 *    3.1 如果父类中被重写的方法没有 throws方式处理异常，则子类重写的方法也不能使用throws，意味着如果
 *    子类重写的方法中有异常，必须使用 try-catch-finally (实际上处理的是编译异常。)
 *
 *    4. 如果一个方法2(其中存在编译异常)中并存在返回值，调用另外一个方法1(该方法也有编译异常)并有返回值，
 *      方法1是调用方法2中的返回值，进行处理的话，其中的方法1调用方法2中存在传递关系，则其中方法2
 *      的异常处理，不能使用 tru-catch-finally 将异常彻底处理了，而是使用 throws 抛出异常的方式处理，
 *      交给方法1的调用者处理，因为方法1是通过方法2 的返回值进行处理的，如果方法2 “捕获”到了异常没有返回值了，
 *      则方法1就无法得到方法2的返回值的，从而也出错了。
 *
 *
 *   5. 执行方法中，先后又调用了另外的几个方法，这几个方是递增传递的关系执行的，我们建议
 *   这几个方法使用 throws(向上抛出异常交给调用者处理(使用 try-catch-finally 彻底处理))
 *
 */

public class OverrideTest {
}


class SuperClass {
    public void method() throws IOException {

    }

}

class SubClass extends SuperClass {
    @Override
    /*public void method() {
        System.out.println("子类可以不抛出异常，因为是 <=");
    }*/

    // 也可以抛出异常
    public void method() throws IOException{
       /* method()' in 'day17.SubClass' clashes with 'method()' in
    'day17.SuperClass'; overridden method does not throw 'java.lang.Exception'*/
    }
}