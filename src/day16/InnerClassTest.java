package day16;


/**
 * 类的内部成员: 内部类
 * 1. Java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B称为外部类
 * 2. 内部类的分类：成员内部类  VS 局部内部类(方法内，代码块内，构造器内)
 *
 * 3. 成员内部类:
 *    > 一方面: 作为外部类的成员
 *    > 可以 被static 修饰
 *    > 可以被 4 种不同的权限修饰
 *    > 另一方面: 作为一个类存在，
 *      > 类内可以定义属性，方法，构造器等
 *      > 可以被final 修饰，表示此类不能被继承，言外之意，不使用final,就可以被继承.
 *      > 可以被 abstract 修饰
 *
 *
 *  成员内部类作为类的成员的角色:
 *  和外部类不同，Inner class 还可以声明为 private 或 protected;
 * 可以调用外部类的结构,
 * inner class 可以声明为 static 的，但此时就不能再使用外层类的非 static 的成员
 * 变量:
 * 成员内部类作为类的角色:
 *  可以再内部定义属性，方法，构造器等结构
 *  可以声明为 absitract类，因此可以被其它的内部类继承
 *  可以声明为fianls的
 * 【注意】
 *  1.非static 的成员内部类中的成员不能声明为 static的，只有在外部类或 static 的成员
 *  2. 成员内部类可以直接使用外部的所有成员，包括私有的数据，注意访问的方式 外部类名.this.属性/方法()(需要注意非静态关系)
 *  3. 外部类访问成员内部类的成员: ，需要“内部类.成员” 或 “内部类对象.成员”
 *  4.当想要在外部类的静态成员部分使用内部类时，可以考虑内部类声明为静态的。
 *  注意: 成员内部类和局部内部类，在编译以后，也会生成字节码文件。
 */
public class InnerClassTest {
    /*
    在局部内部类的方法中(比如: show() 如果调用局部内部类所声明的方法比如(method)中的局部变量比如)
    要求局部变量声明为 final的
     */

    public void method(){
        // 局部变量
        final int num = 10;
        class AA{

            public void show(){
                // Variable 'num' is accessed from within inner class, needs to be final or effectively final
                // num = 20; // 外部中的局部变量，在内部类中的方法中访问的话，其中的局部变量要定义为 final 这是规定。
                System.out.println(num);
            }
        }
    }


    public static void main3(String[] args) {
        // 创建内部类中的实例 （静态的成员内部类）因为是静态的成员，所以可以通过类名直接访问到
        Persons.Dog dog = new Persons.Dog();
        dog.show();

        // 创建内部类中的实例(非静态的成员内部类)
        // 因为不是静态的成员无法通过类名，直接方法创建实例的，所以需要通过虚拟
        // Persons.Bird bird = new Persons.Bird();

        // 通过先一步创建对象，访问非静态的内部类，再new 创建实例对象
        Persons persons = new Persons();
        Persons.Bird bird = persons.new Bird();
        bird.sing();

    }

    // 常见的内部类的使用:
    // 举例: 返回一个实现了 Comparable 接口的类的对象
    public Comparable getComparable() {
        // 创建一个实现了Comparable接口的类: 局部内部类
        class MyComparable implements Comparable{

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

        return new MyComparable();
    }


    // 举例二:
    // 返回一个实现了 Comparable 接口的类的对象
    //通过创建匿名对象的方式
    public Comparable getComparable2(){
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}


class Persons{
    // 成员内部类，局部内部类
    class AA{

    }

    private String name;

    // 静态的成员内部类,
    static class Dog{
        String name;
        int age;

        public void show(){
            System.out.println("内部静态类，方法");
           // eat();  // 内部类,同样需要遵守静态不能直接访问外部类中非静态的属性和方法
        }
    }

    public void eat(){
        System.out.println("外部非静态方法");
    }

    // 非静态成员内部类
    class Bird{
        String name ;
        public Bird() {

        }

        public void sing() {
            System.out.println("Bird : 我是一只小小鸟");
            Persons.this.eat();  // 内部类调用外部类的方式
        }


        public void display() {
            System.out.println(name);
            System.out.println(Persons.this.name);   // 访问外部类中的属性
        }

    }

    {
        // 代码块中的局部类
        class BB{

        }
    }


    public Persons() {
        // 构造器方法中的，局部类
        class CC{

        }
    }
}