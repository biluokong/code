package 数据结构.逻辑结构.线性结构.线性表.链式表示.双向链表;

public class Node {
    private Node prior;
    private Object data;
    private Node next;

    public Node() {
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Node prior, Object data) {
        this.prior = prior;
        this.data = data;
    }

    public Node(Node prior, Object data, Node next) {
        this.prior = prior;
        this.data = data;
        this.next = next;
    }

    public Node getPrior() {
        return prior;
    }

    public void setPrior(Node prior) {
        this.prior = prior;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
