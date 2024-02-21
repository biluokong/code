package 实验四数组;

import java.util.Scanner;

/**
 * 有M个人围成一圈，每人一个的编号（1.2.3.....M），从第一个人数起，报到N时这个人就出圈。再继续数，
 * 数到N时这个人又出圈。直到只剩下一个人为止，输出出圈人的顺序。M、N从键盘输入
 */
public class Test04 {
    public static void main(String[] args) {

        Scanner iput = new Scanner(System.in);  //创建扫描仪
        System.out.println("请输入人数M和出圈数N:");
        int M = iput.nextInt();     //获得总人数
        int N = iput.nextInt();     //获得出圈数
        iput.close();   //关闭扫描仪
        int[] a = new int[M];

        //给M个人编号，从1到 M
        for (int i = 0; i < M; i++) {
            a[i] = i + 1;
        }

        int count = 0;  //定义计数器
        int flag = 0;   //定义标志，来判断是否只剩一个人没有出圈
        System.out.println("出圈人的顺序为：");
        while (true) {
            flag = 0;   //每次循环，置标志值为0
            for (int i = 0; i < M; i++) {
                if (a[i] != 0) {    //若此编号的人还在圈内，计数器+1
                    count++;
                    if (count == N) {   //计数到了N，就让此人出圈
                        System.out.print(a[i] + " ");
                        a[i] = 0;
                        count = 0;  //人一出圈，则置计数器值为0，重新计数
                    }
                } else {    //如果此编号的人已出圈，则让标志加1
                    flag++;
                }
            }
            if (flag == M - 1) {    //若只剩一人，即标志的值为 M-1 时，结束循环
                break;
            }
        }
    }
}
