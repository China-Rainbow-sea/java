package day28.Reflection;

@MyAnnotation("hi") // 当注解中只有 value属性值时可以省略 value说明
public class Person extends Creature<String> implements Comparable<String>,MyInterface {
    private String name;
    int age;
    public int id;

    public Person(){
        // 无参构造器
    }

    @MyAnnotation("abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是: " + nation);

        return nation;
    }

    public static String disPlay(String interests) {
        return interests;
    }


    @Override
    public void info() {
        System.out.println("我是一个人");
    }


    /**
     * 比较器
     * @param o
     * @return
     */
    @Override
    public int compareTo(String o) {
        return 0;
    }
}
