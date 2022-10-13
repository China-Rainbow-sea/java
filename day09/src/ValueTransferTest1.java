public class ValueTransferTest1 {
    public static void main(String[] args){
        int m = 10;
        int n = 20;

        System.out.println("m="+m+",n="+n);

        ValueTransferTest1 test = new ValueTransferTest1();
        test.swap(m,n);
        System.out.println("m="+m+",n="+n);

        System.out.println("引用类型交换数值");
        Data data = new Data();  // 实例化对象,所传为地址
        data.m = 10;
        data.n = 20;

        System.out.println("m="+data.m+",n="+data.n);
        test.swap(data);  // data 所传的是对象的地址
        System.out.println("m="+data.m+",n="+data.n);





    }

    // 基本数据类型形参是数据的值,当出了方法作用域,就会被系统回收
    public void swap(int x ,int y){
        int temp = x;
        x = y;
        y = temp;
    }


    // 所接受的是对象的地址
    public void swap(Data data){
        int temp = data.m;
        data.m = data.n;
        data.n = temp;
    }
}

class Data{
    int m ;
    int n ;
}
