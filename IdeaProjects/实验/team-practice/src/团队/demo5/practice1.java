package 团队.demo5;

import java.util.ArrayList;
import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组元素（若要停止请输入-10000）：");
        do {
            list.add(input.nextInt());
        } while (list.get(list.size() - 1) != -10000);
        list.remove(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < i; j++)
                sum1 += list.get(j);
            for (int k = i + 1; k < list.size(); k++)
                sum2 += list.get(k);
            if (sum1 == sum2) {
                System.out.println("中心下标为：" + i);
                return;
            }
        }
        System.out.println(-1);
    }
}
