package algorithm;

import java.util.HashMap;

public class Test860 {
    public static void main(String[] args) {
        int[] nums = Utils.getInputToIntArray();
        System.out.println(fun1(nums));
    }

    public static boolean fun1(int[] bills) {
        int five = 0, ten = 0;
        for (int num : bills) {
            if (num == 5)
                five++;
            else if (num == 10) {
                ten++;
                five--;
            } else {
                if (ten > 0) {
                    ten--;
                    five--;
                } else
                    five -= 3;
            }
            if (five < 0)
                return false;
        }
        return true;
    }
}
