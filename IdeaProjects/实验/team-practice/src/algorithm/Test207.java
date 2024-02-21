package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Test207 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.nextLine();
        String[] strs = input.nextLine().split(" ");
        int[][] array = new int[strs.length][2];
        for (int i = 0; i < array.length; i++) {
            String[] split = strs[i].split(",");
            array[i][0] = Integer.parseInt(split[0]);
            array[i][1] = Integer.parseInt(split[1]);
        }
        System.out.println(f1(num, array));
    }

    public static boolean f1(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            inDegree[to]++;
            graph[from].add(to);
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) stack.push(i);
        }
        int count = 0;
        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            count++;
            for (Integer index : graph[curr]) {
                if (--inDegree[index] == 0) stack.push(index);
            }
        }
        return count == numCourses;
    }
}
