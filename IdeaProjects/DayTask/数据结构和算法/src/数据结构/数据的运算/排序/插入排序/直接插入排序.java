package 数据结构.数据的运算.排序.插入排序;

import java.util.Scanner;

/**
 * 顺序法定位插入位置，需定义一个临时变量储存新值，且比较过程中需判断是否出界
 */
public class 直接插入排序 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您想要排序的数的个数：");
        int n = input.nextInt();

        int[] array = new int[n];
        System.out.println("请输入" + n + "个数：");
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }

        int j = 0;
        for (int i = 1; i < array.length; i++) {    //第一张牌不用比较，从拿到第二张牌开始，每趟循环拿到一张新牌
            int temp = array[i];    //把当前新牌取出来，与手里的牌进行比较（用临时变量取是因为当牌往后移动时会覆盖新牌的位置）
            //用新牌从最后一张牌开始比较，若小于当前比较牌，则新牌应放在前面，所有要将当前牌往后移一位给新牌腾位置，
            for (j = i - 1; j >= 0 && temp < array[j] ; j--) {
                array[j + 1] = array[j];
            }
            // 直到新牌大于当前牌，说明新牌就该放在当前比较的牌后面
            array[j + 1] = temp;
        }

        selectSort(input, array);
    }

    public static void selectSort(Scanner input, int[] array) {
        System.out.println("请选择排序方式：\n1、升序\n2、降序");
        int select = input.nextInt();
        input.close();

        System.out.println("排序结果为：");
        if (select == 1) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        } else if (select == 2) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[array.length - 1 - i] + " ");
            }
        } else {
            System.out.println("非法的输入！");
        }
    }
}
