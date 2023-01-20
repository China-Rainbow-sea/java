package blogs.blog5;

public class StringBufferTest {
    public static void main(String[] args) {
        // 设置初始比较时间
        long startTime = 0L;   // 默认 整数是 int 类型
        long endTime = 0L;

        String stringTest = "";
        StringBuffer stringBufferTest = new StringBuffer("");
        StringBuilder stringBuilderTest = new StringBuilder("");

        // String 执行
        startTime = System.currentTimeMillis();    // 获取到当前的毫秒值(时间戳)
        for (int i = 0; i < 200000; i++) {
            stringTest += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String: " + (endTime - startTime));


        // StringBuffer 执行
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            stringBufferTest.append(String.valueOf(i));  //将int 类型转换为 String
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (endTime - startTime));

        // StringBuilder
        startTime = System.currentTimeMillis();  // 获取到当前系统的毫秒数(时间戳)
        for (int i = 0; i < 200000; i++) {
            stringBuilderTest.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (endTime - startTime));

    }
}
