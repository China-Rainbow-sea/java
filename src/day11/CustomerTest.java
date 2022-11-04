package day11;

public class CustomerTest {
    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();  // 实例化对象,静态方法调用非静态方法
        customerView.enterMainMenu();
    }
}
