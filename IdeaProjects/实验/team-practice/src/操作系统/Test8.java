package 操作系统;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cylinderNum = input.nextInt(), num = input.nextInt();  // 当前柱面号和请求个数
        ArrayList<Integer> sequence = new ArrayList<>();  // 请求的柱面序列
        for (int i = 0; i < num; i++)
            sequence.add(input.nextInt());
        int direction = input.nextInt();    // 移动臂移动方向
        Collections.sort(sequence);
        for (int i = 0, count = 0, flag = 0;; ) {
            if (flag == 0 && sequence.get(i) < cylinderNum)
                i++;
            if (flag == 0 && sequence.get(i) >= cylinderNum) {
                flag = 1;
                if (direction == -1 && i != 0)
                    i--;
            }
             if (flag == 1) {
                System.out.print(sequence.remove(i) + " ");
                count++;
                if (count == num)
                    break;
                if (direction == -1) {
                    if (i == 0)
                        direction = 1;
                    else
                        i--;
                } else if (i == sequence.size())
                    i--;
            }
        }
    }
}
