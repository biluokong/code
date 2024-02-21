package 团队.demo1;

import java.util.Scanner;
import java.util.Stack;

/*
·1. 给你一个仅由数字 6 和 9 组成的正整数 num。
你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
请返回你可以得到的最大数字。
 */
public class Practice1 {
    public static void main(String[] args) {
        fun2();
    }

    public static void fun2() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个只含6或9的正整数：");
        StringBuilder num = new StringBuilder(input.nextLine());
        input.close();
        int count = 0;
        while (count != num.length()) {
            if (num.charAt(count) == '6') {
                num.delete(count, count + 1);
                num.insert(count, '9');
                break;
            }
            count++;
        }
        System.out.println(num);
    }

    public static void fun1() {
        Stack<Long> nums = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个只含6或9的正整数：");
        long num = input.nextLong();
        input.close();
        while (num / 10 != 0 ) {
            nums.push(num % 10);
            num /= 10;
        }
        nums.add(num % 10);
        num = 0;
        boolean flag = true;
        while (!nums.empty()) {
            num *= 10;
            if (flag && nums.peek() == 6) {
                nums.pop();
                num += 9;
                flag = false;
            } else
                num += nums.pop();
        }
        System.out.println("最大的数字为：" + num);
    }
}
