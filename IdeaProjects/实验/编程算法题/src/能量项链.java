import java.util.Scanner;

public class 能量项链 {
    static int arrays[] = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arrays = new int[n];
        int dp[][] = new int[n][n];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = scanner.nextInt();
        }
        //l 是子问题的珠子数
        for (int l = 2;l <= n ; l++) {
            for (int i = 0; i < n; i++) {
                int j = (i+l-1) % n;
                for (int k = i ; k < i + l - 1; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k%n] + dp[(k+1)%n][j] + p(i,(k+1)%n,(j+1)%n));
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i][(i+n-1)%n], max);
        }
        System.out.println(max);
    }
    //计算组合成新的能量
    public static int p(int i,int k,int j) {
        return arrays[i]*arrays[k]*arrays[j];
    }
}
