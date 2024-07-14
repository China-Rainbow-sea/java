package day34.com.rainbowsea.javase.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {

    public static void main(String[] args) throws IOException {
        // 使用URL类的openStream()方法可以打开到此URL的连接并返回一个用于从该连接读入的InputStream，实现最简单的网络爬虫
        URL url = new URL("https://tianqi.qq.com/");
        InputStream inputStream = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String s = null;

        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }

        bufferedReader.close();
    }
}
