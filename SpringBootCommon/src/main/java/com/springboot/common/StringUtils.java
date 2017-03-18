package com.springboot.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title:
 * Description: 通过正则表达式分割、筛选字符串
 *  主要用到Pattern类、Matcher类
 *
 *  Pattern类：
 *
 *  将给定的正则表达式编译并赋予给Pattern类
 *  static Pattern compile(String regex);
 *
 *  编译给定的正则表达式并且对输入的字串以该正则表达式为模开展匹配,
 *  该方法适合于该正则表达式只会使用一次的情况，也就是只进行一次匹配工作，因为这种情况下并不需要生成一个Matcher实例。
 *  static boolean matches(String regex,CharSequence input)
 *
 *  将目标字符串按照Pattern里所包含的正则表达式为模进行分割
 *  String[] split(CharSequence input)
 *
 *  作用同上，增加参数limit目的在于要指定分割的段数，如将limi设为2，
 *  那么目标字符串将根据正则表达式分为割为两段。
 *  String[] split(CharSequence input, int limit)
 *
 *
 *  Matcher类
 *
 * 返回当前匹配的子串的最后一个字符在原目标字符串中的索引位置
 * int end()
 *
 *
 * 返回与匹配模式里指定的组相匹配的子串最后一个字符的位置
 * int end(int group)
 *
 * 尝试在目标字符串里查找下一个匹配子串
 * boolean find()
 *
 * 重设Matcher对象，并且尝试在目标字符串里从指定的位置开始查找下一个匹配的子串
 * boolean find(int start)
 *
 * 返回当前查找而获得的与组匹配的所有子串内容
 * string group()
 *
 * 返回当前查找而获得的与指定组匹配的子串内容
 * string group(int)
 *
 * 返回当前查找而获得的匹配组的数量
 * int groupCount()
 *
 * 检测目标字符串是否以匹配的子串起始
 * boolean lookingAt()
 *
 * 尝试对整个目标字符串展开匹配检测，也就会只有整个目标字符串完全匹配时才返回真值。
 * boolean matches()
 *
 * 将目标字符串里与既有模式相匹配的子串全部替换为制定的字符串
 * String replaceAll(String replacement)
 *
 * 将目标字符串里第一个与既有模式相匹配的子串替换为指定的字符串
 * String replaceFirst(String replacement)
 *
 * 只有当匹配操作成功,才可以使用start(),end(),group()三个方法,
 * 否则会抛出java.lang.IllegalStateException,
 * 也就是当matches(),lookingAt(),find()其中任意一个方法返回true时,才可以使用
 *
 * 复习正则表达式
 *
 *  字符：
 *      x 字符
 *      \\ 反斜杠字符
 *      \n 新行(换行)符
 *      |r 回车符
 *
 *   字符类：
 *       [abc] a、b或c(简单类)
 *       [^abc] 任何字符，除了 a、b或c(否定)
 *       [a-zA-Z]  a到z 或 A到Z ，两头的字母包括在内(范围)
 *       [0-9]  0-9的字符都包括
 *
 *   预定义字符类：
 *      . 单个任何字符
 *      \.  字符 .
 *      * 任意多个字符
 *      \*   字符 *
 *      \d  数字：[0-9]
 *      \D  非数字：[^\d]/[^0-9]
 *      \w  单词字符：[a-zA-Z_0-9]
 *      \W  非字符[^\w]
 *
 *    边界匹配器
 *       ^ 行的开头
 *       $ 行的结尾
 *       \b 单词边界,就是不是单词字符的地方
 *
 *     Greedy 数量词
 *       X?   X,一次或者一次也没有
 *       X*   X,零次或多次
 *       X+   X,一次或多次
 *       X{n}  X,恰好n次
 *       X{n,}  X,至少n次
 *       X{n,m} X,至少n次，但是不超过m次
 *
 *     运算符
 *       XY    X后跟 Y
 *       X|Y   X或 Y
 *       (X)   X,作为捕获组    &&&&&&&
 *
 * Project: SpringBoot
 * Create User: 王杰
 * Create Time: 2017/3/18
 */
public class StringUtils {

    public static void main(String[] args) {

        String regEx="(\\d+)(?:\\.?)(?:\\d+)([$￥])$";
        Pattern pat=Pattern.compile(regEx);
        Matcher mat=pat.matcher("104984.9848$");
        System.out.println(mat.groupCount());
        System.out.println(mat.matches());
        System.out.println(mat.group(1)+mat.group(2));

        //Java正则表达式- 捕获组 与 非捕获组
        String text="<textarea rows=\"20\" cols=\"70\">nexus maven repository index properties updating index central</textarea>";
        String reg="<textarea.*>.*</textarea>";
        Pattern pattern=Pattern.compile(reg);
        Matcher matcher=pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

        System.out.println("需求一");

        //如果只想获取textarea标签中间的数据
        String reg1="(<textarea.*>)(.*)(</textarea>)";
        Pattern pattern1=Pattern.compile(reg1);
        Matcher matcher1=pattern1.matcher(text);
        while(matcher1.find()){
            System.out.println("输出全部内容"+matcher1.group(0));
            System.out.println(matcher1.group(1));
            System.out.println(matcher1.group(2));
            System.out.println(matcher1.group(3));
        }


        System.out.println("需求二");
        //至于非捕获组，只需要将捕获组中"()"变为"(?:)"即可
        String reg2="(?:<textarea.*>)(.*)(?:</textarea>)";
        Pattern pattern2=Pattern.compile(reg2);
        Matcher matcher2=pattern2.matcher(text);
        while (matcher2.find()){
            System.out.println("输出全部内容："+matcher2.group(0));
            System.out.println(matcher2.group(1));
        }
    }

}
