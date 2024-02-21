package algorithm;

public class Test45 {
    public static void main(String[] args) {
        int[] nums = Utils.getInputToIntArray();

    }

    public static int fun1(int[] nums) {
        int maxPos = 0;     //记录从0到当前位置，所能跳到的最远位置
        int step = 0;       //步数
        int end = 0;        //表示当前位置之前所能跳到的最远距离
        // 这里的i表示从下标值为i的地方起跳
        // i<nums.length-1，因为nums.length-1表示最后一个位置的下标值，不需要从最后一个位置起跳
        for (int i = 0; i < nums.length - 1; i++) {//
            // i+nums[i]表示从当前位置起跳，所能跳到的最远位置
            //若从当前位置起跳，可以跳到 比该位置之前的所有位置起跳 更远的距离，则更新maxPos
            maxPos = Math.max(maxPos, i + nums[i]);
            //如果当前位置，是当前位置之前所能跳到的最远距离，说明需要从当前位置起跳了，并更新步数
            if (i == end) {
                step++;
                end = maxPos;   //重新记录当前位置所能跳到的最远距离。
            }
        }
        return step;
    }
}
