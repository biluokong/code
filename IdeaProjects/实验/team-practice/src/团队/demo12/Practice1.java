package 团队.demo12;

import java.util.Scanner;

public class Practice1 {
    public static int compare(int a, int b) {
        if ((a == 0 && (b == 2 || b == 3)) || (a == 1 && (b == 0 || b == 3)) ||
                (a == 2 && (b == 2 || b == 4)) || (a == 3 && (b == 2 || b == 4)) ||
                (a == 4 && (b == 0 || b == 1)))
            return 1;
        if ((a == 0 && (b == 1 || b == 4)) || (a == 1 && (b == 2 || b == 4)) ||
                (a == 2 && (b == 0 || b == 3)) || (a == 3 && (b == 0 || b == 1)) ||
                (a == 4 && (b == 2 || b == 3)))
            return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt(), Na = input.nextInt(), Nb = input.nextInt();
        int[] A = new int[Na];
        int[] B = new int[Nb];
        int scoreA = 0, scoreB = 0, countA = 0, countB = 0;
        for (int i = 0; i < Na; i++)
            A[i] = input.nextInt();
        for (int i = 0; i < Nb; i++)
            B[i] = input.nextInt();
        for (int i = 0; i < N; i++) {
            if (compare(A[countA], B[countB]) == 1)
                scoreA++;
            else if (compare(A[countA], B[countB]) == -1)
                scoreB++;
            countA++;
            countB++;
            if (countA == Na)
                countA = 0;
            if (countB == Nb)
                countB = 0;
        }
        System.out.println(scoreA + " " + scoreB);
    }
}