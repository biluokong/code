package 数据结构.逻辑结构.线性结构.线性表.链式表示.双向链表;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList();
        list.add(4);
        list.add(2);
        list.add(9);
        list.traverse();
        list.delete(new Integer(0));
        list.traverse();
        System.out.println(list.getLength());
    }
}
