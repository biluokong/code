package 团队.demo6;

import java.util.ArrayList;
import java.util.Scanner;

public class practice3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>(10);
        System.out.println("请输入房屋的现金数（输入-1停止）：");
        do {
            list.add(input.nextInt());
        } while (list.get(list.size() - 1) != -1);
        list.remove(list.size() - 1);
        int sum = 0, temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            for (int j = i + 2; j < list.size(); j += 2) {
                if (j % (list.size() - 1) != j - 2)
                    temp += list.get(j);
            }
            if (temp > sum)
                sum = temp;
        }
        System.out.println(sum);
    }
}
