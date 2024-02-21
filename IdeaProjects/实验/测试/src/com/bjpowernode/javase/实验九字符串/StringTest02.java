package com.bjpowernode.javase.实验九字符串;

import java.util.Scanner;

public class StringTest02 {
    public static void main(String[] args) {
        System.out.println("请输入一串字符：");
        Scanner input = new Scanner(System.in);
        StringBuffer str = new StringBuffer(input.nextLine());
        input.close();
        char temp;
        /**
         * 在构造方法StringBuffer(String str)的源代码中可以看到：
         * 其初始化容量为str字符串长度加上16
         * 所有若想得到str的长度，有两种方式：
         * (1)先用trimToSize方法减少str中多余的容量，再用capacity方法获得当前容量
         * (2)直接用str。capacity()减去16
         * (3)直接用str。length()获得
         */
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                str.deleteCharAt(i);
                str.insert(i, (char) (temp - 32));
            }
            if (temp >= 'A' && temp <= 'Z') {
                str.deleteCharAt(i);
                str.insert(i, (char) (temp + 32));
            }
        }
        System.out.println(str);
    }
}
