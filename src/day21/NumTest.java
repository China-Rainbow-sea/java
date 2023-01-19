package day21;


import org.junit.Test;

import java.text.DecimalFormat;

/**
 * 关于数字的格式化
 *  java.text.DecimalFormat 专门负责数字格式化的.
 *  DecimalFormat df = new DecimalFormat(数字的格式)
 */
public class NumTest {

    /**
     * 数字的格式有那些:
     * # 代表任意数字
     * , 代表千分位
     * . 代表小数点
     * ###,###,## 表示千分位，保留2个小数
     */
    @Test
    public void test() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.##");
        String s = decimalFormat.format(1234.56);
        System.out.println(s);  // 1,234.56

    }

    @Test
    public void test2() {
        // 保留 4 个小数位，不够补上 0
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0000");  //
        String s = decimalFormat.format(1234.568);
        System.out.println(s);  // 1,234.5680
    }



}
