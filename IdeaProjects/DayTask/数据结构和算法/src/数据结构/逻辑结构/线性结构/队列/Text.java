package 数据结构.逻辑结构.线性结构.队列;

public class Text {
    public static void main(String[] args) {
        /*MyArrayCircularQueue<Integer> queue = new MyArrayCircularQueue<>(4);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(12);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(44);
        queue.enQueue(90);
        queue.traverse();
        System.out.println(queue.getLength());*/
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        queue.enQueue(3);
        queue.enQueue(9);
        queue.enQueue(12);
        System.out.println(queue.isEmpty());
        System.out.println(queue.getHead());
        System.out.println(queue.getLength());
        queue.traverse();
        queue.deQueue();
        queue.traverse();
        queue.destroy();
        queue.traverse();
    }
}
