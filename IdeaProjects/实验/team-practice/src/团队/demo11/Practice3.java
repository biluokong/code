package 团队.demo11;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Practice3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        int k = input.nextInt();
        String regex = "[a-z]{0," + k + "}", result = "";
        Matcher matcher = Pattern.compile(regex).matcher(s);
        ArrayList<String> list = new ArrayList<>();
        while (matcher.find())
            list.add(matcher.group(0));
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0)
                result += new StringBuilder(list.get(i)).reverse();
            else
                result += list.get(i);
        }
        System.out.println(result);
    }
}
