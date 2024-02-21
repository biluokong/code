package 团队.demo6;

import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        //不将整数转换为字符串解决
        int num = input.nextInt(), temp = num, count = 0;
        if (num < 0) {
            System.out.println(false);
            return;
        }
        while (temp / 10 != 0) {
            temp /= 10;
            count++;
        }
        int[] nums = new int[++count];
        for (int i = 0; num / 10 != 0; i++) {
            nums[i] = num % 10;
            num /= 10;
        }
        nums[count - 1] = num;
        boolean flag = true;
        for (int i = 0; i < count; i++) {
            if (nums[i] != nums[count - i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
