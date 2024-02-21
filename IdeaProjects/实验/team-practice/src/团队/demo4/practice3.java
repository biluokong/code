package 团队.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class practice3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        List<long[]> longList = new ArrayList<>();
        System.out.println("请输入一个整数数组（输入-600000停止）：");
        do {
            list.add(input.nextLong());
        } while (list.get(list.size() - 1) != -600000L);
        list.remove(list.size() - 1);
        Long sum = 0L;
        for (int i = 0; i < list.size() - 2; i++) {
            long num1 = list.get(i);
            sum += num1;
            for (int j = i + 1; j < list.size() - 1; j++){
                long num2 = list.get(j);
                sum += num2;
                for (int k = j + 1; k < list.size(); k++){
                    long num3 = list.get(k);
                    if (sum + num3 == 0){
                        long[] nums = {num1, num2, num3};
                        for (int i1 = 0; i1 < nums.length - 1; i1++) {
                            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                                if (nums[i1] > nums[i2]){
                                    long temp = nums[i1];
                                    nums[i1] = nums[i2];
                                    nums[i2] = temp;
                                }
                            }
                        }
                        boolean flag = true;
                        for (int i1 = 0; i1 < longList.size(); i1++) {
                            long[] longs = longList.get(i1);
                            if (nums[0] == longs[0] && nums[1] == longs[1] && nums[2] == longs[2])
                                flag = false;
                        }
                        if (flag)
                            longList.add(nums);
                    }
                }
                sum -= num2;
            }
            sum -= num1;
        }
        for (long[] longs : longList) {
            System.out.println(longs[0] + " " + longs[1] + " " + longs[2]);
        }
    }
}
