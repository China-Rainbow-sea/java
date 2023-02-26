package blogs.blog12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest01 {
    public static void main(String[] args) {
        String content = "name=\"oq\" value=\"\"><input type=\"hidden\" name=\"rsv_pq\"" +
                " value=\"0xb79379dd001c441c\"><input type=\"hidden\" name=\"rsv_t\" valu" +
                "e=\"6ab2PWJNZs4OfZhgLwgMJI9gVsivBq7kMA9T8vJRItmCHeBsBD0QsnashhrZ\"><inp" +
                "ut type=\"hidden\" name=\"rqlang\" value=\"en\"></form><div id=\"m\" clas" +
                "s=\"under-searchbox-tips s_lm_hide \"><div id=\"lm-new\"></div></div><div" +
                " id=\"s-hotsearch-wrapper\" class=\"s-isindex-wrap s-hotsearch-wrapper hid" +
                "e \"><div class=\"s-hotsearch-title\"><a class=\"hot-title\" href=\"https:/" +
                "/top.baidu.com/board?platform=pc&sa=pcindex_entry\" target=\"_blank\"><div " +
                "class=\"title-text c-font-medium c-color-t\" aria-label=\"百度热搜\"><i cla" +
                "ss=\"c-icon\">&#xe687;</i><i class=\"c-icon arrow\">&#xe613;</i></div></a><" +
                "a id=\"hotsearch-refresh-btn\" class=\"hot-refresh c-font-normal c-color-gra" +
                "y2\"><i class=\"c-icon refresh-icon\">&#xe619;</i><span class=\"hot-refresh-" +
                "text\">换一换</span></a></div><ul class=\"s-hotsearch-content\" id=\"hotsearc" +
                "h-content-wrapper\"><li class=\"hotsearch-item odd\" data-index=\"0\"><a cla" +
                "ss=\"title-content  c-link c-font-medium c-line-clamp1\" href=\"https://www.b" +
                "aidu.com/s?wd=%E4%BA%8C%E5%8D%81%E5%B1%8A%E4%BA%8C%E4%B8%AD%E5%85%A8%E4%BC%" +
                "9A%E5%BC%80%E5%A7%8B%E4%B8%BE%E8%A1%8C&amp;sa=fyb_n_homepage&amp;rsv_dl=fy" +
                "b_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp" +
                ";rsv_idx=2&amp;hisfilter=1\" target=\"_blank\" ><div class=\"title-content" +
                "-noindex\" style=\"display: none;\"></div><i class=\"c-icon title-content-t" +
                "op-icon c-color-red c-gap-right-small\" style=\"display: ;\">&#xe62e;</i><s" +
                "pan class=\"title-content-index c-index-single c-index-single-hot0\" style=" +
                "\"display: none;\">0</span><span class=\"title-content-title\">二十届二中全会" +
                "开始举行</span></a><span class=\"title-content-mark ie-vertical c-text c-g" +
                "ap-left-small \"></span></li><li class=\"hotsearch-item even\" data-index=\"" +
                "3\"><a class=\"title-content  c-link c-font-medium c-line-clamp1\" href=\"h" +
                "ttps://www.baidu.com/s?wd=%E7%AB%99%E4%B8%8A%E6%96%B0%E8%B5%B7%E7%82%B9+%E5" +
                "%A5%8B%E5%8A%9B%E5%BC%80%E6%96%B0%E5%B1%80&amp;sa=fyb_n_homepage&amp;rsv_dl" +
                "=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&am" +
                "p;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\" ><div class=\"title-content" +
                "-noindex\" style=\"display: none;\"></div><i class=\"c-icon title-content-t" +
                "op-icon c-color-red c-gap-right-small\" style=\"display: none;\">&#xe62e;</" +
                "i><span class=\"title-content-index c-index-single c-index-single-hot3\" st" +
                "yle=\"display: ;\">3</span><span class=\"title-content-title\">站上新起点 奋" +
                "力开新局</span></a><span class=\"title-content-mark ie-vertical c-text c-gap" +
                "-left-small \"></span></li><li class=\"hotsearch-item odd\" data-index=\"1\"" +
                "><a class=\"title-content tag-width c-link c-font-medium c-line-clamp1\" hr" +
                "ef=\"https://www.baidu.com/s?wd=%E7%94%B7%E5%AD%90%E5%9C%A8%E8%87%AA%E5%AE%" +
                "B6%E9%B1%BC%E5%A1%98%E7%94%B5%E9%B1%BC%E8%A2%AB%E7%BD%9A+%E8%AD%A6%E6%96%B9" +
                "%E9%81%93%E6%AD%89&amp;sa=fyb_n_homepage&amp;rsv_dl=fyb_n_homepage&amp;from" +
                "=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2&amp;hisfilte" +
                "r=1\" target=\"_blank\" ><div class=\"title-content-noindex\" style=\"displ" +
                "ay: none;\"></div><i class=\"c-icon title-content-top-icon c-color-red c-ga" +
                "p-right-small\" style=\"display: none;\">&#xe62e;</i><span class=\"title-c" +
                "ontent-index c-index-single c-index-single-hot1\" style=\"display: ;\">1<" +
                "/span><span class=\"title-content-title\">男子在自家鱼塘电鱼被罚 警方道歉</sp" +
                "an></a><span class=\"title-content-mark ie-vertical c-text c-gap-left-smal" +
                "l c-text-hot\">热</span></li><li class=\"hotsearch-item even\" data-index=" +
                "\"4\"><a class=\"title-content  c-link c-font-medium c-line-clamp1\" href=" +
                "\"https://www.baidu.com/s?wd=%E4%BA%94%E4%B8%80%E5%81%87%E6%9C%9F%E5%8F%AF" +
                "%E4%BB%A5%E6%8B%BC%E5%87%BA9%E5%A4%A9%E9%95%BF%E5%81%87&amp;sa=fyb_n_homep" +
                "age&amp;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&am" +
                "p;fr=top1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\" ><div class" +
                "=\"title-content-noindex\" style=\"display: none;\"></div><i class=\"c-ico" +
                "n title-content-top-icon c-color-red c-gap-right-small\" style=\"display: " +
                "none;\">&#xe62e;</i><span class=\"title-content-index c-index-single c-ind" +
                "ex-single-hot4\" style=\"display: ;\">4</span><span class=\"title-content-" +
                "title\">五一假期可以拼出9天长假</span></a><span class=\"title-content-mark " +
                "ie-vertical c-text c-gap-left-small \"></span></li><li class=\"hotsearch-i" +
                "tem odd\" data-index=\"2\"><a class=\"title-content tag-width c-link c-font" +
                "-medium c-line-clamp1\" href=\"https://www.baidu.com/s?wd=%E5%A6%BB%E5%AD%90" +
                "%E6%83%B3%E5%8D%96%E6%88%BF%E6%95%91%E5%84%BF%E9%81%AD%E4%B8%88%E5%A4%AB%E5%" +
                "8F%8D%E5%AF%B9+%E6%80%92%E6%8F%90%E7%A6%BB%E5%A9%9A&amp;sa=fyb_n_homepage&am" +
                "p;rsv_dl=fyb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=to" +
                "p1000&amp;rsv_idx=2&amp;hisfilter=1\" target=\"_blank\" ><div class=\"title-c" +
                "ontent-noindex\" style=\"display: none;\"></div><i class=\"c-icon title-content-" +
                "top-icon c-color-red c-gap-right-small\" style=\"display: none;\">&#xe62e;</i><spa" +
                "n class=\"title-content-index c-index-single c-index-single-hot2\" style=\"displ" +
                "ay: ;\">2</span><span class=\"title-content-title\">妻子想卖房救儿遭丈夫反对 怒提离" +
                "婚</span></a><span class=\"title-content-mark ie-vertical c-text c-gap-left-small" +
                " c-text-hot\">热</span></li><li class=\"hotsearch-item even\" data-index=\"5\"><a" +
                " class=\"title-content  c-link c-font-medium c-line-clamp1\" href=\"https://www.ba" +
                "idu.com/s?wd=%E8%B0%81%E5%9C%A8%E9%B9%A4%E5%B2%97%E5%B0%8F%E5%9F%8E%E5%96%9D38%E5%" +
                "85%83%E4%B8%80%E6%9D%AF%E7%9A%84%E5%92%96%E5%95%A1&amp;sa=fyb_n_homepage&amp;rsv_dl=f" +
                "yb_n_homepage&amp;from=super&amp;cl=3&amp;tn=baidutop10&amp;fr=top1000&amp;rsv_idx=2" +
                "&amp;hisfilter=1\" target=\"_blank\" ><div class=\"title-content-noindex\" style=\"di" +
                "splay: none;\"></div><i class=\"c-icon title-content-top-icon c-color-red c-gap-right" +
                "-small\" style=\"display: none;\">&#xe62e;</i><span class=\"title-content-index c-ind" +
                "ex-single c-index-single-hot5\" style=\"display: ;\">5</span><span class=\"title-cont" +
                "ent-title\">谁在鹤岗小城喝38元一杯的咖啡</span></a><span class=\"title-content-mark ie-v" +
                "ertical c-text c-gap-left-small \"></span></li></ul></div><textarea id=\"hotsearch_da" +
                "ta\" style=\"display:none;\">";
        // 找规律：编程正则表达式
        // <span class="title-content-title">二十届二中全会开始举行</span></a>
        // <span class="title-content-title">站上新起点 奋力开新局</span></a>

        // 1. 创建正则表达式对象
        String reg = "[\\d]</span><span class=\"title-content-title\">(\\S*\\s?\\S*)</span></a>";
        Pattern pattern = Pattern.compile(reg);

        // 2. 创建匹配器对象，用于匹配判断
        Matcher matcher = pattern.matcher(content);

        // 循环匹配，匹配返回true,否则返回false
        while(matcher.find()) {
            String group = matcher.group(1);  // 分组
            System.out.println(group);
        }
    }


    public static void main2(String[] args) {
        // 假定，编写了爬虫，从百度页面得到如下文本:
        String content = "Java平台由Java虚拟机(Java Virtual Machine)和Java 应用编程接口(Application Programming Interface、简称API)构成。Java 应用编程接口为Java应用提供了一个独立于操作系统的标准接口，" +
                "可分为基本部分和扩展部分。在硬件或操作系统平台上安装一个Java平台之后，" +
                "Java应用程序就可运行。Java平台已经嵌入了几乎所有的操作系统。" +
                "这样Java程序可以只编译一次，就可以在各种系统中运行。" +
                "Java应用编程接口已经从1.1x版发展到1.2版。常用的Java平台基于Java1.8，" +
                "最近版本为Java19。";

        // 1.创建一个正则表达式对象
        Pattern pattern = Pattern.compile("[\\d]+");

        // 2.创建一个匹配器，用于匹配符合正则表达式的字符串
        Matcher matcher = pattern.matcher(content);

        // 循环遍历获取符合条件的字符串
        while(matcher.find()) { // 一点一点的同文本中遍历匹配是否符合该正则表达式，符合返回true,否则返回false
            String group = matcher.group(0);
            System.out.println(group);
        }
    }



    public static void main1(String[] args) {
        // 假定，编写了爬虫，从百度页面得到如下文本:
        String content = "Java平台由Java虚拟机(Java Virtual Machine)和Java 应用编程接口(Application Programming Interface、简称API)构成。Java 应用编程接口为Java应用提供了一个独立于操作系统的标准接口，" +
                "可分为基本部分和扩展部分。在硬件或操作系统平台上安装一个Java平台之后，" +
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
        // 理解：就是 matcher 匹配器，按照所编写的 pattern(模式/样式) ，到 content 文本中去匹配
        // 找到就返回 true,否则就返回false
        Matcher matcher = pattern.matcher(content);

        // 3. 开始循环匹配
        while(matcher.find()) {  // 找到返回 true,否则返回false
            // 匹配内容，文本，放到 matcher.group() 当中
            String group = matcher.group(0);
            System.out.println(group);
        }
    }
}
