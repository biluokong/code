package 团队.demo8;

public class Practice1 {
    public static void getBiTree(Node root, Integer... data) {
        if (root == null || data[0] >= data.length || data[data[0]] == null)
            return;
        root.setData(data[data[0]++]);
        root.setLeft(new Node<>());
        root.setRight(new Node<>());
        getBiTree(root.getLeft(), data);
        data[0]++;
        getBiTree(root.getRight(), data);
    }

    public static int getDepth(Node root) {
        if (root.getData() == null)
            return 0;
        int l = getDepth(root.getLeft());
        int r = getDepth(root.getRight());
        return l > r ? l + 1 : r + 1;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>();
        getBiTree(root, 1, 3, 9, 20, null, null, 15, 7);
        System.out.println("深度为：" + getDepth(root));
    }
}

class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
