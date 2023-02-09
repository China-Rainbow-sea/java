package day27;


import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片的加密解密操作
 */
public class ImageEncryDecry {


    /**
     * 对图片中的每个像素点中的 byte 进行 ^ 5 的加密
     */
    @Test
    public void test() {
        FileInputStream fileInputStream = null; // 注意文件后缀
        FileOutputStream fileOutputStream = null;  //
        try {
            fileInputStream = new FileInputStream("src/day27/test2.jpg");
            fileOutputStream = new FileOutputStream("src/day27/test3.jpg");

            // 一边读，一边加密，一边写
            byte[] bytes = new byte[20];
            int len = 0;

            // 读取
            while((len = fileInputStream.read(bytes)) != -1) {
                // 读取多少，加密多少,注意了不是 bytes数组的长度，因为存在重复的覆盖效果
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte)(bytes[i] ^ 5);  // 加密
                }

                // 加密完后，写入到文件中:读取多少，写入多少
                fileOutputStream.write(bytes,0,len);

            }

            // 刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        // 关闭:
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /**
     * 对加密 ^ 5 的文件解密
     */
    @Test
    public void test2() {
        FileInputStream fileInputStream = null; // 注意文件后缀
        FileOutputStream fileOutputStream = null;  //
        try {
            fileInputStream = new FileInputStream("src/day27/test3.jpg");
            fileOutputStream = new FileOutputStream("src/day27/test4.jpg");

            // 一边读，一边加密，一边写
            byte[] bytes = new byte[20];
            int len = 0;

            // 读取
            while((len = fileInputStream.read(bytes)) != -1) {
                // 读取多少，加密多少,注意了不是 bytes数组的长度，因为存在重复的覆盖效果
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte)(bytes[i] ^ 5);  // 加密
                }

                // 加密完后，写入到文件中:读取多少，写入多少
                fileOutputStream.write(bytes,0,len);

            }

            // 刷新
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭:
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
