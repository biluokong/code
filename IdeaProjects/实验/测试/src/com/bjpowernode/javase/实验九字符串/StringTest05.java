package com.bjpowernode.javase.实验九字符串;

import java.util.Scanner;

public class StringTest05 {
    public static void main(String[] args) {
        System.out.println("请输入一个八进制数字串(在整型数据范围内):");
        Scanner input = new Scanner(System.in);
        String  octal = input.nextLine();
        input.close();
        int integer = 0;
        try {
            integer = Integer.parseInt(octal, 8);
            System.out.println("其对应的二进制数为：" + Integer.toBinaryString(integer));
            System.out.println("其对应的十进制数为：" + integer);
            System.out.println("其对应的十六进制数为：" + Integer.toHexString(integer));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("你输入的字符串不是八进制数字串！");
        }
    }
}
