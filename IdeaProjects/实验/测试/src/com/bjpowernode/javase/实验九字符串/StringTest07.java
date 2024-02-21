package com.bjpowernode.javase.实验九字符串;

public class StringTest07 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 52; i++) {
            str = str.append("abcdefghijklmnopqrs");
        }
        System.out.println("拼接后的串长度为：" + str.length());
        while (str.length() != 1) {
            for (int i = 0, j = 0; i < str.length(); i += 2) {
                str.deleteCharAt(i);
                str.insert(i, '\u0000');
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '\u0000') {
                    str.deleteCharAt(i);
                }
            }
        }
        System.out.println("最后的字母为：" + str);
    }
}
