package 团队.demo7;

import java.util.*;

public class Practice3 {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = input.next();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashMap.get(ch) == null)
                hashMap.put(ch, 1);
            else
                hashMap.put(ch, hashMap.get(ch) + 1);
        }
        hashMap.values().stream().sorted(Comparator.reverseOrder()).forEach(integer -> {
            Iterator<Character> iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()){
                Character next = iterator.next();
                if (hashMap.get(next) == integer) {
                    System.out.println(next + ":" + integer);
                    iterator.remove();
                }
            }
        });
    }
}
