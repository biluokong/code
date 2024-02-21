package algorithm;

import java.util.Random;

public class Test215 {
    public static void main(String[] args) {
        int[] nums = Utils.getInputToIntArray();
        int k = Utils.getInt();
        System.out.println(fun1(nums, k));
    }

    public static int fun1(int[] nums, int k) {
        int target = nums.length - k;   //第k大数的下标
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot == target)
                return nums[pivot];
            else if (pivot < target)
                left = pivot + 1;
            else
                right = pivot - 1;
        }
    }

    private final static Random random = new Random(System.currentTimeMillis());

    private static int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        int temp = nums[left];
        nums[left] = nums[randomIndex];
        nums[randomIndex] = temp;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
