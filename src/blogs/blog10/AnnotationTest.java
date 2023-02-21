package blogs.blog10;


import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args) {
        Method method = null;

        try {
            // 获取类加载器，类对象
            Class clazz = Class.forName("blogs.blog10.AnnotationTest"); // 全类路径名

            // 获取 fun()方法
            method = clazz.getDeclaredMethod("fun");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 判断该方法是否存在该注解，存在才读取该注解上的属性值
        if(method.isAnnotationPresent(MyAnnotation.class)) {
            // 获取该注解对象
            MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
            // // 获取该注解的属性值，就像对象.属性一样
            String value = annotation.value();
            System.out.println(value);
        }

    }

    @MyAnnotation("lihua")
    public void fun() {
        int num = 0;
    }

}



