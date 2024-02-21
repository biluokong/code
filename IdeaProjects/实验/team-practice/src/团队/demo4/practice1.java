package 团队.demo4;

import java.util.Scanner;
import java.util.Stack;

public class practice1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入只含 “()”、“[]”、“{}”的字符串：");
        String str = input.nextLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else{
                if (stack.empty() || !((ch == ')' && stack.peek() == '(') || (ch == ']' && stack.peek() == '[') || (ch == '}' && stack.peek() == '{'))){
                    System.out.println(false);
                    return;
                }
                else
                    stack.pop();
            }
        }
        if (stack.empty())
            System.out.println(true);
        else
            System.out.println(false);
    }
}
