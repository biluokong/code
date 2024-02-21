package 团队.demo12;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt(), count = 0, temp = num;
        while (temp != 0) {
            if (num % (temp % 10) == 0)
                count++;
            temp /= 10;
        }
        System.out.println(count);
    }
}
