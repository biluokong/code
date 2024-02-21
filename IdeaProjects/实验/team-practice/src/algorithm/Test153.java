package algorithm;

public class Test153 {
    public static void main(String[] args) {
        int[] nums = Utils.getInputToIntArray();
        System.out.println(fun1(nums));
    }

    //分治 - 递归方法
    public static int fun1(int[] nums) {
        return searchMin(nums, 0, nums.length - 1);
    }

    private static int searchMin(int[] nums, int left, int right) {
        if (nums[right] >= nums[left])
            return nums[left];
        int mid = (left + right) >> 1;
        return Math.min(searchMin(nums, left, mid), searchMin(nums, mid + 1, right));
    }
}
