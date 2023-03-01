package day33;


import day18.com.RainbowSea.team.domain.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 1.使用情境：当要传递给 Lambda 接口中的方法体的操作，已经有实现的方法了，可以使用方法引用了。
 * 2. 方法引用，本质上就是 Lambda 表达式，而 Lambda 表达式作为函数接口(匿名实现接口重写其抽象方法)的实例，所以方法引用，
 *     也是函数式接口的实例。
 *
 * 3. 使用格式: 类(或对象) :: 方法名
 * 4. 具体分为如下的三种情况:
 *   对象 :: 非静态方法
 *   类 :: 静态方法
 *   类 :: 非静态方法(构造器)
 *   注意： 对象不可以调用静态方法。
 *
 *   方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值与方法引用的方法的 "形参列表和返回值类型相同"
 *
 */
public class MethodRefTest {

    /**
     * 情况一: 对象 :: 实例方法
     * Consumer 中的 void accept(T t)
     * PrintStream 中的 void println(T t)
     */
    @Test
    public void test() {
        // accept(T t) Consumer 接口中的抽象方法只有一个参数，() {} 可以省略
        Consumer<String> con = str-> System.out.println(str);
        con.accept("北京");


        // 方法引用:
        PrintStream printStream = System.out;
        Consumer<String> con2 = printStream::println;  // 没有参数，参数推断出来了。
        // 没有参数的原因是，
        /*
        public void println(String x) {
        synchronized (this) {
            print(x);
            newLine();
        }
        void accept(T t);  该接口中的抽象方法是一致的。所以该参数，可以省略。
    }
         */

        con2.accept("beijing");
    }


    /**
     * Supplier 中的 T get()
     * Employee 中的String getName()  两者的方法结构是一样的。
     */
    @Test
    public void test2() {

        Employee emp = new Employee(1001,"Tom",23,5600);
        // Lambda 表达式，无参数，一个返回值，一条语句。 {} return 可以省略
        Supplier<String> sup1 = () -> emp.getName();   // 匿名实现了该 Supplier的接口 get() 抽象方法中调用的是 emp.getNmae()方法
        System.out.println(sup1.get());


        // 方法引用
        Supplier<String> sup2 = emp::getName;   // 在 Supplier 接口中的 get() 方法中调用的是 getName() 方法
        // 两者之间的结构一致

        System.out.println(sup2.get());
    }


    /**
     * 情况二: 类 :: 静态方法
     * Comparator 中的 int compare(T t1,T t2)
     * Integer 中的 int compare(T t1,T t2) 两者之间的结构一致
     */
    @Test
    public void test3() {
        // Lambda 表达式
        Comparator<Integer> com1 = (t1,t2)->Integer.compare(t1,t2);  // Comparator 中调用了 Integer.compare()方法

        System.out.println(com1.compare(21, 12));

        // 方法引用
        Comparator<Integer> com2 = Integer::compareTo;  // Comparator 接口 中的 compare() 抽象方法和 Integer.compare() 方法的结构一致。

        System.out.println(com2.compare(12, 21));



    }


    /**
     * Function  中的 apply(T t)
     * Math 中的 Long round(Double d)  // 四舍五入
     *   两个方法的结构一致。
     */
    @Test
    public void test4() {

        // Lambda 表达式 一个参数，一条语句一个返回值。() {} 可以省略
        Function<Double,Long> func1 = d->Math.round(d);
        System.out.println(func1.apply(12.3));

        // 方法引用 Function 接口中重写的 apply() 抽象方法中调用了 Math.round()方法
        Function<Double,Long> func2 = Math::round;

        System.out.println(func2.apply(12.9));
    }


    /**
     * 情况三: 类 :: 实例方法
     * Comparator 中的 int comapre(T t1, T t2)
     * String 中的 int t1.compreTo(t2) 两者之间的方法结构一致的
     */
    @Test
    public void test5() {
        // Lambda 表达式
        Comparator<String> com1 = (t1,t2)->t1.compareTo(t2);
        System.out.println(com1.compare("abc", "abc"));

        Comparator<String> com2 = String::compareTo;  // Comparator 接口中的 comapre()抽象方法中
        // 实际调用的是 String compreTo()方法，两者之间的方法是结构是一致的
        System.out.println(com2.compare("abc", "abd"));
    }

    /**
     * BiPredicate 中的 boolean test(T t1, T t2) ;
     * String 中的 boolean t1.equals(t2)
     */
    @Test
    public void test6(){
        // Lambda 表达式
        BiPredicate<String,String> pre1 = (t1,t2)->t1.equals(t2);
        System.out.println(pre1.test("abc", "abc"));

        // 方法引用
        BiPredicate<String,String> pre2 = String::equals;
        boolean test = pre2.test("abc", "aac"); // BiPredicate 接口中的 comapre()抽象方法中实际上
        // 调用的是 String equals()方法，两者之间的方法的结构是一致的。
        System.out.println(test);
    }

    /**
     * Function 中的 R apply(T t)
     * Employee 中的 String getName(); 两者方法的结构是一致的
     */
    @Test
    public void test7() {

        Employee employee = new Employee(1001,"Jerry",23,60000);
        // Lambda 表达式
        Function<Employee,String> fun1 = e->e.getName();  //一个参数，一条语句，一个返回值 () {} 可以省略
        System.out.println(fun1.apply(employee));

        // 方法引用
        Function<Employee,String> fun2 = Employee::getName; // Function 接口中的 apply()抽象方法
        // 实际上在该重写的抽象方法中调用的是 Employee 类中的 getName()方法。

        System.out.println(fun2.apply(employee));
    }
}
