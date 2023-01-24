package blogs.blog6;


// 静态常量，导入对于特定的包，对于静态常量可以省略类名，直接使用常量名的方式
import static blogs.blog6.Day.SUNDAY;

// 枚举类型也是可以被权限修饰符修饰的
enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,   // 枚举常量大写字母，必须定义在第一行当中，使用“,”逗号分隔开，
    THURSDAY,
    FRIDAY,
    SATURDAY;   // 最后“;” 分号结尾

}

public class EnumTest3 {
    public void tellItLikeItIs(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("星期一是糟糕的");
                break;

            case FRIDAY:
                System.out.println("星期五是最爽的");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("周末是最最安逸的");
                break;

            default:
                System.out.println("其他时间一般");
                break;
        }
    }


    public static void main(String[] args) {
        // 静态方法调用非静态方法
        EnumTest3 enumTest3 = new EnumTest3();
        enumTest3.tellItLikeItIs(Day.MONDAY);
        enumTest3.tellItLikeItIs(Day.WEDNESDAY);
        enumTest3.tellItLikeItIs(Day.FRIDAY);
        enumTest3.tellItLikeItIs(Day.SATURDAY);
        enumTest3.tellItLikeItIs(Day.SUNDAY);
    }
}
