package 数据结构.逻辑结构.线性结构.线性表.链式表示.单向链表.带头结点;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.addTail(5);
        list1.addTail(0);
        list1.addTail(1);
        list1.traverse();
        System.out.println(list1.getData(3));
        System.out.println(list1.locate(new Integer(1)));
        System.out.println(list1.locateNode(new Integer(1)));
        list1.insert(2, 4);
        list1.traverse();
        list1.delete(6);
        list1.traverse();
        list1.addHead(12);
        list1.traverse();
        System.out.println(list1.getLength());
        MyLinkedList list2 = new MyLinkedList();
        list2.addHead(24);
        list2.addHead(7);
        list2.addHead(14);
        list2.traverse();
        list1.connect(list2, 7);
        list1.delete(new Integer(7));
        list1.traverse();
        System.out.println(list1.getLength());
    }
}