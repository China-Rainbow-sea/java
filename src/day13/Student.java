package day13;

public class Student extends Person{

    String major;

    public Student(){

    }

    public Student(String major) {
        this.major = major;
    }

    // 子类独有的方法
    public void study() {
        System.out.println("学习，专业是: "+this.major);
    }

    // 对父类中的eat()方法进行重写(覆盖)
    public void eat() {
        System.out.println("学生应该多吃有营养的食物");
    }


    public void show() {
        System.out.println("一个学生");
    }

    // 父类   子类
    // 缺省    public
    // 缺省    缺省
    // protected protected
    // protected public
    // protected 缺省的,不可以
    // private   public  虽然表面上是重写了父类的方法,但实际上并没有重写父类中private私有的方法,只是子类自己定义了一个和父类权限修饰符不同的一样的方法而已.
    // 这一点需要注意到.
    // 父类的返回类型是 void ，子类的返回类型是int,两者的返回类型不一致,不是重写/覆盖方法.
     public int test() {
        System.out.println("子类");
        return 0;
    }

/*
    // 子类与父类的类型不一致,无法重写/覆盖父类中的方法
    public int info() {
        return 0;
    }

    // 同样的double 类型 与 int 类型之间不是同一个类型，只是会发生类型的转换而已,同样无法重写/覆盖父类
    public float info1() {
        return 0;
    }
*/


    public static void info3() {
        // 静态方法是不可以重写的,因为静态方法是和类一起加载到堆区当中的,尤其仅有一份。
    }


}
