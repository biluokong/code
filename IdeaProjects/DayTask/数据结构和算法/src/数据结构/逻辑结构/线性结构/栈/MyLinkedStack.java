package 数据结构.逻辑结构.线性结构.栈;

import 数据结构.逻辑结构.线性结构.线性表.链式表示.单向链表.带头结点.Node;

/**
 * 1、链栈是运算受限的单链表，只能在链表头部进行操作
 * 2、链表的头指针就是栈顶，不需要有头结点，空栈相当于头指针指向空
 * 3、基本不存在栈满的情况，插入和删除仅在栈顶处执行
 * @param <E>
 */
public class MyLinkedStack<E> {
    private Node node;
    private int top;

    /**
     * 无参构造方法初始化链栈
     */
    public MyLinkedStack() {
        node = null;
        top = 0;
    }

    /**
     * 弹出栈中一个元素
     */
    public void pop() {
        if (node != null) {
            node= node.getNext();
            top--;
            return;
        }
        System.out.println("弹栈失败，栈中没有元素！");
    }

    /**
     * 压入栈中一个元素
     * @param e
     */
    public void push(E e) {
        node = new Node(e, node);
        top++;
    }

    /**
     * 获得栈顶的元素，若获取失败，则返回null
     */
    public E getValue() {
        if (node != null) {
            return (E) node.getData();
        }
        System.out.println("获取失败，栈中没有元素！");
        return null;
    }

    /**
     * 判断链栈是否为空
     * @return
     */
    public boolean isEmpty() {
        if (node == null) {
            return true;
        }
        return false;
    }

    public Node getNode() {
        return node;
    }

    public int getLength() {
        return top;
    }

    /**
     * 清空链栈
     */
    public void clear() {
        node = null;
        top = 0;
    }
}
