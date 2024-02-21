package 数据结构.数据的运算.排序.插入排序;

import java.util.Scanner;

/**
 * 使用“哨兵”，不用再定义一个临时变量用来储存新元素，且不用再判断是否有出界的可能
 */
public class 改进的直接插入排序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要排序的数的个数：");
        int n = input.nextInt() + 1;

        int[] array = new int[n];
        System.out.println("请输入" + (n - 1) + "个数：");
        for (int i = 1; i < n; i++) {
            array[i] = input.nextInt();
        }

        int j = 0;
        for (int i = 2; i < array.length; i++) {
            array[0] = array[i];    //用哨兵储存新牌
            for (j = i - 1; array[0] < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = array[0];
        }

        selectSort(input, array);
    }

    public static void selectSort(Scanner input, int[] array) {
        System.out.println("请选择排序方式：\n1、升序\n2、降序");
        int select = input.nextInt();
        input.close();

        System.out.println("排序结果为：");
        if (select == 1) {
            for (int i = 1; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        } else if (select == 2) {
            for (int i = 1; i < array.length; i++) {
                System.out.print(array[array.length - i] + " ");
            }
        } else {
            System.out.println("非法的输入！");
        }
    }
}
