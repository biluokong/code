package algorithm;

public class Test213 {
    public static void main(String[] args) {
        int[] nums = Utils.getInputToIntArray();
        System.out.println(fun1(nums));
    }

    public static int fun3(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp1 = new int[2], dp2 = new int[2];   // dp1不抢n-1,dp2不抢0
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[1], nums[0]);
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i <= n - 2; i++) {
            int temp = dp1[1];
            dp1[1] = Math.max(dp1[0] + nums[i], dp1[1]);
            dp1[0] = temp;
        }
        for (int i = 3; i <= n - 1; i++) {
            int temp = dp2[1];
            dp2[1] = Math.max(dp2[0] + nums[i], dp2[1]);
            dp2[0] = temp;
        }
        return Math.max(dp1[1], dp2[1]);
    }

    public static int fun2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp1 = new int[n], dp2 = new int[n];   // dp1不抢n-1,dp2不抢0
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[1], nums[0]);
        dp2[1] = nums[1];
        for (int i = 2; i < n; ++i) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }

    // 在大于2的情况下，首和尾不能同时选，分成两种情况：
    // 不选尾则可选 [0, len - 2]、不选首则可选 [1, len - 1]
    public static int fun1(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    private static int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
