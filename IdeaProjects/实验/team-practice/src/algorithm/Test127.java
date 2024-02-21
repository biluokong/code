package algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class Test127 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String beginWord = input.nextLine();
        String endWord = input.nextLine();
        List<String> wordList = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
        System.out.println(f2(beginWord, endWord, wordList));
    }

    // 双向bfs
    public static int f3(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> beginQueue = new HashSet<>();
        Set<String> endQueue = new HashSet<>();
        beginQueue.add(beginWord);
        endQueue.add(endWord);
        Set<String> visited = new HashSet<>();
        int step = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginQueue.size() > endQueue.size()) {
                Set<String> temp = beginQueue;
                beginQueue = endQueue;
                endQueue = temp;
            }
            Set<String> tempQueue = new HashSet<>();
            for (String s : beginQueue) {
                if (check(s, wordSet, endQueue, visited, tempQueue)) return step + 1;
            }
            beginQueue = tempQueue;
            step++;
        }
        return 0;
    }
    // 双向bfs
    public static int f2(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) return 0;
        wordList.add(beginWord);
        Set<Integer> beginQueue = new HashSet<>();
        Set<Integer> endQueue = new HashSet<>();
        beginQueue.add(wordList.size() - 1);
        endQueue.add(end);
        boolean[] visited = new boolean[wordList.size()];
        visited[wordList.size() - 1] = true;
        int step = 1;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            if (beginQueue.size() > endQueue.size()) {
                Set<Integer> temp = beginQueue;
                beginQueue = endQueue;
                endQueue = temp;
            }
            Set<Integer> tempQueue = new HashSet<>();
            for (Integer index : beginQueue) {
                if (check(index, wordList, endQueue, visited, tempQueue)) return step + 1;
            }
            beginQueue = tempQueue;
            step++;
        }
        return 0;
    }

    // bfs
    public static int f1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        boolean[] visited = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord), count = 0, size = 0;
        if (index != -1) visited[index] = true;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            size = queue.size();
            count++;
            while (size-- > 0) {
                String currBegin = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited[i]) continue;
                    String checkStr = wordList.get(i);
                    if (!check(currBegin, checkStr)) continue;
                    if (endWord.equals(checkStr)) return count + 1;
                    visited[i] = true;
                    queue.add(checkStr);
                }
            }
        }
        return 0;
    }

    public static boolean check(String curr, Set<String> wordList, Set<String> endQueue,
                                Set<String> visited, Set<String> tempQueue) {
        char[] chars = curr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                chars[i] = j;
                String newStr = String.valueOf(chars);
                if (wordList.contains(newStr)) {
                    if (endQueue.contains(newStr)) return true;
                    if (!visited.contains(newStr)) {
                        tempQueue.add(newStr);
                        visited.add(newStr);
                    }
                }
            }
            chars[i] = ch;
        }
        return false;
    }

    // 优化check，在单词量多时效率低
    public static boolean check(int curr, List<String> wordList, Set<Integer> endQueue,
                                boolean[] visited, Set<Integer> tempQueue) {
        char[] chars = wordList.get(curr).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                chars[i] = j;
                String newStr = String.valueOf(chars);
                int index = wordList.indexOf(newStr);
                if (index != -1) {
                    if (endQueue.contains(index)) return true;
                    if (!visited[index]) {
                        tempQueue.add(index);
                        visited[index] = true;
                    }
                }
            }
            chars[i] = ch;
        }
        return false;
    }

    public static boolean check(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}
