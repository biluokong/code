package algorithm;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        System.out.println(fun1(str));
    }

    private static String fun1(String str) {
        boolean flag;
        String result = "" + str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length() - 1; j > i; j--) {
                int mid = (i + j) / 2;
                flag = true;
                if (str.charAt(i) == str.charAt(j)) {
                    for (int m = i + 1, n = j - 1; m <= mid; m++, n--) {
                        if (str.charAt(m) != str.charAt(n)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag && j - i + 1 > result.length()) {
                        result = str.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}
