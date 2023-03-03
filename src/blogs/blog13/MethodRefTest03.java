package blogs.blog13;

import day18.com.RainbowSea.team.domain.Employee;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodRefTest03 {
    /**
     * Function 中的 R apply(T t)
     * Employee 中的 String getName(); 两者方法的结构是一致的
     */
    public static void main(String[] args) {
        Employee employee = new Employee(1001,"Jerry",23,60000);

        // 匿名实现接口
        Function<Employee,String> function = new Function<Employee, String>() {
            @Override
            public String apply(Employee employee) {
                return employee.getName();
            }
        };
        String apply = function.apply(employee);  // 调用 Function 接口中的 重写的apply()抽象方法
        System.out.println(apply);

        // Lambda 表达式
        Function<Employee,String> function2 = e->e.getName();  //一个参数，一条语句，一个返回值 () {} 可以省略
        String apply2 = function2.apply(employee);  // 调用 Function 接口中的 重写的apply()抽象方法
        System.out.println(apply2);

        // 方法引用
        Function<Employee,String> function3 = Employee::getName; // Function 接口中的 apply()抽象方法
        // 实际上在该重写的抽象方法中调用的是 Employee 类中的 getName()方法。
        String apply3 = function3.apply(employee);  // 调用 Function 接口中的 重写的apply()抽象方法
        System.out.println(apply3);
    }

    /**
     * BiPredicate 中的 boolean test(T t1, T t2) ;
     * String 中的 boolean t1.equals(t2)
     */
    public static void main2(String[] args) {
        // 匿名实现接口的方式：
        BiPredicate<String,String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s);
            }
        };
        boolean test = biPredicate.test("ab", "ab"); // 调用BiPredicate接口中的 test()抽象方法
        System.out.println(test);


        // Lambda 表达式
        BiPredicate<String, String> biPredicate2 = (s1, s2) -> s1.equals(s2);
        boolean test2 = biPredicate2.test("ab", "ab"); // 调用BiPredicate接口中的 test()抽象方法
        System.out.println(test2);


        // 方法引用
        BiPredicate<String,String> biPredicate3 = String::equals;
        boolean test3 = biPredicate3.test("ab", "ab");
        System.out.println(test3);

    }

}
