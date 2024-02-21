package 团队.demo1;

import java.util.ArrayList;
import java.util.Scanner;

/*
2. 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，
后跟所有奇数元素。返回满足此条件的 任一数组 作为答案。
 */
public class Practice2 {
    public static void main(String[] args) {
        //用插入排序的思想实现
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要输入整数的个数：");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入" + n + "个数：");
        for (int i = 0; i < n; i++)
            nums[i] = input.nextInt();
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i], j = i - 1;
            for (; j >= 0 && temp % 2 == 0 && nums[j] % 2 != 0; j--)
                nums[j + 1] = nums[j];
            nums[j + 1] = temp;
        }
        for (int num : nums)
            System.out.print(num + " ");
    }
}
