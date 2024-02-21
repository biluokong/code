package 数据结构.逻辑结构.线性结构.线性表.顺序表示;

//定义一个顺序表示的线性表类
//查找、删除、插入的平均时间复杂度为O(n)，空间复杂度为S(n) = O(1)（没有占有辅助空间）
public class MyArrayList<E> {
    private E[] list;
    private int maxSize;
    private int length;

    //构造一个初始化容量为10的线性表
    public MyArrayList() {
        maxSize = 10;
        list = (E[]) new Object[maxSize];
        length = 0;
    }

    //构造一个初始化容量为maxSize的线性表
    public MyArrayList(int maxSize) {
        this.maxSize = maxSize;
        list = (E[]) new Object[maxSize];
        length = 0;
    }

    //将原容量扩大1.5倍
    public void expansion() {
        maxSize = maxSize*3/2;
        E[] expandList = (E[]) new Object[maxSize];
        for (int i = 0; i < length; i++) {
            expandList[i] = list[i];
        }
        list = expandList;
    }

    //将原容量扩大为maxSize+expandSize
    public void expansion(int expandSize) {
        maxSize += expandSize;
        E[] expandList = (E[]) new Object[maxSize];
        for (int i = 0; i < length; i++) {
            expandList[i] = list[i];
        }
        list = expandList;
    }

    //遍历线性表中的所有元素
    public void traverse() {
        if (length == 0) {
            System.out.println("线性表为空！");
        }
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    //删除与元素e相同的元素,删除后返回其下标
    //若线性表为空或未找到则返回-1
    public int delete(E e) {
        int i = locate(e);
        if (i == -1) {
            return -1;
        }
        for (int j = i; j < length; j++) {
            list[j] = list[j+1];
        }
        length--;
        return i;
    }

    //修改下标为i的元素
    public void setDate(E e, int i) {
        if (i < 0 || i >= length) {
            System.out.println("非法的下标！");
            return;
        }
        list[i] = e;
    }

    //删除下标为i的元素
    //平均移动次数：(n-1)/2
    public void delete(int i) {
        if (i < 0 || i > length) {
            System.out.println("非法的删除位置!");
            return;
        }
        for (int j = i; j < length - 1; j++) {
            list[j] = list[j+1];
        }
        length--;
    }

    //查找与元素e相同的元素，找到后返回其下标
    //若线性表为空或未找到则返回-1
    //ASL（平均查找长度Average Search Length）= ∑PiCi(i=1、2...length) = (length+1)/2
    //时间渐进复杂度：O(length)
    public int locate(E e) {
        if (length == 0) {
            System.out.println("该表为空！");
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if (e.equals(list[i])) {
                return i;
            }
        }
        System.out.println("未找到该元素！");
        return -1;
    }

    //往表尾添加新的元素,并返回添加元素的下标
    //若表已满则返回-1
    public int add(E e) {
        if (length == maxSize) {
            System.out.println("线性表容量已满，无法添加新的元素！");
            return -1;
        }
        list[length] = e;
        length++;
        return length - 1;
    }

    //将元素e插入到线性表中下标为i的位置
    //平均移动次数：length/2（（n+n-1+...+1+0）/ n+1, n=length）
    public void insert(E e, int i) {
        if (length == maxSize) {
            System.out.println("线性表容量已满，无法插入新的元素！");
            return;
        }
        if (i < 0 || i > length) {
            System.out.println("非法的插入位置!");
            return;
        }
        for (int j = length; j > i; j--) {
            list[j] = list[j-1];
        }
        list[i] = e;
        length++;
    }

    //获取下标为i的元素,若不存在，返回null
    public E getValue(int i) {
        if (i < 0 || i >= length) {
            System.out.println("非法的下标！");
            return null;
        }
        return list[i];
    }

    //销毁线性表
    public void destroy() {
        list = null;
    }

    //判断线性表是否为空
    public boolean isEmpty() {
        return length == 0;
    }

    //清空线性表
    public void clear() {
        length = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getLength() {
        return length;
    }
}