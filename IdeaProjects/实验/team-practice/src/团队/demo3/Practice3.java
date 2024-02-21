package 团队.demo3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 题目三：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2-abc、3-def、4-ghi、5-jkl、6-mno、7-pqrs、8-tuv、9-wxyz
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class Practice3 {
    private static HashMap<Character, String> mapping = new HashMap<>();
    private static List<String> res = new ArrayList<>();   //储存最终所有的组合结果
    private static String current = "";
    private static int deep = -1;

    //初始方法（效率低，逻辑复杂），回溯算法
    public static void arrange(String str, int j, String last) {
        if (str.length() == 0) {
            res.add(current);
            if (deep != -1){
                if (j == last.length() - 1)
                    current = current.substring(0, deep - 1);
                else
                    current = current.substring(0, deep);
            }
            return;
        }
        deep++;
        String t = mapping.get(str.charAt(0));
        str = str.substring(1);
        for (int i = 0; i < t.length(); i++) {
            current += t.charAt(i);
            arrange(str, i, t);
        }
        deep--;
        if (deep > 0 && j == last.length() - 1)
            current = current.substring(0, deep - 1);
    }

    //该进方法，提高效率
    //使用字符串数组比使用map更节省内存
    private static String[] map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void arrangeCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return;
//        arrange(digits, new StringBuilder(), 0);
        arrange(digits);
    }

    //回溯算法
    public static void arrange(String digits, StringBuilder cur, int index) {
        if (index == digits.length()) {
            res.add(cur.toString());
            return;
        }
        int pos = digits.charAt(index) - '0';
        String t = map[pos];
        for (int i = 0; i < t.length(); i++) {
            cur.append(t.charAt(i));
            arrange(digits, cur, index + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    //用队列实现（根据队列先进先出的性质）
    public static void arrange(String digits) {
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String str = map[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String t =     res.remove(0);
                for (int k = 0; k < str.length(); k++) {
                    res.add(t + str.charAt(k));
                }
            }
        }
    }

    public static void main(String[] args) {
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入仅包含数字 2-9 的字符串：");
        //arrange(input.nextLine(), 0, "");
        arrangeCombinations(input.nextLine());
        for (int i = 0; i < res.size(); i++) {
            if (i % 9 == 0)
                System.out.println();
            System.out.print(res.get(i) + " ");
        }
    }
}
