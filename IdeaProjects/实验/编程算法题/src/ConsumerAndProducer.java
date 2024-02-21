import java.util.ArrayList;
import java.util.List;

public class ConsumerAndProducer {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread consumer = new Thread(new Consumer(list));
        Thread producer = new Thread(new Producer(list));
        consumer.setName("消费者");
        producer.setName("生产者");
        consumer.start();
        producer.start();
    }
}

class Consumer implements Runnable {
    private List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() > 0) {
                    System.out.println(Thread.currentThread().getName() + "-->消费了" + list.get(0));
                    list.remove(0);
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.notify();
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Producer implements Runnable {
    private List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() == 0) {
                    System.out.println(Thread.currentThread().getName() + "-->生产了一个对象");
                    list.add(new Object());
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.notify();
                } else {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}