package blogs.blog11;


/**
 * 获取Class 对象的三种方式
 */
public class ReflectTest01 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            Class<String> clazz2 = String.class;
            System.out.println(clazz == clazz2);  // true

            // 因为每个类只有一个 Class 对象，类只会加载一次到内存当中，并只生成一份 .class 文件
            // 所有对象共用。

            Class clazz3 = Class.forName("blogs.blog11.User");
            Class clazz4 = User.class;
            System.out.println(clazz3 == clazz4);  // 返回 true

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void main4(String[] args) {
        // 会执行blogs.blog11.User 类中的静态代码块，而不会创建器实例化对象(不会调用该类的构造器)
        Class clazz = null;
        try {
            clazz = Class.forName("blogs.blog11.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz);
    }

    public static void main3(String[] args) {
        try {
            Class<?> clazz = Class.forName("blogs.blog11.User");
            System.out.println(clazz);

            Class<?> clazz2 = Class.forName("java.lang.String");
            System.out.println(clazz2);

            Class clazz3 = Class.forName("java.lang.Integer");
            System.out.println(clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void main2(String[] args) {
        User user = new User();
        // <? extends User >上界通配符
        Class<? extends User> aClass = user.getClass();
        System.out.println(aClass);

        String s = new String();
        Class<? extends String> aClass2 = s.getClass();
        System.out.println(aClass2);

        Integer integer = new Integer(123);
        Class aClass3 = integer.getClass();
        System.out.println(aClass3);


    }

    public static void main1(String[] args) {
        // <User> 泛型
        Class<User> userClass = User.class;
        System.out.println(userClass);

        // <String> 泛型
        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        //这里自动装箱了
        Class integerClass = int.class;
        System.out.println(integerClass);


    }
}

class User {
    String name;

    public User() {

    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}