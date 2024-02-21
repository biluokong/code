package 多线程;

/**
 * 死锁现象：
 *     当两个线程执行顺序不一样，两个线程要锁住的对象却互相是对方接下来要锁住的对象，就可能发生死锁现象。
 * 死锁现象是一种堵塞现象，两个线程互相堵塞，等待对方释放自己需要调度的资源。
 * 出现这种现象时，程序既不抛出任何异常，也不错任何错误，程序就一直僵持在那里。
 */
public class DeadLock {
    public static void main(String[] args) {
        //创建两个对象
        Object o1 = new Object();
        Object o2 = new Object();

        //创建两个线程
        Thread t1 = new MyThread1(o1, o2);
        Thread t2 = new MyThread2(o1, o2);

        //给这两个线程取名
        t1.setName("t1");
        t2.setName("t2");

        //让这两个线程开始执行，不论哪个线程先拿到锁，在睡眠过后，必定是两个线程一个拿着o1的锁，一个拿着o2的锁
        //之后互相等待对方释放对象的锁。
        t1.start();
        t2.start();
    }
}

/**
 * 我的线程1
 */
class MyThread1 extends Thread {
    private Object o1;
    private Object o2;

    public MyThread1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        //我的线程1一运行就立刻去拿到对象o1的锁，如果线程1先拿到锁，在线程1睡眠期间，线程2必会拿到o2的锁
        synchronized (o1) {
            try {
                Thread.sleep(1000);     //当前线程睡眠1秒，进入堵塞状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //睡眠结束后，准备获取02的锁
            synchronized (o2) {
            }
        }
    }
}

/**
 * 我的线程2
 */
class MyThread2 extends Thread {
    private Object o1;
    private Object o2;

    public MyThread2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        //我的线程2一运行就立刻去拿o2的锁，如果线程2先拿到锁，在线程2睡眠期间，线程1必会拿到o1的锁
        synchronized (o2) {
            try {
                Thread.sleep(1000);     //当前线程睡眠1秒，进入堵塞状态
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //线程睡眠结束后，准备获取o1的锁
            synchronized (o1) {
            }
        }
    }
}