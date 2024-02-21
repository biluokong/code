package 团队.demo6;

import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        StringBuilder str = new StringBuilder(input.nextLine());
        String s1 = "", s2 = "";
        boolean flag = true;
        while (str.length() > 1){
            s1 = str.charAt(0) + "";
            for (int i = 1; i < str.length(); i++) {
                flag = true;
                s1 += str.charAt(i);
                for (int j = 0; j < s1.length() / 2; j++) {
                    if (s1.charAt(j) != s1.charAt(s1.length() - j - 1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && s1.length() > s2.length())
                    s2 = s1;
            }
            str.deleteCharAt(0);
        }
        System.out.println(s2);
    }
}
