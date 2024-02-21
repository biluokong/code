import java.util.Scanner;

public class 波动数组dp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long s = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        long mod = 100000007;
        long dp[] = new long[n*(n-1)/2+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= n-1 ; i++) {
            for (int j = i*(1+i)/2; j >= i; j--) {
                dp[j] = (dp[j] + dp[j-i])%mod;
            }
        }
        long y = 0;
        long ans = 0;
        int sum = n*(n-1)/2;
        for(y=0;y<= sum;y++)
        {
            if( (s-(y*a)+((sum-y)*b) ) %n == 0 )
                ans = ( ans + dp[(int) y] )%mod;
        }
        System.out.println(ans);
        scan.close();
    }
}
