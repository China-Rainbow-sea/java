package blogs.blog13;


import java.util.Optional;

public class OptionalTest {
    // orElse(T t) 如果单前的 Optional 内部封装的t是非空的，则返回内部的 t,
    // 如果内部的 t是空的，则返回orElse()方法中的参数t1.
    // 使用 Optional 类的 getGirName()
    public static String getGirName2(Girl girl) {
        Optional<Girl> optional = Optional.ofNullable(girl);
        // 如果 Optional 中的 girl 为 null ，则使用 如下的 new Girl(new Boy("肖战")) 替换就不为空了
        // 不为 null 是不会发生替换的，使用原来的就可以了。
        Girl girl2 = optional.orElse(new Girl(new Boy("肖战")));
        Boy boy = girl2.getBoy();

        /*Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy("王一博"));*/

        return boy.getName();
    }

    public static void main(String[] args) {
        Girl girl = null;
        String girName2 = getGirName2(girl);
        System.out.println(girName2);

        Girl girl2 = new Girl(new Boy("王一博"));
        String girName = getGirName2(girl2);
        System.out.println(girName);

    }

    public static void main2(String[] args) {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optional = Optional.ofNullable(girl);  // ofNullable 中的 t 参数可以为空
        System.out.println(optional);
    }
}


class Girl {

    public int age;
    public String name;
    public Boy boy;


    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public Girl(Boy boy) {
        this.boy = boy;
    }

    public Girl(int age, String name, Boy boy) {
        this.age = age;
        this.name = name;
        this.boy = boy;
    }

    public void Girl() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boy getBoy() {
        return boy;
    }

    public void setBoy(Boy boy) {
        this.boy = boy;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", boy=" + boy +
                '}';
    }
}


class Boy {
    String name;

    public Boy() {
    }

    public Boy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                '}';
    }
}

