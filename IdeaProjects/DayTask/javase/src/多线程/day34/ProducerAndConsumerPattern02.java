package 多线程.day34;
//通过实现Runnable接口来实现多线程（建议这种，因为java中是单继承多实现）
public class ProducerAndConsumerPattern02 {
    public static void main(String[] args) {
        Num0 n = new Num0();
        Thread t1 = new Thread(new Producer01(n));
        Thread t2 = new Thread(new Consumer01(n));
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class Num0 {
    int i;

    public Num0() {
        i = 1;
    }
}

class Producer02 implements Runnable {
    private Num0 n;

    public Producer02() {
    }

    public Producer02(Num0 n) {
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

class Consumer02 implements Runnable{
    private Num0 n;

    public Consumer02() {
    }

    public Consumer02(Num0 n) {
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
