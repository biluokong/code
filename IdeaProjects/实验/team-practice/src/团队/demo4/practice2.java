package 团队.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("请输入一个正整数数组（输入-1时结束）：");
        do {
            list.add(input.nextInt());
        } while (list.get(list.size() - 1) != -1);
        list.remove(list.size() - 1);
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int num1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++){
                int num2 = list.get(j), temp;
                if (num1 <= num2)
                    temp = num1 * (j - i);
                else
                    temp = num2 * (j - i);
                if (temp > max)
                    max = temp;
            }
        }
        System.out.println(max);
    }
}
