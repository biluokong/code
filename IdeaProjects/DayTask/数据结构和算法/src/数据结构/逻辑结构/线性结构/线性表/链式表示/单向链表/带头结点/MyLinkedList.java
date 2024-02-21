package 数据结构.逻辑结构.线性结构.线性表.链式表示.单向链表.带头结点;
/**
 * 1.C语言中单向链表由头指针、头结点（并不一定需要）、首元结点以及其他结点组成
 *     (1)头指针：头指针是指向链表中第一个结点的指针（储存第一个结点的地址）
 *     (2)头结点：头结点是在首元结点之前附设的一个结点，其指针域指向首元结点
 *              头结点的数据域可以不存储任何信息，也可存储与数据元素类型相同的其他附加信息
 *     (3)首元结点：首元结点是指链表中存储第一个数据元素的结点（可以设置，也可以不设置）
 *
 * 2.设置头结点的作用：
 *     (1)便于首元结点的处理
 *            增加了头结点后，首元结点的地址保存在头结点（即其 “前驱” 结点）的指针域中，则对链表
 *            的第一个数据元素的操作与其他数据元素相同，无需进行特殊处理。
 *     (2)便于空表和非空表的统一处理
 *            当链表不设头结点时，假设 L 为单链表的头指针，它应该指向首元结点，则当单链表为长度
 *            n 为 0 的空表时， L 指针为空（判定空表的条件可记为：L== NULL)。
 *
 * 3.链表是顺序存取的，顺序表（数组）是随机存取的
 *
 * 4.单链表的查找时间复杂度为O(n)，插入和删除的时间复杂度为O(1)，但此过程中差找前驱的时间复杂度为O(n)
 */
public class MyLinkedList<E> {
    private Node node;
    private int length;

    //通过构造方法构造头结点
    //头结点的数据域储存链表的长度
    public MyLinkedList() {
        node = new Node();
        length = 0;
    }

    //取得第i个结点的数据，若没找到则返回null
    public E getData(int i) {
        Node temp = locate(i);
        if (temp == null) {
            return null;
        }
        return (E) temp.getData();
    }

    //合并两个单链表,将另一个链表连接到此链表尾部
    public void connect(MyLinkedList list) {
        Node temp = node;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(list.node.getNext());
        length += list.length;
    }

    //合并两个链表，将另一个链表连接到此链表第i个结点前面
    public void connect(MyLinkedList list, int i) {
        Node temp = list.node;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        if (i == 1) {
            temp.setNext(node.getNext());
            node.setNext(list.node.getNext());
            length += list.length;
            return;
        }
        Node t = locate(i-1);
        if (t == null) {
            return;
        }
        temp.setNext(t.getNext());
        t.setNext(list.node.getNext());
        length += list.length;
    }

    //删除与数据e相同的第一个数据
    public void delete(E e) {
        Node temp = node;
        Node t = null;
        while (temp.getNext() != null) {
            t = temp;
            temp = temp.getNext();
            if (e.equals(temp.getData())) {
                t.setNext(temp.getNext());
                return;
            }
        }
        System.out.println("未找到此数据！");
    }

    //删除第i个结点
    public void delete(int i) {
        /*if (i == 1) {
            node.setNext(node.getNext().getNext());
            length--;
            return;
        }
        Node temp = locate(i-1);
        if (temp == null || locate(i) == null) {
            return;
        }
        temp.setNext(temp.getNext().getNext());
        length--;*/
//      或
        Node temp = node;
        int j = 0;
        while (temp.getNext() != null && i - 1 > j) {
            temp = temp.getNext();
            j++;
        }
        if (temp.getNext() == null || j > i-1) {
            System.out.println("该结点不存在或链表为空！");
            return;
        }
        temp.setNext(temp.getNext().getNext());
        length--;
    }

    //在第i个结点前插入数据e,并返回插入结点的地址
    public Node insert(E e, int i) {
        /*if (i == 1) {
            node.setNext(new Node(e, node.getNext()));
            length++;
            return node.getNext();
        }
        Node temp = locate(i-1);
        if (temp == null) {
            return null;
        }
        temp.setNext(new Node(e, temp.getNext()));
        length++;
        return temp.getNext();
        或*/
        Node temp = node;
        int j = 0;
        while (temp != null && i-1 > j) {
            temp = temp.getNext();
            j++;
        }
        if (temp == null || j > i-1) {
            System.out.println("插入位置非法！");
        }
        temp.setNext(new Node(e, temp.getNext()));
        length++;
        return temp.getNext();
    }

    //查找链表中与数据e相同的数据，并返回它的序号，若未找到或链表为空则返回-1
    public int locate(E e) {
        Node temp = node.getNext();
        int i = 0;
        while (temp != null) {
            i++;
            if (e.equals(temp.getData())) {
                return i;
            }
            temp = temp.getNext();
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
        Node temp = node.getNext();
        if (node.getNext() == null) {
            System.out.println("链表为空！");
            return;
        }
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    //头插法，添加数据e到链表头部
    public void addHead(E e) {
        node.setNext(new Node(e, node.getNext()));
        length++;
    }

    //尾插法，添加数据e到链表尾部
    public void addTail(E e) {
        Node temp = node;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(new Node(e));
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

    public Node getNode() {
        return node;
    }

    public int getLength() {
        return length;
    }
}
