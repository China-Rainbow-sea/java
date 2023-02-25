package day32;


import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式:
 * 体验一下正则表达式的威力：给我们文本处理带来哪些便利
 */
public class RegTheory01 {

    @Test
    public void test() {
        // 假定，编写了爬虫，从百度页面得到如下文本:
        String content = "Java平台由Java虚拟机(Java Virtual Machine)和Java 应用编程接口(Application Programming Interface、简称API)构成。Java 应用编程接口为Java应用提供了一个独立于操作系统的标准接口，可分为基本部分和扩展部分。在硬件或操作系统平台上安装一个Java平台之后，" +
                "Java应用程序就可运行。Java平台已经嵌入了几乎所有的操作系统。" +
                "这样Java程序可以只编译一次，就可以在各种系统中运行。" +
                "Java应用编程接口已经从1.1x版发展到1.2版。常用的Java平台基于Java1.8，" +
                "最近版本为Java19。";

        // 提取文章中所有的英文单词:
        // 传统方法: 使用遍历方式: 代码量大，效率不高:
        // 正则表达式:

        // 1. 先创建一个Pattern 对象，模式对象，可以理解成就是一个正则表达式对象
        Pattern pattern = Pattern.compile("[a-zA-Z]+");

        // 2. 创建一个匹配器对象
        // 理解：就是 matcher 匹配器，按照所编写的 pattern(模式/样式) ，到 content 文本之哦个你去匹配
        // 找到就返回 true,否则就返回false

        Matcher matcher = pattern.matcher(content);

        // 3. 开始循环匹配
        while(matcher.find()) {  // 找到返回 true,否则返回false
            // 匹配内容，文本，放到 matcher.group() 当中
            String group = matcher.group(0);
            System.out.println(group);
        }

        System.out.println("*******************************");


        // 提取文章中所有的数字
        // 1.创建对应正则表达式的对象
        pattern = Pattern.compile("[\\d]+"); // 或者 [0-9]+

        // 2.创建匹配器对象，用于匹配
        matcher = pattern.matcher(content);

        // 循环匹配，
        while(matcher.find()) {  // 整体上找到了返回,true,否则返回 false
            String group = matcher.group(0);
            System.out.println(group);
        }


        System.out.println("***********************************");

        // 提取文章中所有的字母和数字
        // 1. 创建正则表达式对象
        pattern = Pattern.compile("([0-9]+)|([a-zA-Z]+)"); // 或者 ([0-9]+)|([a-zA-Z]+) 注意不要用空格
        // 如果含有空格也是会当作是一个比较的内容的。

        // 2. 创建对应的匹配器，用于比较判断
        matcher = pattern.matcher(content);

        // 3.循环寻找: 整体找到返回 true,否则返回false
        while(matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
        }
    }


    /**
     * 查找出到该百度源码中的标题的信息
     */
    @Test
    public void test2() {
        String content = "ame=\"oq\" value=\"\"><input type=\"hidden\" name=\"rsv_pq\" value=\"0xcfcdd0bc00271c3d\"><input type=\"hidden\" name=\"rsv_t\" value=\"a8a3XQ3NljBuTZK4aysegy9GI2wfBNoAoHUTuyledv669kD4nlUBtFNkKKn6\"><input type=\"hidden\" name=\"rqlang\" value=\"en\"></form><div id=\"m\" class=\"under-searchbox-tips s_lm_hide \"><div id=\"lm-new\"></div></div><div id=\"s-hotsearch-wrapper\" class=\"s-isindex-wrap s-hotsearch-wrapper hide \"><div class=\"s-hotsearch-title\"><a class=\"hot-title\" href=\"https://top.baidu.com/board?platform=pc&sa=pcindex_entry\" target=\"_blank\"><div class=\"title-text c-font-medium c-color-t\" aria-label=\"百度热搜\"><i class=\"c-icon\">&#xe687;</i><i class=\"c-icon arrow\">&#xe613;</i></div></a><a id=\"hotsearch-refresh-btn\" class=\"hot-refresh c-font-normal c-color-gray2\"><i class=\"c-icon refresh-icon\">&#xe619;</i><span class=\"hot-refresh-text\">换一换</span></a></div><ul class=\"s-hotsearch-content\" id=\"hotsearch-content-wrapper\"><li class=\"hotsearch-item odd\" data-index=\"0\"><a class=\"title-content  c-link c-font-medium c-line-clamp1\" href=\"https://www.baidu.com/s?wd=%E6%98%A5%E6%97%A5%E9%87%8C%E7%9A%84%E4%B8%AD%E5%9B%BD%E5%A4%A7%E5%9C%B0%E8%89%B2%E5%BD%A9%E6%96%91%E6%96%93&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\" ><div class=\"title-content-noindex\" style=\"display: none;\"></div><i class=\"c-icon title-content-top-icon c-color-red c-gap-right-small\" style=\"display: ;\">&#xe62e;</i><span class=\"title-content-index c-index-single c-index-single-hot0\" style=\"display: none;\">0</span><span class=\"title-content-title\">春日里的中国大地色彩斑斓</span></a><span class=\"title-content-mark ie-vertical c-text c-gap-left-small \"></span></li><li class=\"hotsearch-item even\" data-index=\"3\"><a class=\"title-content  c-link c-font-medium c-line-clamp1\" href=\"https://www.baidu.com/s?wd=%E7%83%AD%E6%B0%94%E8%85%BE%E8%85%BE%E7%9A%84%E4%B8%AD%E5%9B%BD%E6%9D%A5%E4%BA%86&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\" ><div class=\"title-content-noindex\" style=\"display: none;\"></div><i class=\"c-icon title-content-top-icon c-color-red c-gap-right-small\" style=\"display: none;\">&#xe62e;</i><span class=\"title-content-index c-index-single c-index-single-hot3\" style=\"display: ;\">3</span><span class=\"title-content-title\">热气腾腾的中国来了</span></a><span class=\"title-content-mark ie-vertical c-text c-gap-left-small \"></span></li><li class=\"hotsearch-item odd\" data-index=\"1\"><a class=\"title-content tag-width c-link c-font-medium c-line-clamp1\" href=\"https://www.baidu.com/s?wd=%E5%91%A8%E5%B0%8F%E5%B7%9D%3A%E5%88%AB%E8%AE%A4%E4%B8%BA%E5%85%BB%E8%80%81%E9%97%AE%E9%A2%98%E8%BF%98%E6%9C%89%E6%8B%96%E5%BB%B6%E6%9C%BA%E4%BC%9A&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\" ><div class=\"title-content-noindex\" style=\"display: none;\"></div><i class=\"c-icon title-content-top-icon c-color-red c-gap-right-small\" style=\"display: none;\">&#xe62e;</i><span class=\"title-content-index c-index-single c-index-single-hot1\" style=\"display: ;\">1</span><s" +
                "pan class=\"title-content-title\">周小川:别认为养老问题还有拖延机会</span></a><" +
                "span class=\"title-content-mark ie-vertical c-text c-gap-left-small c-text-" +
                "hot\">热</span></li><li class=\"hotsearch-item even\" data-index=\"4\"><a cla" +
                "ss=\"title-content  c-link c-font-medium c-line-clamp1\" href=\"https://www." +
                "baidu.com/s?wd=%E7%94%B2%E6%B5%81%E8%BF%9B%E5%85%A5%E9%AB%98%E5%8F%91%E6%9C" +
                "%9F&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=" +
                "3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" targ" +
                "et=\"_blank\" ><div class=\"title-content-noindex\" style=\"display: none" +
                ";\"></div><i class=\"c-icon title-content-top-icon c-color-red c-gap-right" +
                "-small\" style=\"display: none;\">&#xe62e;</i><span class=\"title-content-i" +
                "ndex c-index-single c-index-single-hot4\" style=\"display: ;\">4</span><" +
                "span class=\"title-content-title\">甲流进入高发期</span></a><span class=\"ti" +
                "tle-content-mark ie-vertical c-text c-gap-left-small \"></span></li><li clas" +
                "s=\"hotsearch-item odd\" data-index=\"2\"><a class=\"title-content tag-w" +
                "idth c-link c-font-medium c-line-clamp1\" href=\"https://www.baidu.com/s?w" +
                "d=%E4%B8%8A%E6%B5%B780%E5%90%8E%E5%A4%AB%E5%A6%BB%E6%94%92300%E4%B8%87%E5%86" +
                "%B3%E5%AE%9A%E9%80%80%E4%BC%91&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepag" +
                "e&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;h" +
                "isfilter=1\" target=\"_blank\" ><div class=\"title-content-noindex\" style=\"d" +
                "isplay: none;\"></div><i class=\"c-icon title-content-top-icon c-color-red c" +
                "-gap-right-small\" style=\"display: none;\">&#xe62e;</i><span class=\"title-c" +
                "ontent-index c-index-single c-index-single-hot2\" style=\"display: ;\">2</" +
                "span><span class=\"title-content-title\">上海80后夫妻攒300万决定退休</span></a>" +
                "<span class=\"title-content-mark ie-vertical c-text c-gap-left-small c-text-" +
                "hot\">热</span></li><li class=\"hotsearch-item even\" data-index=\"5\"><a c" +
                "lass=\"title-content  c-link c-font-medium c-line-clamp1\" href=\"https://w" +
                "ww.baidu.com/s?wd=%E8%B6%85%E5%B8%82%E5%AE%A3%E7%A7%B01%E5%85%83%E7%BA%B8%" +
                "E5%B8%81%E5%B0%86%E9%80%80%E5%87%BA%E5%8E%86%E5%8F%B2&amp;sa=fyb_n_homepa" +
                "ge&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;" +
                "fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\" ><div class" +
                "=\"title-content-noindex\" style=\"display: none;\"></div><i class=\"c-ico" +
                "n title-content-top-icon c-color-red c-gap-right-small\" style=\"display: no" +
                "ne;\">&#xe62e;</i><span class=\"title-content-index c-index-single c-ind" +
                "ex-single-hot5\" style=\"display: ;\">5</span><span class=\"title-conte" +
                "nt-title\">超市宣称1元纸币将退出" +
                "历史</span></a><span class=\"title-content-mark ie-vertic" +
                "al c-text c-gap-left-small \"></span>";


        // <span class="title-content-title">春日里的中国大地色彩斑斓</span>
        // <span class="title-content-title">周小川:别认为养老问题还有拖延机会</span>

        // 1. 创建正则表达式对象
        String reg = "<span class=\"title-content-title\">(\\S*)</span>";  // ()进行了以下分组
        Pattern pattern = Pattern.compile(reg);

        // 2. 创建匹配器对象，用于匹配判断
        Matcher matcher = pattern.matcher(content);

        // 循环匹配，匹配返回true,否则返回false
        while(matcher.find()) {
            String group = matcher.group(1);  // 分组
            System.out.println(group);
        }


    }


    // 提取ip地址:
    @Test
    public void test3() {
        String content = "私有地址（Private address）属于非注册地址，专门为组织机构内部使用。\n" +
                "以下列出留用的内部私有地址\n" +
                "A类 10.0.0.0--10.255.255.255\n" +
                "B类 172.16.0.0--172.31.255.255\n" +
                "C类 192.168.0.0--192.168.255.255";

        // 1.创建正则表达式对象
        //Pattern pattern = Pattern.compile("\\d+\\.+\\d+\\.+\\d+\\.+\\d");
        Pattern pattern = Pattern.compile("(\\d+\\.){3}\\d");


        // 2.创建匹配器对象，用于匹配正则表达式
        Matcher matcher = pattern.matcher(content);

        // 循环遍历
        while(matcher.find()) {
            String group = matcher.group(0);
            System.out.println(group);
        }

    }
}
