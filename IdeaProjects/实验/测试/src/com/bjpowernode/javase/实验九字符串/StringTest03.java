package com.bjpowernode.javase.实验九字符串;

import java.util.Scanner;

public class StringTest03 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符：");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
        char temp;
        int j, kind = 0;
        char[] compare = new char[100];
        int[] count = new int[100];
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            for (j = 0; j < kind; j++) {
                if (temp == compare[j]) {
                    count[j]++;
                    break;
                }
            }
            if (j == kind) {
                compare[kind++] = temp;
                count[j]++;
            }
        }
        System.out.println("字符种类为：" + kind);
        for (int i = 0; i < kind; i++) {
            System.out.println(compare[i] + "的数量为：" + count[i]);
        }
    }
}
