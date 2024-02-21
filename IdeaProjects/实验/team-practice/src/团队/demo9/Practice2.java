package 团队.demo9;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        do {
            int num = input.nextInt();
            nums.add(num * num);
        } while (nums.get(nums.size() - 1) != 10000);
        nums.remove(nums.size() - 1);
        int result[] = new int[nums.size()], left = 0, right = nums.size() - 1, index = right;
        while (left < right){
            if (nums.get(left) >= nums.get(right))
                result[index--] = nums.get(left++);
            else
                result[index--] = nums.get(right--);
        }
        result[index] = nums.get(left);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
