package 多线程.day34;

//继承Thread来实现多线程
public class ProducerAndConsumerPattern01 extends Thread {
    public static void main(String[] args) {
        Num0 n = new Num0();
        Thread t1 = new Producer01(n);
        Thread t2 = new Consumer01(n);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class Num {
    int i;

    public Num() {
        i = 1;
    }
}

class Producer01 extends Thread {
    private Num0 n;

    public Producer01() {
    }

    public Producer01(Num0 n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++ ) {
            synchronized (n) {
                if (n.i % 2 == 0) {
                    try {
                        n.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-->" + n.i);
                n.i++;
                n.notify();
            }
        }
    }
}

class Consumer01 extends Thread {
    private Num0 n;

    public Consumer01() {
    }

    public Consumer01(Num0 n) {
        this.n = n;
    }

    ;
    @Override
    public void run() {
        for (int i = 0; i < 5; i++ ) {
            synchronized (n) {
                if (n.i % 2 != 0) {
                    try {
                        n.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-->" + n.i);
                n.i++;
                n.notify();
            }
        }
    }
}