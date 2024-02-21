package algorithm;

public class Test121 {
    public static void main(String[] args) {
        int[] nums = Utils.getInputToIntArray();
        System.out.println(fun2(nums));
    }

    public static int fun2(int[] nums) {
        int maxProfit = 0, start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curProfit = nums[i] - start;
            if (curProfit < 0)
                start = nums[i];
            else if (curProfit > maxProfit)
                maxProfit = curProfit;
        }
        return maxProfit;
    }

    public static int fun1(int[] nums) {
        int maxProfit = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int curProfit = nums[j] - nums[i];
                if (curProfit > maxProfit)
                    maxProfit = curProfit;
            }
        }
        return maxProfit;
    }
}
