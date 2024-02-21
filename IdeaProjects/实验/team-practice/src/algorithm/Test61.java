package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Test61 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer value : map.values()) {

        }
    }

    public static void fun1() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String s = input.nextLine();
        String[] nums = s.substring(1, s.length() - 1).split(",");
        for (String num : nums) {
            list.add(Integer.valueOf(num));
        }
        int step = input.nextInt();

        LinkedList<Object> result = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            int index = (i + step) % list.size();
            if (index > result.size())
                result.addLast(list.get(i));
            else
                result.add(index, list.get(i));
        }
        result.forEach(i -> System.out.print(i + " "));
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
