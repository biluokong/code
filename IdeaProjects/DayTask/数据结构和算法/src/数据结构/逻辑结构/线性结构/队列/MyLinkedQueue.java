package 数据结构.逻辑结构.线性结构.队列;

import 数据结构.逻辑结构.线性结构.线性表.链式表示.单向链表.带头结点.Node;

public class MyLinkedQueue<E> {
    private Node front; //队头指针
    private Node rear;  //队尾指针

    /**
     * 无参构造方法创建链队
     */
    public MyLinkedQueue() {
        front = new Node();
        rear = front;
    }

    /**
     * 出队，若出队失败，则返回null
     * @return
     */
    public E deQueue() {
        if (front == rear) {
            System.out.println("出队失败，队列为空！");
            return null;
        }
        Node temp = front.getNext();
        //若数据结点只有一个，即rear指向第一个数据结点
        if (rear == temp) {
            rear = front;
            front.setNext(null);
            return (E) temp.getNext();
        }
        front.setNext(temp.getNext());
        return (E) temp.getData();
    }

    /**
     * 入队
     * @param e
     */
    public void enQueue(E e) {
        Node temp = new Node(e);
        rear.setNext(temp);
        rear = temp;
    }

    /**
     * 获取队头元素，若获取失败，则返回null
     * @return
     */
    public E getHead() {
        if (front == rear) {
            System.out.println("获取失败，队列为空！");
            return null;
        }
        return (E) front.getNext().getData();
    }

    /**
     * 遍历队列
     */
    public void traverse() {
        Node temp = front.getNext();
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    /**
     * 获取队列的长度
     * @return
     */
    public int getLength() {
        Node temp = front;
        int length = 0;
        while (temp.getNext() != null) {
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    /**
     * 清空队列
     */
    public void clear() {
        front.setNext(null);
        rear = front;
    }

    /**
     * 销毁队列
     */
    public void destroy() {
        rear = front = null;
    }
}
