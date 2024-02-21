package 团队.demo2;

import java.util.HashMap;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入书的总页码数：");
        long n = input.nextInt();
        HashMap<Character, Long> list = new HashMap<>();
        for (long i = 1; i <= n; i++) {
            String s = Long.toString(i);
            for (int j = 0; j < s.length(); j++) {
                if (list.get(s.charAt(j)) == null)
                    list.put(s.charAt(j), 1L);
                else
                    list.put(s.charAt(j), list.get(s.charAt(j)) + 1);
            }
        }
        String s = "0123456789";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(list.get(s.charAt(i)) + "");
        }
    }
}
