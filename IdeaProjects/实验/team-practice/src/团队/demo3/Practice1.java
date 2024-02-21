package 团队.demo3;

import java.util.HashMap;
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入整数数组的元素(输入-10000是结束输入)：");
        HashMap<Integer, String> list = new HashMap<>();
        int num = 0;
        do {
            num = input.nextInt();
            if (list.get(num) == null)
                list.put(num, "exist");
            else
                list.remove(num);
        } while (num != -10000);
        list.remove(-10000);
        list.forEach((integer, s) -> System.out.print(integer + " "));
    }
}
