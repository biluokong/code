package algorithm;

import java.util.*;

public class Test53 {
    public static void main(String[] args) {
        //Integer[] nums = Utils.getInput();
        //System.out.println(fun2(nums));

        int[] nums_tmp = Utils.getInputToIntArray();
        System.out.println(fun3(nums_tmp));
    }

    //分治法
    public static int fun3(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        //递归计算左半边最大子序和
        int[] leftNums = Arrays.copyOfRange(nums, 0, n >> 1);
        int max_left = fun3(leftNums);
        //递归计算右半边最大子序和
        int[] rightNums = Arrays.copyOfRange(nums, n >> 1, nums.length);
        int max_right = fun3(rightNums);

        //计算中间的最大子序和，从右到左计算左边的最大子序和，从左到右计算右边的最大子序和，再相加
        int max_l = nums[n / 2 - 1];
        int tmp = 0;
        for (int i = n / 2 - 1; i >= 0; i--) {
            tmp += nums[i];
            max_l = Math.max(tmp, max_l);
        }
        int max_r = nums[n / 2];
        tmp = 0;
        for (int i = n / 2; i < n; i++) {
            tmp += nums[i];
            max_r = Math.max(tmp, max_r);
        }
        //返回三个中的最大值
        return Math.max(max_right, Math.max(max_left, max_l + max_r));
    }

    //动态规划
    public static int fun2(Integer[] nums) {
        int pre = 0, max = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static int fun1(Integer[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            //自己找最大值
            if (nums[0] < nums[i])
                nums[0] = nums[i];
        }
        return nums[0];
//        return Collections.max(Arrays.asList(nums));
    }
}
