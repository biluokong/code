package 多线程;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟生产者和消费者模式：
 *  仓库采用List集合，并假设List集合只能存放一个元素。
 *  则List集合中有一个元素，代表仓库已满；元素为0，则代表仓库为空。
 *
 *  如果要保证List集合永远最多只能储存一个元素，则必须做到生产一个消费一个。
 */
public class ProducerAndConsumerPattern {
    public static void main(String[] args) {
        //创建一个共享仓库对象
        List list = new ArrayList();

        //创建两个线程对象：生产者线程和消费者线程
        Thread producer = new Thread(new Producer(list));   //生产者线程
        Thread consumer = new Thread(new Consumer(list));   //消费者线程

        //给线程起名字
        producer.setName("生产者");
        consumer.setName("消费者");

        //让线程开始运行
        producer.start();
        consumer.start();
    }
}

/**
 * 生产者（生产线程）
 */
class Producer implements Runnable {
    private List list;  //仓库

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直生产（使用死循环模拟一直生产）
        while (true) {
            //给仓库对象list加锁
            synchronized (list) {
                if (list.size() > 0) {
                    //如果仓库已满，生产者停止生产
                    try {
                        //让当前线程（生产者线程）进入等待状态，并且释放之前占有的list集合的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //为了更清楚的看到生产者和消费者模式的运行情况，让生产者生产前先睡眠1秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //如果仓库为空，则进行生产
                Object obj = new Object();  //生产一个对象
                list.add(obj);  //将生产的对象放入仓库
                System.out.println(Thread.currentThread().getName() + "生产了一个对象：" + obj);

                //生产完后，唤醒消费者进行消费
                list.notify();
            }
        }
    }
}

/**
 * 消费者（消费线程）
 */
class Consumer implements Runnable {
    private List list;  //仓库

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        //一直消费（使用死循环模拟一直消费）
        while (true) {
            //给仓库对象list加锁
            synchronized (list) {
                if (list.size() == 0) {
                    //如果仓库为空，消费者停止消费
                    try {
                        //让当前线程（消费者线程）进入等待状态，并且释放之前占有的list集合的锁
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //为了更清楚的看到生产者和消费者模式的运行情况，让消费者消费前先睡眠1秒
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //如果仓库已满，则进行消费
                Object obj = list.remove(0);  //将仓库中的对象消费掉
                System.out.println(Thread.currentThread().getName() + "消费了一个对象：" + obj);

                //消费完后，唤醒生产者进行生产
                list.notify();
            }
        }
    }
}