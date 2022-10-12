package day1;

public class Exer3Test {
    public static void main(String[] args){

        Exer3Test exer = new Exer3Test();
        exer.method();
        /*
        可以实例化自己类，为对象，
        静态方法想调用非静态方法，需要实例化对象,调用构成方法
         */
        System.out.println(exer.areaMethod(10, 8));
    }

    public void method(){
        for(int i = 0;i<10;i++){
            for(int j = 0; j<8;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public int areaMethod(int x ,int y){
        return x * y;
    }
}
