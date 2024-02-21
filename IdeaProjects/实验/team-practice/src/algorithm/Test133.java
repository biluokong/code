package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test133 {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        cloneGraph(n1);
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
//        if (node.neighbors.size() == 0) return new Node(node.val, new ArrayList<>());
        // 方法一
//        Node[] visited = new Node[1000];
//        return dfs(node, visited);
        // 方法二
//        HashMap<Integer, Node> visited = new HashMap<>();
//        return dfs(node, visited);
        // 方法三：
        HashMap<Node, Node> visited = new HashMap<>();
        return dfs2(node, visited);
    }

    public static Node dfs2(Node node, HashMap<Node, Node> visited) {
        if (visited.containsKey(node)) return visited.get(node);
        Node newNode = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        visited.put(node, newNode);
        for (Node neighbor : node.neighbors)
            newNode.neighbors.add(dfs2(neighbor, visited));
        return newNode;
    }

    public static Node dfs(Node node, HashMap<Integer, Node> visited) {
        Node newNode = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        visited.put(node.val, newNode);
        for (Node curr : node.neighbors) {
            if (!visited.containsKey(curr.val))
                newNode.neighbors.add(dfs(curr, visited));
            else
                newNode.neighbors.add(visited.get(curr.val));
        }
        return newNode;
    }

    public static Node dfs(Node node, Node[] visited) {
        Node newNode = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        visited[node.val] = newNode;
        for (Node curr : node.neighbors) {
            if (visited[curr.val] == null)
                newNode.neighbors.add(dfs(curr, visited));
            else
                newNode.neighbors.add(visited[curr.val]);
        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
