public class InterviewQuestion {
    /*
    public class Test {
        public static void main(String[] args){
            int a = 10;
            int b = 10;
            method(a,b);  // 需要在method 方法调用之后,仅打印出 a = 100
            // b = 200 ，请写出method 方法的代码
            System.out.println("a="+a);
            System.out.println("b="+b);
        }
    }
    */

    // 解题方法一:
    public static void methode(int a, int b){
        a = a * 10;
        b = b * 20;

        System.out.println("a="+a);
        System.out.println("b="+b);
        System.exit(0);  // 程序终止
    }

//    方法二,重写 println 方法;


    /*
    微软:
    定义一个int 型的数组:int[] arr = new int[]{12,3,3,56,77,432};
    让数组的每个位置上的值去除以首位的元素,得到的结果,作为该位置上的新值,遍历数组
     */
    // 错误方法
    public void value(int[] arr){
//        错误原因是,你数组的首元素除以自身首元素的值等于 1,arr[0] = 1;
//        而后面的数组元素的数值都是 / arr[0] = 1 ;
//        解决方法是从后面开始,或者保留主arr[0] 防止被改变
        for(int i = 0; i<arr.length;i++){
            arr[i] = arr[i] / arr[0];
        }

        // 正确方式:从后面开始除
        for(int i = arr.length -1;i>= 0; i--){
            arr[i] = arr[i] / arr[0];
        }

        // 方式二: 保留arr[0] 的数值防止覆盖
        int temp = arr[0];
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] / temp;
        }
    }


   public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6};
        System.out.println(arr);   // 注意这是引用类型的地址值(包含数值)

        char[] arr1 = new char[]{'a','b','c'};
        System.out.println(arr1); // 注意 对于char[] 数组,不是地址值,而是打印数组的内容
   }
}
