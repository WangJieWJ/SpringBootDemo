package com.springBootTest.test;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Title:
 * Description:
 * <p>
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/1/12 0012.
 */
public class TestDemo {

    public static void main(String[] args) {
        String sWgZwidgetJson = "[{\"layoutZoneId\":\"2\",\"widgetSourceId\":\"71\",\"widgetSourceName\":\"_6X4a_图文轮播\",\"widgetSourceSize\":\"6X4a\",\"widgetParam\":{\"docId\":{\"desc\":\"资源ID\",\"type\":\"MetaViewData\",\"value\":\"270410\",\"Field\":\"outline\",\"num\":\"4\",\"sourceDocName\":\"天樽3匹柜式空调\"}},\"widgetCss\":{}},{\"layoutZoneId\":\"1\",\"widgetSourceId\":\"94\",\"widgetSourceName\":\"_3*4a单文档图（1:1）文\",\"widgetSourceSize\":\"3X4a\",\"widgetParam\":{\"toplink\":{\"desc\":\"资源ID\",\"type\":\"MetaViewData\",\"value\":\"283290\",\"Field\":\"link\",\"sourceDocName\":\"拯救空气终极计划\"},\"urlpic2\":{\"desc\":\"default-pic2\",\"type\":\"MetaViewData\",\"value\":\"283290\",\"Field\":\"pic2\",\"Relation\":\"toplink\",\"picsize\":\"303\",\"sourceDocName\":\"拯救空气终极计划\"},\"botlink\":{\"desc\":\"资源ID\",\"type\":\"MetaViewData\",\"value\":\"283290\",\"Field\":\"link\",\"sourceDocName\":\"拯救空气终极计划\"},\"title\":{\"desc\":\"default-title\",\"type\":\"MetaViewData\",\"value\":\"283290\",\"Field\":\"title\",\"Relation\":\"toplink\",\"stringsize\":\"30\",\"sourceDocName\":\"拯救空气终极计划\"},\"constr\":{\"desc\":\"default-title\",\"type\":\"MetaViewData\",\"value\":\"283290\",\"Field\":\"con\",\"Relation\":\"toplink\",\"sourceDocName\":\"拯救空气终极计划\"},\"con\":{\"desc\":\"default-title\",\"type\":\"MetaViewData\",\"value\":\"283290\",\"Field\":\"con\",\"Relation\":\"toplink\",\"stringsize\":\"36\",\"sourceDocName\":\"拯救空气终极计划\"}},\"widgetCss\":{}},{\"layoutZoneId\":\"3\",\"widgetSourceId\":\"94\",\"widgetSourceName\":\"_3*4a单文档图（1:1）文\",\"widgetSourceSize\":\"3X4a\",\"widgetParam\":{\"toplink\":{\"desc\":\"资源ID\",\"type\":\"MetaViewData\",\"value\":\"283289\",\"Field\":\"link\",\"sourceDocName\":\"空气净化器百科全书\"},\"urlpic2\":{\"desc\":\"default-pic2\",\"type\":\"MetaViewData\",\"value\":\"283289\",\"Field\":\"pic2\",\"Relation\":\"toplink\",\"picsize\":\"303\",\"sourceDocName\":\"空气净化器百科全书\"},\"botlink\":{\"desc\":\"资源ID\",\"type\":\"MetaViewData\",\"value\":\"283289\",\"Field\":\"link\",\"sourceDocName\":\"空气净化器百科全书\"},\"title\":{\"desc\":\"default-title\",\"type\":\"MetaViewData\",\"value\":\"283289\",\"Field\":\"title\",\"Relation\":\"toplink\",\"stringsize\":\"30\",\"sourceDocName\":\"空气净化器百科全书\"},\"constr\":{\"desc\":\"default-title\",\"type\":\"MetaViewData\",\"value\":\"283289\",\"Field\":\"con\",\"Relation\":\"toplink\",\"sourceDocName\":\"空气净化器百科全书\"},\"con\":{\"desc\":\"default-title\",\"type\":\"MetaViewData\",\"value\":\"283289\",\"Field\":\"con\",\"Relation\":\"toplink\",\"stringsize\":\"36\",\"sourceDocName\":\"空气净化器百科全书\"}},\"widgetCss\":{}}]";

        String sLayoutHtml = "<div class=\"hn_interaction_content pure-g\">\n" +
                "                <div class=\"pure-u-1-4 h-1-1\">\n" +
                "                   <div class=\"l-box\">\n" +
                "                     @WidgetLayout{\"layoutid\":\"1\",\"desc\":\"3X4a区域一\",\"sourcesize\":\"3X4a\"}@WidgetLayout\n" +
                "                   </div> \n" +
                "                </div>\n" +
                "                <div class=\"pure-u-1-2 h-1-1\">\n" +
                "                    <div class=\"l-box\">                       \n" +
                "                             @WidgetLayout{\"layoutid\":\"2\",\"desc\":\"6X4a区域二\",\"sourcesize\":\"6X4a\"}@WidgetLayout                    \n" +
                "                    </div>\n" +
                "                </div>  \n" +
                "                <div class=\"pure-u-1-4 h-1-1\">\n" +
                "                  <div class=\"l-box\">\n" +
                "                    @WidgetLayout{\"layoutid\":\"3\",\"desc\":\"3X4a区域三\",\"sourcesize\":\"3X4a\"}@WidgetLayout\n" +
                "                  </div>  \n" +
                "                </div>\n" +
                "            </div>";

        String[] sLayoutHtmlArr = sLayoutHtml.split("@WidgetLayout"); //肯定会出现一个

        for (String s : sLayoutHtmlArr) {
            System.out.println("---------------------------------------------");
            System.out.println(s);
        }

        //jsonArray 使用的是Widget资源的关联关系JSON转换而来
        if (sLayoutHtmlArr.length > 0) {
            for (int i = 0; i < sLayoutHtmlArr.length; i++) {
                if (i > 0 && i % 2 != 0) {
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    System.out.println(sLayoutHtmlArr[i]);
                    //logger.info("print to fufeiwu WidgetLayout新 "+"@WidgetLayout"+sLayoutHtmlArr[i]+"@WidgetLayout"+" y "+resultHtml+" z "+g_scretime);
                    String shtmlRe = ("@WidgetLayout" + sLayoutHtmlArr[i] + "@WidgetLayout").replaceAll("\\{", "").replaceAll("\\}", "");
                    sLayoutHtml = sLayoutHtml.replaceAll("\\{", "").replaceAll("\\}", "");
                }
            }
        }


        String[] Str = new String[]{"Str"};
        System.out.println(Str[0]);
        System.out.println(Str.length);

        System.out.println("000000000000000000000000000");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        System.out.println(list.contains(4));
        System.out.println(list.contains(1));
        System.out.println(list.contains(6));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (j >= 4) {
                    System.out.println("888888888888888888888888");
                    break;
                }
                System.out.println(j + "&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            }
            System.out.println(i + "-------------");
        }

        String DeStr = "\n" +
                "<div class=\"hn_interaction_content pure-g\">\n" +
                "    <div class=\"pure-u-1-2 h-1-1\">\n" +
                "        <div class=\"l-box\">\n" +
                "            <li class=\"js_allheight js_imgmove_r\">\n" +
                "\n" +
                "                <script type=\"text/javascript\">\n" +
                "                    document.write('<a style=\"display:none!important\" id=\"axdt-a-i_136_148\"></a>');\n" +
                "                    s = document.createElement(\"script\");\n" +
                "                    s.type = \"text/javascript\";\n" +
                "                    s.charset = \"utf-8\";\n" +
                "                    s.id = \"axdt-s-i_136_148\";\n" +
                "                    s.async = !0;\n" +
                "                    s.src = \"http://heretest.haier.com/ads/open/eval?i=i_136_148\";\n" +
                "                    h = document.getElementsByTagName(\"head\")[0];\n" +
                "                    if(h)h.insertBefore(s,h.firstChild);\n" +
                "                </script>\n" +
                "                <!--当无广告投放时，将默认显示此div内容-->\n" +
                "                <div id=\"axdt-d-i_136_148\" style=\"height:300px;width:300px;display:none;\">\n" +
                "                </div>\n" +
                "\n" +
                "            </li>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"pure-u-1-4 h-1-1\">\n" +
                "        <div class=\"l-box\">\n" +
                "            @WidgetLayout{\"layoutid\":\"2\",\"desc\":\"3X4a区域二\",\"sourcesize\":\"3X4a\"}@WidgetLayout\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"pure-u-1-4 h-1-1 \">\n" +
                "        <div class=\"pure-g\">\n" +
                "            <div class=\"pure-u-1-1 h-1-2\">\n" +
                "                <div class=\"l-box\">\n" +
                "                    @WidgetLayout{\"layoutid\":\"3\",\"desc\":\"3X2a区域三\",\"sourcesize\":\"3X2a\"}@WidgetLayout\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"pure-u-1-1 h-1-2\">\n" +
                "                <div class=\"l-box\">\n" +
                "                    @WidgetLayout{\"layoutid\":\"4\",\"desc\":\"3X2a区域四\",\"sourcesize\":\"3X2a\"}@WidgetLayout\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>";

        String[] strArray = DeStr.split("@WidgetLayout");
        for (String s : strArray) {
            System.out.println(s);
            System.out.println("*****************************");
        }

        String shtmlRe = ("@WidgetLayout" + sLayoutHtmlArr[3] + "@WidgetLayout").replaceAll("\\{", "").replaceAll("\\}", "");
        DeStr = DeStr.replaceAll("\\{", "").replaceAll("\\}", "");
        System.out.println(shtmlRe + "------------");
        DeStr = DeStr.replace(shtmlRe, "asdadsdsad"); //All

        System.out.println(DeStr);

        System.out.println("------------------------------------------------------------------------------------");

        try {

            String HTML = "%E6%B5%8B%E8%AF%95%E4%B8%AD%E6%96%87%E4%B9%B1%E7%A0%81";
            System.out.println(URLDecoder.decode(HTML, "UTF-8"));
            System.out.println(URLDecoder.decode(HTML, "GB2312"));
            String HTMLT = URLDecoder.decode(HTML);

            System.out.println("默认编码方式：" + Charset.defaultCharset());
            String HTML11 = "中文乱码测试";
            System.out.println(new String(HTMLT.getBytes(), Charset.forName("gb2312")));

            System.out.println("现在正在test分支测试冲突");

            //将文字从utf-8转换为gb2312
            System.out.println("将文字从utf-8转换为gb2312");
            byte[] HTML11Bytes = HTML11.getBytes("UTF-8");
            String newHTML11Bytes = new String(HTML11Bytes, Charset.forName("GBK"));
            System.out.println(newHTML11Bytes);

            byte[] Temp = DeStr.getBytes("UTF-8");
            String Temp1 = new String(Temp, Charset.forName("GBK"));
            System.out.println(Temp1);

            System.out.println("将文字从GB2312转为UTF-8");
            byte[] GB2312 = newHTML11Bytes.getBytes("gb2312");
            String newGB2312 = new String(GB2312, "gb2312");
            System.out.println(newGB2312);


            System.out.println("解码编码测试");
            String _str = "中文乱码测试";
            String _str1 = URLEncoder.encode(_str, "GBK");
            System.out.println("使用GBK编码结果：" + _str1);
            String _str2 = URLDecoder.decode(_str1, "GBK");
            System.out.println("使用GBK解码结果：" + _str2);

            String _Str = "中文乱码测试结果";
            String _Str1 = URLEncoder.encode(_Str, "UTF-8");
            System.out.println("使用UTF-8编码结果：" + _Str);
            String _Str2 = URLDecoder.decode(_Str1, "UTF-8");
            System.out.println("使用UTF-8解码结果：" + _Str2);

            System.out.println("当前正在dev分支，测试冲突！！！");
            System.out.println("Hello Merge 冲突");
            System.out.println("当前正在dev分支，测试冲突！！！");
            System.out.println("Hello World Demo ");
            System.out.println();



            String resultHtml="&lt;script%E2%80%82type=&#ssss;text/javascript&#ssss;&gt;%0A%09document.write(&#dddd;&lt;a%E2%80%82style=&#ssss;display:none!important;width:%E2%80%82300px;height:%E2%80%82400px&#ssss;%E2%80%82id=&#ssss;axdt-a-i_3_3&#ssss;&gt;&lt;/a&gt;&#dddd;);%0A%E2%80%82%E2%80%82%E2%80%82%E2%80%82s%E2%80%82=%E2%80%82document.createElement(&#ssss;script&#ssss;);%0A%E2%80%82%E2%80%82%E2%80%82%E2%80%82s.type%E2%80%82=%E2%80%82&#ssss;text/javascript&#ssss;;%0A%E2%80%82%E2%80%82%E2%80%82%E2%80%82s.charset%E2%80%82=%E2%80%82&#ssss;utf-8&#ssss;;%0A%E2%80%82%E2%80%82%E2%80%82%E2%80%82s.id%E2%80%82=%E2%80%82&#ssss;axdt-s-i_3_3&#ssss;;%0A%E2%80%82%E2%80%82%E2%80%82%E2%80%82s.async%E2%80%82=%E2%80%82!0;%0A%E2%80%82%E2%80%82%E2%80%82%E2%80%82s.src%E2%80%82=%E2%80%82&#ssss;http://marketing.haier.com/ads/open/eval?i=i_3_3&#ssss;;%0A%E2%80%82%E2%80%82%E2%80%82%E2%80%82h%E2%80%82=%E2%80%82document.getElementsByTagName(&#ssss;head&#ssss;)%5B0%5D;%0A%E2%80%82%E2%80%82%E2%80%82%E2%80%82if(h)h.insertBefore(s,h.firstChild);%0A&lt;/script&gt;%0A&lt;!--%E5%BD%93%E6%97%A0%E5%B9%BF%E5%91%8A%E6%8A%95%E6%94%BE%E6%97%B6%EF%BC%8C%E5%B0%86%E9%BB%98%E8%AE%A4%E6%98%BE%E7%A4%BA%E6%AD%A4div%E5%86%85%E5%AE%B9--&gt;%0A&lt;div%E2%80%82id=&#ssss;axdt-d-i_3_3&#ssss;%E2%80%82style=&#ssss;height:400px;width:300px;display:none;&#ssss;&gt;%0A&lt;/div&gt;%0A";

            System.out.println(resultHtml.contains("%E2%80%82"));
            resultHtml=resultHtml.replaceAll("%E2%80%82"," ");
            System.out.println("替换之后的"+resultHtml);
            resultHtml = URLDecoder.decode(resultHtml,"UTF-8");
            resultHtml = resultHtml.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&#ssss;", "\"").replaceAll("&#dddd;", "'").replaceAll("&amp;", "&").replaceAll("&ensp;", " ").replaceAll("&emsp;", "　");
            //转换编码
            System.out.println(resultHtml);

            System.out.println("-------------------------------------------");
            System.out.println("解码"+URLDecoder.decode("%E2%80%82","utf-8")+"完成");
            System.out.println(" ".equals(URLDecoder.decode("%E2%80%82","utf-8")));
            System.out.println(" ".equals(" "));
            System.out.println(" ".equals(" "));
            System.out.println(" ".equals(URLDecoder.decode("%E2%80%82","utf-8")));
            System.out.println("".equals(URLDecoder.decode("%E2%80%82","utf-8")));


        } catch (Exception e) {

        }
    }
}
