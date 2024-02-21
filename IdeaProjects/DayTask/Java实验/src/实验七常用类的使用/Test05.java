package 实验七常用类的使用;

import java.util.regex.Matcher;

public class Test05 {
    public static void main(String[] args) {
        //随机生成的字母的来源字符串
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWSYZ";
        //用Math里中的random方法生成一个0-52（包括0但不包括52）之间的随机数
        //并且用这个随机数来取str中的字符，从而获得一个随机字母
        System.out.println(str.charAt((int) (Math.random() * 26 * 2)));
    }
}