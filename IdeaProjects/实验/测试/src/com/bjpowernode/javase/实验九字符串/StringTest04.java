package com.bjpowernode.javase.实验九字符串;

import java.util.Scanner;

public class StringTest04 {
    public static void main(String[] args) {
        System.out.println("请输入一段话（英文的，以回车符结束）：");
        Scanner input = new Scanner(System.in);
        StringBuffer str = new StringBuffer(input.nextLine());
        input.close();
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if ((i == 0 && t >= 'a' && t <= 'z') || (i == (str.length() - 1) && t >= 'a' && t <= 'z')) {
                str.deleteCharAt(i);
                str.insert(i, (char)(t - 32));
                continue;
            } else if (i == str.length() - 1) {
                break;
            } else if (t == '.' || t == ',' || t == '、' || t == ' ' || t == '\t' || t == '"' || t == '\'') {
                if (str.charAt(i + 1) == '“' || str.charAt(i + 1) == '’') {
                    continue;
                } else if (str.charAt(i + 1) >= 'a' && str.charAt(i + 1) <= 'z') {
                    char temp = str.charAt(i + 1);
                    str.deleteCharAt(i + 1);
                    str.insert(i + 1, (char) (temp - 32));
                }
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (i == 0) {
                if (t == '.' || t == ',' || t == '、' || t == ' ' || t == '\t' || t == '\'') {
                    str.deleteCharAt(i);
                }
            } else {
                if (t == '\t') {
                    str.deleteCharAt(i);
                }
            }
        }
        System.out.println(str);
    }
}
