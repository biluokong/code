package 操作系统;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] processName = new String[3];  //进程名
        int[][] priority = new int[3][2];    // 进程优先级
        int[] runTime = new int[3]; // 进程运行时间
        System.out.println("请输入3个进程的名称、优先级和运行时间(3行，空格分隔)：");
        for (int i = 0; i < 3; i++) {
            processName[i] = input.next();
            priority[i][0] = input.nextInt();
            priority[i][1] = i; // 存储下标
            runTime[i] = input.nextInt();
        }
        double averageTurnaroundTime = 0, t = 0;
        for (int i = 0; i < 3; i++) {
            int k = i;
            for (int j = i + 1; j < 3; j++) {
                if (priority[j][0] > priority[k][0])
                    k = j;
            }
            t += runTime[priority[k][1]];
            priority[k] = priority[i];
            averageTurnaroundTime += t;

        }
        System.out.printf("平均周转时间为：%.1f", averageTurnaroundTime/3);
    }
}
