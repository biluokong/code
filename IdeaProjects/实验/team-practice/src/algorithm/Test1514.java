package algorithm;

import java.util.*;

public class Test1514 {
    public static void main(String[] args) {
        int n = Utils.getInt();
        Utils.getNullLine();
        int[][] edges = Utils.getInputToTwoIntArray();
        double[] succProb = Utils.getInputToDoubleArray();
        int start = Utils.getInt();
        int end = Utils.getInt();
        System.out.println(fun3(n, edges, succProb, start, end));
    }

    // 迪杰斯特拉(单源带权图)
    public static double fun3(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 记录结果
        double[] result = new double[n];
        // 起点
        result[start_node] = 1;
        // 从start点出发，先更新直接与start点相连的点的概率，然后逐步更新，直到不需要更新为止
        while (true) {
            // 是否有过变动
            boolean changed = false;
            // 遍历所有边
            for (int j = 0; j < edges.length; j++) {
                int[] edge = edges[j];
                // 如果从当前点edge[0]出发，到edge[1]的概率，大于之前记录的结果
                if (result[edge[0]] * succProb[j] > result[edge[1]]) {
                    // 则更新
                    result[edge[1]] = result[edges[j][0]] * succProb[j];
                    changed = true;
                }
                // 因为是无向图,所以再反向遍历
                if (result[edge[1]] * succProb[j] > result[edge[0]]) {
                    result[edge[0]] = result[edge[1]] * succProb[j];
                    changed = true;
                }
            }
            // 一遍未修改则表示图已遍历完成
            if (!changed) {
                break;
            }
        }
        return result[end_node];
    }

    //迪杰斯特拉(单源带权图) + PriorityQueue（优化）
    public static double fun2(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<List<double[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }
        double[] probs = new double[n];
        probs[start_node] = 1;
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2[1], o1[1]));
        queue.offer(new double[]{start_node, 1});
        while (!queue.isEmpty()) {
            double[] curr = queue.poll();
            int node = (int) curr[0];
            double prob = curr[1];
            if (node == end_node) break;
            if (prob < probs[node]) continue;
            for (double[] pair : graph.get(node)) {
                int currNode = (int) pair[0];
                double currProb = probs[node] * pair[1];
                if (probs[currNode] < currProb) {
                    probs[currNode] = currProb;
                    queue.offer(new double[]{currNode, probs[currNode]});
                }
            }
        }
        return probs[end_node];
    }

    // BFS求单源无权图最短（长）路径 + PriorityQueue（必需）
    // 注意：需要在出队是标记，而不是入队时标记，bsf能实现靠的是PriorityQueue的排序（因为概念越乘越小）
    public static double fun1(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<List<double[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            graph.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2[1], o1[1]));
        queue.offer(new double[]{start_node, 1});
        visited[start_node] = true;
        while (!queue.isEmpty()) {
            double[] curr = queue.poll();
            int node = (int) curr[0];
            if (visited[node]) continue;
            visited[node] = true;
            if (node == end_node) return curr[1];
            for (double[] pair : graph.get(node)) {
                if (visited[(int) pair[0]]) continue;
                queue.offer(new double[]{pair[0], curr[1] * pair[1]});
            }
        }
        return 0;
    }
}
