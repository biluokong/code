package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Utils {
    private static final Scanner input = new Scanner(System.in);

    public static Integer[] getInput() {
        String[] numStr = input.nextLine().split(",");
        Integer[] nums = Arrays.stream(numStr).map(Integer::valueOf).toArray(Integer[]::new);
        return nums;
    }

    public static int[] getInputToIntArray() {
        Integer[] nums = getInput();
        int[] nums_tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            nums_tmp[i] = nums[i];
        return nums_tmp;
    }

    public static double[] getInputToDoubleArray() {
        String[] numStr = input.nextLine().split(",");
        double[] nums = new double[numStr.length];
        for (int i = 0; i < numStr.length; i++) {
            nums[i] = Double.parseDouble(numStr[i]);
        }
        return nums;
    }

    public static int[][] getInputToTwoIntArray() {
        String[] numStr = input.nextLine().split(" ");
        int[][] nums = new int[numStr.length][];
        for (int i = 0; i < numStr.length; i++) {
            String[] temp = numStr[i].split(",");
            int[] num = new int[temp.length];
            for (int j = 0; j < temp.length; j++)
                num[j] = Integer.parseInt(temp[j]);
            nums[i] = num;
        }
        return nums;
    }

    public static int getInt() {
        return input.nextInt();
    }

    public static void getNullLine() {
        input.nextLine();
    }
}
