package com.bjpowernode.javase.实验九字符串;

import java.util.Scanner;

public class StringTest06 {
    public static void main(String[] args) {
        System.out.println("请输入一个十六进制正整数（长度小于1000）：");
        Scanner input = new Scanner(System.in);
        String  hex = input.nextLine();
        input.close();
        int integer = 0;
        try {
            integer = Integer.parseInt(hex, 16);
            System.out.println("其对应的二进制数为：" + Integer.toBinaryString(integer));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("你输入的字符串不是十六进制数字串！");
        }
    }
}
