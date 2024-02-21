package 实验七常用类的使用;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        // 获得输入的字符串
        String str = input.nextLine();
        input.close();
        //输出原始字符串
        System.out.println("原来的字符串为：" + str);
        Pattern p = Pattern.compile("\\b[a-z]");    //将给定的正则表达式编译到模式中
        Matcher m = p.matcher(str); //创建一个匹配此模式的给定输入的匹配器matcher对象

        while (m.find()) {  //查找与该模式匹配的输入序列的下一个子序列
            //如果找到了，则将匹配的结果替换为该字母的大写形式
            str = str.replaceFirst("\\b[" + m.group() + "]", m.group().toUpperCase());
        }
        //第二种方法，拿所有种类的字母一一去匹配是否为单词的首字母，是的话将其转换为大写
        /*for (char i = 'a'; i <= 'z'; i++) {
             str = str.replaceAll("\\b[" + i + "]", (char) (i - 32) + "");
        }*/
        System.out.println("替换后的字符串为：" + str);
    }
}
