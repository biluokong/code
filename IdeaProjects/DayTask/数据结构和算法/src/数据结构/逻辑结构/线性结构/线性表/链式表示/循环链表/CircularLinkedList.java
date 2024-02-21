package 数据结构.逻辑结构.线性结构.线性表.链式表示.循环链表;

import 数据结构.逻辑结构.线性结构.线性表.链式表示.单向链表.带头结点.Node;

public class CircularLinkedList<E> {
    private Node node;
    private int length;

    public CircularLinkedList() {
        node = new Node();
        length = 0;
    }

    public int getLength() {
        return length;
    }
}
