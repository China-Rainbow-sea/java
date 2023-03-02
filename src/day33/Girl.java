package day33;

public class Girl {
    public int age;
    public String name;
    public Boy boy;


    public void Girl() {

    }

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
