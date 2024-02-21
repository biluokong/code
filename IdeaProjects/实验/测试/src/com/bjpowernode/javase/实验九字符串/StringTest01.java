package com.bjpowernode.javase.实验九字符串;

import java.util.Scanner;

public class StringTest01 {
    public static void main(String[] args) {
        System.out.println("请输入两个字符串：");
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String str2 = input.nextLine();
        input.close();
        int flag = 0, temp = 0, count = 0;

        while (-1 != flag) {
           flag = str1.indexOf(str2, temp);
            if (flag > 0) {
                count++;
                temp = flag + str2.length();
            }
        }
        System.out.println("str2字符串在str1字符串出现的次数为：" + count);
    }
}
