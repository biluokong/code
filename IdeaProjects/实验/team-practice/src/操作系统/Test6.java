package 操作系统;

import java.util.ArrayList;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int frequency = input.nextInt();    // 访问页面次数
        int[] pageSequence = new int[frequency];  // 页面访问序列
        for (int i = 0; i < frequency; i++)
            pageSequence[i] = input.nextInt();
        int pageBoxNum = input.nextInt();   // 内存分配的页框数
        int count = 0;  // 缺页中断次数
        ArrayList<Integer> stack = new ArrayList<>();
        for (int pageIndex : pageSequence) {
            if (!stack.contains(pageIndex)) {
                if (stack.size() < pageBoxNum)
                    stack.add(0, pageIndex);
                else {
                    stack.remove(pageBoxNum - 1);
                    stack. add(0, pageIndex);
                }
                count++;
            }
        }
        System.out.print(count);
    }
}
