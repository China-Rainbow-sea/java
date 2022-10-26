package day10;

public class exercise1 {
    public static void main(String[] args){
        Boy boy = new Boy();
        boy.setName("李华");
        boy.setAge(18);
        Girl girl = new Girl();
        girl.setName("小红");
        girl.setAge(18);

        boy.marry(girl);
        girl.marry(boy);
        girl.compare(boy);
    }
}

class Boy{
    private String name;
    private int age;

    public Boy(){ // 空构造器

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void marry(Girl girl){
        System.out.println(this.name+"想娶"+girl.getName());
    }

    public void shout(){
        System.out.println("你好，世界");
    }

}


class Girl{
    private String name;
    private int age;

    public Girl(){  // 空构造器

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

    public void marry(Boy boy){
        System.out.println(this.name+"想嫁给"+boy.getName());
    }

    public void compare(Boy boy){
        if(boy.getAge() > this.age){
            System.out.println(boy.getName()+"比我大:"+(boy.getAge()-this.age)+"岁");
        } else if(boy.getAge() < this.age){
            System.out.println(boy.getName()+"比我小:"+(this.age - boy.getAge())+"岁");
        } else{
            System.out.println("我们的一样大");
        }

    }




}


