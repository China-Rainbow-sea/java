package day1;

public class Person {
    String name;  // 成员变量,存在初始值这里为 null
    int age = 1;
    boolean isMale; // 成员变量,boolean 默认初始值为 false

    // 方法,成员方法
    public void eat(){
        System.out.println("吃饭");
    }

    public void sleep(){
        System.out.println("休息");
    }

    public void talk(String language){
        System.out.println("他说话的语言是"+language);
    }



    /*
    说明: 返回值类型
    如果方法中定义了返回值,则必须在方法声明时，指定返回值的类型，
    同时必须在方法中有return返回值.(注意如果是 if返回值,必须指明 else 不满足
    条件时也要有return ,不然如果没有满足if条件的话,就没有return返回值了,
    一定要记住一点存在返回值，就一定要return无论什么情况)
    如果方法没有返回值,则方法声明时,使用void表示,如果要使用返回值的话就
    只能"return;"表示结束此方法的意思
    注意：return关键字后面的不可以声明执行的语句,因为遇到return就返回了,后面的
    语句不会被执行的。
    方法中，可以调用当前类的属性或方法
    方法中，不可以再创建方法
     */
    public String judgeAge(){
        if(this.age >= 18){
            return "成年了";
        }else {
            return "未成年";
        }
    }


}