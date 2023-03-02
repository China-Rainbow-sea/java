package day33;

import day33.Boy;
import day33.Girl;
import org.junit.Test;

import java.util.Optional;

/**
 * Optional 提供很多有用的方法，这样我们就不用显式进行空值检测
 */
public class OptionalTest {
    /**
     * 创建 Optional 的对象的三种方式
     * Optional.of(T t) 创建一个Optional 实例， t 必须非空
     * Optional.empty() 创建一个空的 Optional 实例
     * Optional.ofNullable(T t) t 可以为 null
     */
    @Test
    public void test() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optional = Optional.of(girl);  // of(T t) t不可以为空
    }


    /**
     * ofNullable(T t) t 可以为null
     */
    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optional = Optional.ofNullable(girl);
        System.out.println(optional);
    }


    /*public String getGirName(Girl girl) {
        return girl.getBoy().getName();
    }*/


    // 优化后
    public String getGirName(Girl girl) {
        if(girl != null) {
            Boy boy = girl.getBoy();

            if(boy !=null) {
                return girl.getName();
            }
        }

        return null;
    }

    @Test
    public void test3() {
        Girl girl = new Girl();
        String girName = getGirName(girl);  // null

    }


    // orElse(T t) 如果单前的 Optional 内部封装的t是非空的，则返回内部的 t,
    // 如果内部的 t是空的，则返回orElse()方法中的参数t1.
   @Test
    public void test4() {
       Girl girl = new Girl();
       girl = null;

       Optional<Girl> optional = Optional.ofNullable(girl);
       System.out.println(optional);

       Girl girl1 = optional.orElse(new Girl("赵丽颖"));
       System.out.println(girl1);
   }

   // 使用 Optional 类的 getGirName()
    public String getGirName2(Girl girl) {
        Optional<Girl> optional = Optional.ofNullable(girl);
        // 如果 Optional 中的 girl 为 null ，则使用 如下的 new Girl(new Boy("肖战")) 替换就不为空了
        // 不为 null 是不会发生替换的，使用原来的就可以了。
        Girl girl2 = optional.orElse(new Girl(new Boy("肖战")));
        Boy boy = girl2.getBoy();

        /*Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy("王一博"));*/

        return boy.getName();
    }

    //
    @Test
    public void test5() {
        Girl girl = null;
        String girName2 = getGirName2(girl);
        System.out.println(girName2);

        Girl girl2 = new Girl(new Boy("王一博"));
        String girName = getGirName2(girl2);
        System.out.println(girName);

    }


}
