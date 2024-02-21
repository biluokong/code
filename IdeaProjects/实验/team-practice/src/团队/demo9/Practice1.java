package 团队.demo9;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s = input.nextLine(), str = "", count = "";
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                flag = true;
                str = "";
            }
            if (flag && ch != ' ') {
                str += ch;
                if (i + 1 >= s.length() || s.charAt(i + 1) == ' ')
                    flag = false;
                count = str;
            }
        }
        System.out.println("".equals(str) ? count.length() : str.length());
    }
}
