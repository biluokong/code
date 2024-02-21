package 实验四数组;

import java.util.Scanner;

/**
 * 输入20个整数到数组中;
 * 并对20个数按从大到小的顺序排序，输出排序后的数组;
 * 再输入一个整数x;
 * 并在数组中查找x。如果找到了输出x在数组中的下标，找不到输出-1
 */
public class Test01 {
    public static void main(String[] args) {
        int[] a = new int[20];
        inPut(a);
        System.out.println();
        sortInt(a);
        System.out.println(find(a));
    }

    /**
     * 获得从键盘输入的整数，并放到传入的整数数组参数a中
     * @param a
     */
    public static void inPut(int[] a) {
        System.out.println("请输入" + a.length + "个整数：");
        Scanner input = new Scanner(System.in); //创建扫描仪
        for (int i = 0; i < a.length; i++) {    //循环读取从键盘输入的整数
            a[i] = input.nextInt();
        }
        System.out.println("要进行排序的数为：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 分类——内部比较排序、自然排序、串行排序、交换排序、原地排序
     * 数据结构——数组
     * 最差时间复杂度——O(n^2)
     * 最优时间复杂度——O(n)
     * 平均时间复杂度——O(n^2)
     * 所需辅助空间——O(1)
     * 稳定性——稳定
     * @param a 要排序的数组
     */
    public static void sortInt(int[] a) {
        boolean flag = true;   //定义一个判断是否发生交换的标志

        //最多只需n-1轮排序即可排好序
        for (int i = 0; i < a.length - 1 && flag; i++) {
            flag = false;   //每次循环重新初始化标志

            //每一轮排序后总能找出剩下元素中最大的元素放到后面，后面排好序的元素在下一轮排序时不再参加比较
            for (int j = 0; j < a.length - i - 1; j++) {	    //依次比较相邻的两个元素，使较小的那个往后移

                //若当前元素小于比较元素，则交换两元素的位置
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;    //方生了交换，置flag为true
                }
            }
        }
        System.out.println("排序的结果为：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 在整数数组a中查找元素x，x有用户从键盘输入。若找到了则返回该数下标；如没找到，则返回-1
     * @param a
     * @return the element type of int
     */
    public static int find(int[] a) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n请输入您要查找的整数x：");
        int x = input.nextInt();
        input.close();
        for (int i = 0; i < a.length; i++) {    //线性查找法，从下标为0处一直往后找
            if (a[i] == x) {
                System.out.println("已找到该元素！\n其下标为：");
                return i;
            }
        }
        System.out.println("未找到该元素！");;
        return -1;
    }
}