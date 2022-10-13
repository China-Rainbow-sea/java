public class TransferTest {
    public static void main(String[] args){
        TransferTest test = new TransferTest();  // 实例化对象
        test.first();
    }

    public void first(){
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v,i);
        System.out.println(v.i);
    }


    public void second(Value v,int i){
        i = 0;
        v.i = 20;
        Value val = new Value(); // 实例化对象
        v = val;
        System.out.println(v.i+" "+i);
    }
}

class Value {
    int i = 0;
}
