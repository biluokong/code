package 团队.demo7;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数字（输入-1结束）：");
        while (true) {
            int data = input.nextInt();
            if (data == -1)
                break;
            if (list.indexOf(data) != -1)
                nums.add(data);
            else
                list.add(data);
        }
        list.removeAll(nums);
        list.forEach(integer -> System.out.print(integer + " "));
    }
}
