package algorithm;

import java.util.Scanner;

public class Test70 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n <= 3) {
            System.out.println(n);
            return;
        }
        int p, q = 1, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        System.out.println(r);
    }

    static int fun1(int n) {
        if (n <= 3)
            return n;
        return fun1(n - 1) + fun1(n - 2);
    }

    static int fun2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 3)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    static int fun3(int n) {
        if (n <= 3)
            return n;
        int p, q = 1, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
