package 团队.demo2;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串；");
        String str = input.nextLine(), s1 = "", s2 = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int j = 0;
            for (; j < s1.length(); j++) {
                if (c == s1.charAt(j))
                    break;
            }
            if (j == s1.length())
                s1 += c;
            else {
                if (s2.length() < s1.length())
                    s2 = s1;
                s1 = "" + c;
            }
        }
        System.out.println(s1.length() > s2.length() ? s1.length() : s2.length());
    }
}
