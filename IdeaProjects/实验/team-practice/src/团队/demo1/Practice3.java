package 团队.demo1;

import java.util.HashMap;
import java.util.Scanner;

/*
3. 两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，
并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class Practice3 {
    public static void main(String[] args) {
        //方法3：用散列表：HashSet，其查找元素的时间复杂度为O(1) （本质是使用了哈希查找法）
        fun2();
    }
    //方法2：类型哈希查找
    public static void fun2() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想输入整数的个数：");
        int n = input.nextInt();
        Integer[] nums = new Integer[n];
        System.out.println("请输入" + n + "个整数：");
        for (int i = 0; i < n; i++)
            nums[i] = input.nextInt();
        System.out.println("请输入目标值target：");
        int target = input.nextInt();
        input.close();
        HashMap<Integer, Integer>[] list = new HashMap[2];
        list[0] = new HashMap<>();
        list[1] = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            list[0].put(nums[i], -1);
            if (list[0].get(nums[i]) != -1)
                list[1].put(nums[i], i);
            else
                list[0].put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (list[0].get(temp) != null && list[0].get(temp) == i) {
                if (list[1].get(temp) != null) {
                    System.out.println("[" + i + "," + list[1].get(temp) + "]");
                    break;
                }
            } else if (list[0].get(temp) != null && list[0].get(temp) != -1){
                System.out.println("[" + i + "," + list[0].get(temp) + "]");
                break;
            }
        }
    }
    //方法2：先用一些时间复杂度低于O(n^2)的排序算法进行排序，再用二分查找、插值查找法等查找算法
    public static void fun1() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想输入整数的个数：");
        int n = input.nextInt();
        int[][] nums = new int[n][2];
        System.out.println("请输入" + n + "个整数：");
        for (int i = 0; i < n; i++){
            nums[i][0] = input.nextInt();
            nums[i][1] = i;
        }
        System.out.println("请输入目标值target：");
        int target = input.nextInt();
        input.close();
        //先排序：用希尔排序法
        for (int i = 3; i > 0; i--) {
            int step = (int) Math.pow(2, i) - 1;
            for (int j = 1; j < nums.length; j++) {
                int[] temp = nums[j];
                int k = j - step;
                for (; k >= 0 && temp[0] < nums[k][0]; k -= step)
                    nums[k + step] = nums[k];
                nums[k + step] = temp;
            }
        }
        //插值查找
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i][0];
            int low = i + 1, high = nums.length - 1, mid = 0;
            while (low <= high) {
                if (nums[high] == nums[low])
                    mid = low + (high - low) / 2;
                else
                    mid = low + (temp - nums[low][0]) / (nums[high][0] - nums[low][0]) * (high - low);
                if (temp > nums[mid][0])
                    low = mid + 1;
                else if (temp < nums[mid][0])
                    high = mid - 1;
                else {
                    System.out.println("[" + nums[i][1] + "," + nums[mid][1] + "]");
                    return;
                }
            }
        }
    }
}
