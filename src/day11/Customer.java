package day11;

/**
 * Customer为实体类，用来封装客户信息
 */
public class Customer {
    private String name;    // 客户姓名
    private char gender;  // 性别
    private int age;        // 年龄
    private String phone;   // 电话号码
    private String email;   // 电子邮箱

    public Customer(){
        // 无参构造器,构造器的权限; public ,缺省,不可以是 private 一般和类的权限是一样的
    }

    public Customer(String name,char gender,int age,String phone,String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone  = phone;
        this.email = email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


/*
String name ：客户姓名
char gender  ：性别
int age          ：年龄
String phone：电话号码
String email ：电子邮箱

 */