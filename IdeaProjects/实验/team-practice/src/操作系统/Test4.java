package 操作系统;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] available = new int[3];   // ABC三种资源的可用资源量
        int[] availableTemp = new int[3];
        HashMap<String, Integer> name = new HashMap<>(5);  // 进程名称
        int[][] allocation = new int[5][3]; // 进程已分得的资源
        int[][] need = new int[6][3];  // 进程运行还需要的资源
        boolean[] finish = new boolean[5];  // 进程是否完成
        for (int i = 0; i < 3; i++)
            availableTemp[i] = available[i] = input.nextInt();
        for (int i = 0; i < 5; i++) {
            name.put(input.next(), i);
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++)
                temp[j] = input.nextInt();
            for (int j = 0; j < 3; j++) {
                allocation[i][j] = input.nextInt();
                need[i][j] = temp[j] - allocation[i][j];
            }
        }
        ArrayList list = new ArrayList<>();
        Integer index = name.get(input.next());
        for (int i = 0; i < 3; i++)
            need[5][i] = input.nextInt();
        if (index == null || need[5][0] > need[index][0] || need[5][1] > need[index][1] || need[5][2] > need[index][2]) {
            System.out.print(false);
            return;
        }
        boolean flag = false, first = true;
        if (need[5][0] <= available[0] && need[5][1] <= available[1] && need[5][2] <= available[2]) {
            for (int j = 0; j < 3; j++) {
                need[index][j] -= need[5][j];
                allocation[index][j] += need[5][j];
                available[j] -= need[5][j];
            }
            flag = true;
        }
        for (int k = 0;k < 2; k++) {
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    if (!finish[i] && need[i][0] <= available[0] && need[i][1] <= available[1]
                            && need[i][2] <= available[2]) {
                        finish[i] = true;
                        available[0] += allocation[i][0];
                        available[1] += allocation[i][1];
                        available[2] += allocation[i][2];
                        break;
                    }
                }
            }
            for (int i = 0; i < 5; i++) {
                if (!finish[i]) {
                    first = false;
                    if (flag) {
                        for (int i1 = 0; i1 < 3; i1++) {
                            available[i1] = availableTemp[i1];
                            need[index][i1] += need[5][i1];
                            allocation[index][i1] -= need[5][i1];
                        }
                        for (int i1 = 0; i1 < 5; i1++)
                            finish[i1] = false;
                        flag = false;
                        break;
                    }
                    System.out.print(false);
                    return;
                }
            }
            if (first)
                break;
        }
        System.out.print(true);
    }

    public static void test() {
        Scanner input = new Scanner(System.in);
        int[] available = new int[3];
        HashMap<String, Integer> name = new HashMap<>(5);
        int[][] allocation = new int[5][3];
        int[][] need = new int[6][3];
        boolean[] finish = new boolean[5];
        for (int i = 0; i < 3; i++)
            available[i] = input.nextInt();
        for (int i = 0; i < 5; i++) {
            name.put(input.next(), i);
            int[] temp = new int[3];
            for (int j = 0; j < 3; j++)
                temp[j] = input.nextInt();
            for (int j = 0; j < 3; j++) {
                allocation[i][j] = input.nextInt();
                need[i][j] = temp[j] - allocation[i][j];
            }
        }
        int index = name.get(input.next());
        for (int i = 0; i < 3; i++)
            need[5][i] = input.nextInt();
        if ((need[5][0] > need[index][0] || need[5][1] > need[index][1] || need[5][2] > need[index][2])
                || (need[5][0] > available[0] || need[5][1] > available[1] || need[5][2] > available[2])) {
            System.out.print(false);
            return;
        }
        for (int j = 0; j < 3; j++) {
            need[index][j] -= need[5][j];
            allocation[index][j] += need[5][j];
            available[j] -= need[5][j];
        }
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                if (!finish[i] && need[i][0] <= available[0] && need[i][1] <= available[1]
                        && need[i][2] <= available[2]) {
                    finish[i] = true;
                    available[0] += allocation[i][0];
                    available[1] += allocation[i][1];
                    available[2] += allocation[i][2];
                    break;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!finish[i]) {
                System.out.print(false);
                return;
            }
        }
        System.out.print(true);
    }
}