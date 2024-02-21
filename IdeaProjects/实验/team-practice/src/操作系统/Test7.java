package 操作系统;

import java.util.*;

public class Test7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] name = new String[3];
        int[] space = new int[3];
        ArrayList<int[]> sortPriority = new ArrayList<>(3);
        ArrayList<int[]> sortRunTime = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            name[i] = input.next();
            space[i] = input.nextInt();
            sortPriority.add(new int[]{i, input.nextInt(), input.nextInt()});
        }
        sortPriority.sort((x, y) -> y[2] - x[2]);
        int spaceSum = 0, count = 0;
        while (count < 3) {
            for (int[] ints : sortPriority) {
                if (space[ints[0]] + spaceSum <= 100) {
                    spaceSum += space[ints[0]];
                    sortRunTime.add(ints);
                }
            }
            sortRunTime.sort((x, y) -> {
                if (x[1] - y[1] == 0)
                    return name[x[0]].compareTo(name[y[0]]);
                return x[1] - y[1];
            });
            for (int[] process : sortRunTime)
                sortPriority.remove(process);
            count++;
            spaceSum -= space[sortRunTime.get(0)[0]];
            System.out.print(name[sortRunTime.remove(0)[0]] + " ");
        }
    }
}
