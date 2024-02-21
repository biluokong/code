package 实验七常用类的使用;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入两个字符串：");

        //获得两个字符串
        String str1 = input.nextLine();
        String str2 = input.nextLine();
        input.close();

        //创建记录重复字符串次数的变量count，和判断是否还有重复字符串的变量flag
        int count = 0, flag = 0;

        //死循环，直到没有重复字符串
        while (true) {
            //如果从指定位置，向后寻找到重复字符串，就获得str2在str1中的位置
            flag = str1.indexOf(str2, flag);
            if (flag != -1) {   //如果有重复字符串，就计数加1
                count++;
                //计数加1后，就让指定寻找的位置向后一个重复字符串的长度
                flag += str2.length();
            } else {    //如果没有重复字符串，就跳出循环
                break;
            }
        }

        System.out.println("字符串str2在字符串str2出现的次数为：" + count

        );
    }
}
