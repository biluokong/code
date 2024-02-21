package 团队.demo3;

import java.util.Scanner;

public class Practice2 {
    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> pre;
    }
    //对循环单链表的倒数第n个结点进行删除操作，并返回头结点
    public static void deleteByLastIndex(Node head, int index) {
        Node t = head.pre;
        int count = 0;
        while (t != head) {
            count++;
            if (count == index)
                break;
            t = t.pre;
        }
        if (t == head){
            System.out.println("非法的删除位置！");
            return;
        }
        t.next.pre = t.pre;
        t.pre.next = t.next;
    }

    public static void main(String[] args) {
        Node head = new Node(), t = head;
        head.next = head;
        head.pre = head;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入链表中的元素(以-10000作为结束符)：");
        while (true) {
            Node<Integer> p = new Node<>();
            p.data = input.nextInt();
            if (p.data == -10000)
                break;
            p.pre = t;
            t.next = p;
            p.next = head;
            head.pre = p;
            t = p;
        }
        System.out.println("请输入要删除结点的位置(倒着数)：");
        deleteByLastIndex(head, input.nextInt());
        t = head.next;
        while (t != head){
            System.out.print(t.data + " ");
            t = t.next;
        }
    }
}
