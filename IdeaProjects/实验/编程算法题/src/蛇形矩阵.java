import java.util.Scanner;

public class 蛇形矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入行数：");
        int row = sc.nextInt();
        int[][] matrix = new int[row][row];
        int num = 0;

        //填补数字到蛇形矩阵中
        for (int i = 0; i < row * 2 - 1; i++) {
            for (int j = 0; j <= i; j++) {

                //奇数斜行
                if (i % 2 == 0) {

                    //在合法行数内，这样只能填补出上三角部分的数
                    if (i < row) {
                        matrix[j][i - j] = ++num;
                    //填补下三角部分的数
                    //虽超过了所需行数，但填补数字的规律一样，将原斜行往下移一行就是合理的了，但要注意不要越界
                    } else if (j + 1 < row && i - j - 1 < row) {
                        matrix[j + 1][i - j - 1] = ++num;
                    }

                //偶数斜行
                } else {
                    //在合法行数内，这样只能填补出上三角部分的数
                    if (i < row) {
                        matrix[i - j][j] = ++num;
                    //填补下三角部分的数
                    //虽超过了所需行数，但填补数字的规律一样，将原斜行往上移一行就是合理的了，但要注意不要越界
                    } else if (i - j - 1 < row && j + 1 < row) {
                        matrix[i - j - 1][j + 1] = ++num;
                    }
                }
            }
        }

        //遍历输出
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
