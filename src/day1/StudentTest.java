package day1;

public class StudentTest {
    public static void main(String[] args){
        // 创建自定义类引用类型Student数组
        Student[] students = new Student[20];
        // 创建一个为Student的数组，其数组的元素是 Student自定义类引用数据类型
        StudentTest test = new StudentTest();  // 实例化自己类,为了静态方法调用非静态方法
        test.valuation(students);
//        this.playStudents(students);   // 注意就算是 this也是无法使静态方法调用到非静态方法
        test.playStudents(students);

        test.planyState(students,3);
        System.out.println("***********排序后*******************");
        test.sort(students);
        test.playStudents(students);
    }


    // 自定义类作为引用类型的数组，赋值
    void valuation(Student[] students){
        for(int i = 0; i< students.length;i++){
            students[i] = new Student();  // 为数组中的Student自定义类引用数据类型元素赋值
            // 因为是自定义的类作为引用类型,自然就需要通过 new 开辟空间赋值, 不然该数组元素就是null了
        }

        for(int i = 0; i < students.length;i++){
            students[i].number = 1+i;  // 学号
            students[i].state = (int)(Math.random()*(6-1+1)+1);  // 年级
            students[i].score = (int)(Math.random()*(100-0+1));
        }
    }


    // 遍历数组
    void playStudents(Student[] students){
        for(int i = 0; i < students.length; i++ ){
            System.out.print(students[i].state+" "+students[i].score+",");
        }
    }

    // 打印对应年级的信息
    void planyState(Student[] students, int num){
        for(int i = 0; i < students.length; i++){
            if(students[i].state == num){
                System.out.println(students[i].state+" "+students[i].score);
            }
        }
    }


    // 对数组排序升序
    void sort(Student[] students){
        for(int i = 0;i < students.length-1;i++){
            for(int j = 1;j < students.length-i; j++){
                if(students[j-1].score > students[j].score){
                    Student temp = students[j-1];
                    students[j-1] = students[j];
                    students[j] = temp;
                }
            }
        }
    }
}

class Student{
    int number;
    int state;
    int score;


}
