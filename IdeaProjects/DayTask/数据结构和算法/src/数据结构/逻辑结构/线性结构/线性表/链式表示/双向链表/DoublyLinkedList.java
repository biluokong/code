package 数据结构.逻辑结构.线性结构.线性表.链式表示.双向链表;

/**
 * 链式储存的优点：
 *     （1）内存可以动态申请和释放，不需要连续的一块空间
 *     （2）插入和删除不需要移动数据元素，效率高
 * 缺点：
 *     （1）储存密度小
 *     （2）非随机存取，增加了对结点操作的算法的复杂度
 * @param <E>
 */
public class DoublyLinkedList<E> {
    private Node node;
    private int length;

    public DoublyLinkedList() {
        node = new Node();
        length = 0;
    }

    //删除与数据e相同的第一个数据
    public void delete(E e) {
        delete(locate(e));
    }

    //删除第i个结点
    public void delete(int i) {
        Node temp = locate(i);
        if (temp == null) {
            return;
        }
        temp.getPrior().setNext(temp.getNext());
        if (temp.getNext() == null) {
            length--;
            return;
        }
        temp.getNext().setPrior(temp.getPrior());
        length--;
    }

    //将数据e插入到链表中第i个结点前面,并返回其地址
    public Node insert(E e, int i) {
        Node temp = locate(i);
        if (temp == null) {
            return null;
        }
        Node t = new Node(temp.getPrior(), e, temp);
        temp.getPrior().setNext(t);
        temp.setPrior(t);
        length++;
        return t;
    }

    //查找链表中与数据e相同的数据，并返回它的序号，若未找到或链表为空则返回-1
    public int locate(E e) {
        Node temp = node;
        int i = 0;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            i++;
            if (e.equals(temp.getData())) {
                return i;
            }
        }
        System.out.println("未找到此数据或链表为空！");
        return -1;
    }

    //查找链表中与数据e相同的数据，并返回它的地址，若未找到或链表为空则返回null
    public Node locateNode(E e) {
        return locate(locate(e));
        /*或
            Node temp = node.getNext();
            while(temp != null && !e.equals(temp.getData())) {
                temp = temp.getNext();
            }
            return temp;
        */
    }

    //查找第i个结点，并返回此结点的地址，若未找到或链表为空则返回null
    public Node locate(int i) {
        Node temp = node.getNext();
        int j = 1;
        while (temp != null && j < i) {
            temp = temp.getNext();
            j++;
        }
        if (temp == null || i < j) {
            System.out.println("未找到此结点或链表为空！");
            return null;
        }
        return temp;
    }

    //遍历链表
    public void traverse() {
        Node temp = node;
        if (node.getNext() == null) {
            System.out.println("链表为空！");
            return;
        }
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.print(temp.getData() + " ");
        }
        System.out.println();
    }

    //添加数据额到链表尾部
    public void add(E e) {
        Node temp = node;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(new Node(temp, e));
        length++;
    }

    //清空链表
    public void clear() {
        node.setNext(null);
        length = 0;
    }

    //销毁链表
    public void destroy() {
        node = null;
        length = 0;
    }

    //判断此链表是否为空
    public boolean isEmpty() {
        return node.getNext() == null;
        //或return length == 0;
    }

    public int getLength() {
        return length;
    }
}
