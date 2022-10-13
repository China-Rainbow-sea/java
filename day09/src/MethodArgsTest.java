public class MethodArgsTest {
    /*
    1.jdk 5.0 新增的内容
    2. 具体使用
      2.1 可变个数形参的格式,数据类型...变量名
      2.2 当调用可变个数形参的方法时,传入参数个数可以是 0 个 1 个2个
      2.3 可变个数形参的方法与本类中方法名相同,形参不同的方法之间构成重载
      2.4 可变个数形参的方法与本类中方法名相同,但是形参类型也相同的数组之间不构成重载,
      因为可变个数形参的本质还是数组
      2.5 可变个数形参必须放在参数列表的最后面. 如果是在前面的话,java不知道那几个是,另外形参的值
      2.6 可变个数形参在方法中只能声明一个。
      2.7
     */
    public static void main(String[] args){
        // 实例化对象,调用构成方法,静态的访问非静态方法
        MethodArgsTest methodArgsTest = new MethodArgsTest();
        methodArgsTest.show(12);
        methodArgsTest.show("hello");
        methodArgsTest.show("hello","world");
        methodArgsTest.show();
        methodArgsTest.show(new String[]{"AA","BB","CC"});
        // 可变形参的本质还是数组
        methodArgsTest.show(1,2,3,4,5,6);


    }

    public void show(int i ){
        System.out.println(i);
    }

    public void show(String s){
        System.out.println(s);
    }

    public void show(String...s){
        // 注意:对于可变参数的数据类型,中的多个参数是通过和数组的方式获取到的
        for(int i = 0; i<s.length;i++){
            System.out.print(s[i]+" ");
        }
        System.out.println("");
    }

    // 注意可变参数的本质还是数组，所以定义数组参数是会存在冲突的
 /*   public void show(String[] s){

    }*/

    public void show(){
        System.out.println("null");
    }


    public void show(int...n){
        for(int i = 0; i<n.length;i++){
            System.out.print(n[i]+" ");
        }
        System.out.println();
    }
}


