package 团队.demo5;

import java.util.Scanner;

public class practice3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入字符串数组的长度：");
        int length = input.nextInt();
        System.out.printf("请输入%d个字符串：\n", length);
        String[] strs = new String[length];
        for (int i = 0; i < strs.length; i++)
            strs[i] = input.next();
        String temp = "";
        boolean flag = true;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i))
                    flag = false;
            }
            if (flag)
                temp += strs[0].charAt(i);
            else
                break;
        }
        System.out.println("\"" + temp + "\"");
    }
}
