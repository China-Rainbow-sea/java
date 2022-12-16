package day14;

import java.util.Date;
import java.util.Objects;

/*
== 和 equals 的区别
1. == 既可以比较基本数据类型也可以比较引用类型,对于基本数据类型就是比较值，对于引用类型就是比较
内存的地址
2. equals的话,它是属于java.lang.Object 类里面的方法,如果该方法没有被重写过默认也是 == ,
我们可以看到 String 等类的 equals的方法是被重写的过的,而且String 类在日常开发中用的比较多,
久而久之,形成了equals是比较值的错误观点.
3. 具体要看自定义类里面有没有重写Object的equals方法来进行判断
4. 通常情况下,重写equals方法,会比较类中相应属性是否都相等.
 */
public class EqualsTest {

    public static void main(String[] args) {
        int it = 65;
        float fl = 65.0f; // 注意在Java当中 小数默认是 double 类型的,对于float后追加上一个f

        System.out.println("65和65.of 是否相等:"+(it == fl));  // true

        char ch1 = 'A';
        char ch2 = 12;
        System.out.println("65和 A是否相等: "+(ch1 == it));  // true
        System.out.println("12 和 ch2 是否相等: "+(12 == ch2));  // true

        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println("str1 和 str2 是否相等: "+(str1 == str2));  // 比较的是地址 false

        System.out.println("str1 是否equals str2 ："+(str1.equals(str2)));  // true

        //System.out.println("hello" == new java.util.Date());  // 编译不通过,类型不一致




    }


    /**
     * == 运算符
     * 1.可以使用在基本数据类型变量和引用数据类型变量中
     * 2.如果比较的是基本数据类型变量，比较两个保存的数据是否相等.(不一定类型要相同)
     * 3.如果比较的是引用数据类型变量，比较的是两个对象的地址是否相同，即两个引用是否指向同一个对象的实体
     * 4. 特殊的 String 字符串常量池
     * 5. == 符合使用时，必须保证符合左右两边的变量类型一致,包括“自动转换”
     * @param args
     */
    public static void main2(String[] args) {
        int i = 10;
        int j = 10;
        double d = 10.0;

        System.out.println(i == j); // true;
        System.out.println( i == d); // ture

        boolean b = true;
        // System.out.println(i == b); // 报错,两者比较的类型不一致


        char c = 10;
        System.out.println( i == c);  // true;

        char c1 = 'A';
        char c2 = 65;
        System.out.println(c1 == c2);  // true;

        System.out.println("***********************");

        Customer c3 = new Customer("Tom",18);
        Customer c4 = new Customer("Tom",18);
        System.out.println( c3 == c4);   // 比较的是实例对象的地址

        System.out.println("************************");

        String str1 = new String("Tom");
        String str2 = new String("Tom");
        System.out.println(str1 == str2);  // 比较的是实例对象的地址


        System.out.println("*****************************");

        String str3 = "Tom";
        String str4 = "Tom";
        System.out.println(str3 == str4);   // 特殊的字符串常量池,


    }


    /**
     *  Object.equals()方法的使用
     *  1. equals() 是 Object 类中的一个方法，所有类都继承了这个方法
     *  2.只适用于引用数据类型,因为 equals是 Object 类中的一个方法而已,基本数据类型无法调用Object中的方法(包装类可以)
     *  3.Object 类中 equals()的定义
     *  public boolean equals(Object obj) {
     *         return (this == obj);
     *     }
     * 4.说明Object 定义的equals()和 == 的作用是一样的:比较的是对象的地址,是否指向同一个对象
     * 5. 像 String,Date,File 包装类等重写了Object类中的equals()方法,重写以后，比较的就不是
     * 两个引用的地址了。而是比较两个对象的实体内容的值是否相同，根据实际情况比较.
     * 6. 通常情况下,我们自定义的类如果使用 equals()的话,也通常是比较两个对象的"实体内容"是否相同,那么
     * 我们就需要重写 Object类中的equals()方法
     */
    public static void main3(String[] args) {
        Customer c1 = new Customer("Tom",18);
        Customer c2 = new Customer("Tom",18);

        System.out.println(c1.equals(c2));   // false
        // 没有重写 equals的方法，调用的是 Object 中的 equals方法
        /*
        public boolean equals(Object obj) {
        return (this == obj);
        }
         */

        String str1 = new String("Tom");
        String str2 = new String("Tom");
        System.out.println(str1.equals(str2));  // true
        // 调用的是String 类重写的 equals 方法
        /*
        public boolean equals(Object anObject) {
            if (this == anObject) {  // 判断是否是指向同一个对象,是返回 true:因为都指向同一个对象了,就已经相同的了
                return true;
            }
            if (anObject instanceof String) {  //判断 anObject 是否是 String的对象的实例/子类,
                String anotherString = (String)anObject;  // 是,才强制向下转型()防止报错
                int n = value.length;
                if (n == anotherString.value.length) {  // 比较它们两之间的长度是否相等,不相等返回false
                    char v1[] = value;
                    char v2[] = anotherString.value;
                    int i = 0;
                    while (n-- != 0) {     // 从后往前一一比较判断是否相等,凡是有一个不相等的返回false
                        if (v1[i] != v2[i])
                            return false;
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }
         */

        System.out.println("**************************");
        Date date1 = new Date(32432525324L);   // Date 时间类型,该Date类型无法存储在Mysql中的DateTime类型(可以用字符串)
        Date date2 = new Date(32432525324L);
        System.out.println(date1.equals(date2));  // 比较的是内容，返回 true
        // 调用的是重写了 Date 类中的 equals的方法
        /*
        public boolean equals(Object obj) {
        return obj instanceof Date && getTime() == ((Date) obj).getTime();
        }
         */
    }
}



class Customer{
    private String name;
    private int age;

    public Customer() {
        // 无参构造器
    }

    public Customer(String name,int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 重写equals方法
    /*@Override
    public boolean equals(Object obj) {
        System.out.println("Customer 重写的equals ");
        if(this == obj) {  // 判断是否是指向同一个对象的引用
            return true;
        }

        if(obj instanceof Customer) { // 判断obj是否是 Customer的实例/子类
            Customer customer = (Customer)obj;  // 强制向下转型

            // 判断对应属性的值内容是否相等.
            return this.age == customer.age && this.name == customer.name;

        } else {
            return false;
        }
    }*/


    /**
     * 重写equals 的一些原则
     * 1.对称性: 如果x.equals(y)返回是 true,那么y.equals(x)也应该返回的是 true
     * 2.自反性: 如果x.equals(x)必须返回的是 true
     * 3.传递性: 如果x.equals(y)返回的是 true，而且y.equals(x) 返回y.equals(x)返回是 true,那么x.equals
     * 那么，z.equals(x)也应该返回的是 true
     * 4.一致性: 如果 x.equals(y)返回是 "true" ,只要x和y 内容一直不变,不管你重复x.equals(y)多少次,
     * x.equals多少次，返回都是 true
     * 5.任何情况下,x.equals()，永远返回是 false,x.equals()和 x不同类型的对象,永远返回的是 false
     * 因为  if(object instanceof x ) else return false;
     * @param o 比较判断对象
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getAge() == customer.getAge() &&
                Objects.equals(getName(), customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
