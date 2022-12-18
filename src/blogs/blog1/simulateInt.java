package blogs.blog1;

public class simulateInt {
    // 将基本数据类型转换为字符串: 使用字符串.valueOf()的方法
    public static void main(String[] args) {
        int num = 12;
        String str1 = String.valueOf(num);  // 将 int 转换为 String
        System.out.println(num);

        float f = 3.1415926f;
        String str2 = String.valueOf(f);    // 将 float 转换为 String
        System.out.println(str2);

        Double d = new Double(3.14);
        String str3 = String.valueOf(d);   // 将包装类Double 转换为 String
        System.out.println(str3);


    }


    // 将基本数据类型转换为 字符串方式一: 使用 "+" 拼接上
    public static void main8(String[] args) {
        int num1 = 10;
        String str = num1 +"";
        System.out.println(str);
    }


    // String 转换为 包装类/基本数据类型
    // 使用 包装类.pasexxx()
    public static void main7(String[] args) {
        String str = "true";
        Boolean b = Boolean.parseBoolean(str);
        System.out.println(b.toString());
        boolean b2 = Boolean.parseBoolean(str);
        System.out.println(b2);

        String str2 = "true hello";
        Boolean b3 = Boolean.parseBoolean(str2);  // 不是 true/false 一律false返回
        System.out.println(b3.toString());
        boolean b4 = Boolean.parseBoolean(str2);
        System.out.println(b4);


    }

    // String 转换为 包装类/基本数据类型
    // 使用 包装类.pasexxx()
    public static void main6(String[] args) {
        // 整数
        String str = "123";
        Integer integer = Integer.parseInt(str);
        System.out.println(integer.toString());
        int num = Integer.parseInt(str);
        System.out.println(num);

        // 浮点数
        String str2 = "3.1415926";
        Double d = Double.parseDouble(str2);
        System.out.println(str2.toString());
        double d2 = Double.parseDouble(str2);
        System.out.println(d2);




    }

    // 自动拆箱 和 自动装箱
    public static void main5(String[] args) {
        int num = 10;
        Integer i1 = num;  // 自动装箱 ： 将基本数据类型 转换为 包装类
        System.out.println(i1 + 1);
        System.out.println(i1.toString());

        int num2 = i1;     // 自动拆箱：将包装类转换为 基本数据类型
        System.out.println(num2 + 1);
//        num2.toString;  不是类无法点出

        Boolean b = true;  // 自动装箱
        System.out.println(b);
        boolean b2 = b;    // 自动拆箱
        System.out.println(b2);
    }

    // 包装类   ————> 基本数据类型
    // 使用 包装类的xxxValue()方法
    public static void main4(String[] args) {
        Integer i1 = new Integer(18);
        int num = i1.intValue();
        short num2 = i1.shortValue();
        double d = i1.doubleValue();

        System.out.println(num);
        System.out.println(num2);
        System.out.println(d);

    }



    // 基本数据类型 --> 包装类
    public static void main3(String[] args) {
        Integer integer = new Integer(null);
        System.out.println(integer);
    }



    public static void main2(String[] args) {
        Boolean b = new Boolean("true hhh");
        System.out.println(b);
        Boolean b2 = new Boolean(null);
        System.out.println(b2);



//        Integer integer = new Integer("123abc");
//        System.out.println(integer);


      /*  int num1 = 100;
        Integer i1 = new Integer(num1);      // 将 int 转换为 Integer 包装类
        Integer i2 = new Integer("999");  // 字符串也是可以的
        System.out.println(i1);
        System.out.println(i2);

        float f1 = 23.8f;  // 因为小数默认是 double 类型的
        Float f2 = new Float(f1);    // 将 float 转换为 Float 的包装类
        Float f3 = new Float("3.14");  // 字符串也是可以的。
        System.out.println(f2);
        System.out.println(f3);*/
    }



    public static void main1(String[] args) {
        int num = 100;
        // 将定义好的 int 100 封装传入到自定义的包装类当中去

        MyInt myInt = new MyInt(num);
        // 传入定义好的 int 类型的包装类
        disPlay(myInt);
    }


    // 该方法的形参只接受引用类型
    public static void disPlay(Object object) {
        System.out.println(object.toString());
    }

}


// 自己定义的包装类，用于存储 int 基本数据类型的
class MyInt {
    private int num;

    public MyInt() {
    }

    public MyInt(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    @Override
    public String toString() {
        return "int类型的包装类: " +
                "num=" + num +
                '}';
    }
}



