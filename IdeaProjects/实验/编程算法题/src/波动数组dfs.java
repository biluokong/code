import java.util.Scanner;

public class 波动数组dfs {
    private static int vu = 0;
    private static int[] a;
    private static int[][] v = new int[1004][2];
    private static int mac = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), s = input.nextInt(), c = input.nextInt(), b = input.nextInt();
        a = new int[]{c, -b};
        for (int i = 1; i < 1000000; i++) {
            mac = i;
            dfs(i, 1, n, s);
        }
        System.out.println(vu % 100000007);
    }

    private static void dfs(int mun, int count, int n, int s) {
        if (mac == s && count == n) {
            vu++;
            return;
        } else if (count == n) {
            return;
        } else {
            for (int i = 0; i < 2; i++) {
                if (v[count][i] == 0) {
                    v[count][i] = 1;
                    mac += mun + a[i];
                    dfs(mun + a[i], count + 1, n, s);
                    mac -= mun + a[i];
                    v[count][i] = 0;
                }
            }
        }
    }
}