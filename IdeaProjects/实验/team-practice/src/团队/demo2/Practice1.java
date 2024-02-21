package 团队.demo2;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组中元素的个数：");
        int n = input.nextInt();
        int[] nums = new int[n + 1];
        System.out.println("请输入数组的元素：");
        for (int i = 0; i < nums.length - 1; i++)
            nums[i] = input.nextInt();
        System.out.println("请输入一个数：");
        int num = input.nextInt();
        input.close();
        insert(nums, num, 0);
        for (int i : nums) {
            System.out.printf(i + " ");
        }
    }

    public static void insert(int[] nums, int num, int k) {
        if (k == nums.length - 2) {
            nums[nums.length - 1] = num;
            return;
        }
        boolean flag = false;
        if (nums[k] > nums[k + 1]) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (num >= nums[i]) {
                    for (int j = nums.length - 1; j > i; j--)
                        nums[j] = nums[j - 1];
                    nums[i] = num;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                nums[nums.length - 1] = num;
        } else if (nums[k] < nums[k + 1]) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (num <= nums[i]) {
                    for (int j = nums.length - 1; j > i; j--)
                        nums[j] = nums[j - 1];
                    nums[i] = num;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                nums[nums.length - 1] = num;
        } else
            insert(nums, num, k + 1);
    }
}
