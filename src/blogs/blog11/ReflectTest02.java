package blogs.blog11;

public class ReflectTest02 {
    public static void main(String[] args) {
        try {
            // Java内置的 String 类型
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            // 自定义的类引用类型
            ClassLoader classLoader2 = Class.forName("blogs.blog11.Test").getClassLoader();
            System.out.println(classLoader2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main1(String[] args) {
        // 对于自定义类，使用的是系统类加载进行加载的
        ClassLoader classLoader = ReflectTest02.class.getClassLoader();

        // 调用对应类中父类中的getParent(): 获取扩展类加载器
        ClassLoader classLoaderParent = classLoader.getParent();

        // 调用扩展类加强器到getParent(): 是无法获取引导类加载器
        // 引导类加载器主要负责： 加载Java的核心类型，无法加载自定义类的
        // 所以一般是返回 null 的。我们无法获取到的。
        ClassLoader parent = classLoaderParent.getParent();
        System.out.println(parent);
    }
}

class Test {
    public int num = 0;

    public Test() {

    }

    @Override
    public String toString() {
        return "Test{" +
                "num=" + num +
                '}';
    }
}
