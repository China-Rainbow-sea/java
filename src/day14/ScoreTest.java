package day14;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 */
public class ScoreTest {
    public static void main(String[] args) {
         // 实例Scanner ，用于从键盘获取学生成绩
        Scanner scanner = new Scanner(System.in);

        // 创建Vector 对象,Vector v = new Vector()，给Vector 中添加数组
        Vector v = new Vector();
        int maxScore = 0;
        for(;;) {
            System.out.println("请输入学生成绩(以负数代表输入结束:)");
            int score = scanner.nextInt();

            if(score < 0) {
                break;
            }

            if(score > 100) {
                continue;
            }

            // 3.1 添加, v.addElement(Object obj)
            // jdk5.0 之前
            Integer inScore = new Integer(score);
            v.addElement(inScore); // 多态 ，参数是 类，不是基本数据类型



            // 获取学生成绩的最大值
            if(maxScore < score) {
                maxScore = score;
            }
        }

        // 遍历Vector,得到每个学生的成绩，并与最大成绩比较，得到每个学生的等级
        char level;
        for(int i = 0; i < v.size(); i++) {
            Object object = v.elementAt(i);

            // jdk5.0之后
            Integer integer = (Integer)object;
            int score = integer; // 自动装箱

            if(maxScore - score <= 10) {
                level = 'A';
            } else if(maxScore - score <= 20) {
                level = 'B';
            } else if(maxScore - score <= 30) {
                level = 'C';
            } else {
                level = 'D';
            }

            System.out.println("student- "+i + "score is" + score +",level is"+level);
        }
    }
}
