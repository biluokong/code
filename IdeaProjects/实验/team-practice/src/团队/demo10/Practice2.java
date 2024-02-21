package 团队.demo10;

import java.util.Scanner;

public class Practice2 {
    public static int romanToInt(String s) {

        int sum = 0;
        char[] ch = s.toCharArray();

        for (int i = ch.length-2; i >=0 ; i--) {
            int j = i+1;
            if (getValue(ch[j])>getValue(ch[i])){
                sum = sum - getValue(ch[i]);
            }
            else if (getValue(ch[j]) <= getValue(ch[i])){
                sum = sum + getValue(ch[i]);
            }

        }
        sum = sum + getValue(ch[ch.length-1]);
        return sum;
    }

    private static int getValue(char ch){
        switch(ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default: return 0;

        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(romanToInt(input.next()));
    }
}
