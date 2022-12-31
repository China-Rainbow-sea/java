package day17;


/**
 * 编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算
 * 两数相除。
 *
 * 对 数 据 类 型 不 一 致 (NumberFormatException) 、 缺 少 命 令 行 参 数
 *
 * (ArrayIndexOutOfBoundsException、
 * 除0(ArithmeticException)及输入负数(EcDef 自定义的异常)进行异常处理。
 *
 * 提示：
 *
 * (1)在主类(EcmDef)中定义异常方法(ecm)完成两数相除功能。
 *
 * (2)在main()方法中使用异常处理语句进行异常处理。
 *
 * (3)在程序中，自定义对应输入负数的异常类(EcDef)。
 *
 * (4)运行时接受参数 java EcmDef 20 10 //args[0]=“20” args[1]=“10”
 *
 * (5)Interger类的static方法parseInt(String s)将s转换成对应的int值。
 * 如：int a=Interger.parseInt(“314”); //a=314;
 */
public class EcmDef {
    public static void main(String[] args) {
        String[] arg = {"9"};
        String[] arg1 = {"9","9"};
        String[] arg2 = {"1","7"};
        String[] arg3 = {"-1","-1"};
        test(arg);
        System.out.println("************************");
        test(arg1);
        System.out.println("************************");
        test(arg2);
        System.out.println("************************");
        test(arg3);


    }

    public static void test(String[] args) {
        int result = 0;
        try {
            int i = Integer.parseInt(args[0]);
            int j = Integer.parseInt(args[1]);  // 将字符串转换为 基本数据类型

            result = ecm(i,j);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("数据类型不一致");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("缺少命令行参数");
        } catch (EcDef e) {
            System.out.println(e.getMessage());
        }


        System.out.println(result);
    }

    public static int ecm(int i, int j) throws EcDef {  // 向上调用者抛出异常,
        if(i < 0 || j < 0) {
            throw new EcDef("分子或分母不能为负数");  // throw 抛出异常,如果不是运行异常,一般配合 throws向上抛出异常处理
        }

        return i / j;

    }
}

// 继承 Exception 异常类，自定义异常类
class EcDef extends Exception {
    static final long serialVersionUID = -33875169931222998L;   // 类的序号号，唯一的

    public EcDef() {
        // 无参构造器
        super();  // 调用父类的构造器
    }

    public EcDef(String s) {
        super(s); // 调用父类中的构造器
    }
}
