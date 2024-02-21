package 数据结构.逻辑结构.线性结构.队列;

/**
 * 用数组做队列时，若不循环，则会出现真溢出（rear = 0, front >= maxSize）和假溢出的情况(rear > 0, front >= maxSize)
 * 解决假溢出的方法：
 *          1、每出队一个元素，其它元素向队首进一位（花费时间多，效率低，很少采用）
 *          2、用循环队列：当front = maxSize时，重置front为0，rear同样
 * 方法2的问题：当用方法2时，队空和队满的条件一样，都是rear = front
 * 解决方法：    ①另设一个标志以区分队满和队空     ②另设一个变量，记录元素个数      ③少用一个元素空间
 *         这里用第三种方法
 * @param <E>
 */
public class MyArrayCircularQueue<E> {
    private int maxSize;
    private E[] queue;
    private int front;  //队头指针
    private int rear;   //队尾指针

    /**
     * 无参构造方法创建一个长度为10的顺序队
     */
    public MyArrayCircularQueue() {
        maxSize = 10;
        queue = (E[]) new Object[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 有参构造方法创建一个长度为maxSize的顺序队
     * @param maxSize
     */
    public MyArrayCircularQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = (E[]) new Object[maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 出队，若出队失败，则返回null；若出队成功，则返回出队元素
     */
    public E deQueue() {
        if (front == rear) {
            System.out.println("出队失败，队列已空！");
            return null;
        }
        E temp = queue[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    /**
     * 入队
     */
    public void enQueue(E e) {
        if ((rear + 1) % maxSize == front) {
            System.out.println("入队失败，队列已满！");
            return;
        }
        queue[rear] = e;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获得队头元素，若获取失败，则返回null
     */
    public E getHead() {
        if (front != rear) {
            return queue[front];
        }
        System.out.println("获取失败，队列为空！");
        return null;
    }

    public boolean isEmpty() {
        if (rear == front) {
            return true;
        }
        return false;
    }

    /**
     * 遍历队列中所有元素
     */
    public void traverse() {
        for (int i = front; i != rear; i = (i + 1) % maxSize) {
            System.out.println(queue[i]);
        }
    }

    /**
     * 获取队列的长度
     * @return
     */
    public int getLength() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 清空队列
     */
    public void clear() {
        rear = front = 0;
    }
}
