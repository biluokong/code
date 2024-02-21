package 团队.demo11;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Practice2 {

    public static void main(String[] args) {
        //因为1<n<104，则完全平方数有1、4、9、16、25、36、49、64、81、100
        int[] nums = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        Scanner input = new Scanner(System.in);
        int num = input.nextInt(), sum = 0, star = 0, t = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        for (star = nums.length - 1; star >= 0; star--)
            if (nums[star] <= num)
                break;
        t = star;
        while (star >= 0) {
            queue.add(star);
            sum += nums[star];
            if (sum == num)
                break;
            if (sum > num) {
                star = queue.remove() - 1;
                sum -= nums[star + 1];
            }
        }
        sum = 0;
        star = t;
        while (star >= 0) {
            stack.push(star);
            sum += nums[star];
            if (sum == num)
                break;
            if (sum > num) {
                star = stack.pop() - 1;
                sum -= nums[star + 1];
            }
        }
        System.out.println(queue.size() > stack.size() ? stack.size() : queue.size());
    }
}
