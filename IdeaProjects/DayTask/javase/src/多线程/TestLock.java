package 多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        Account account = new Account("act001", 10000);
        new MyThread("小明", account).start();
        new MyThread("小红", account).start();
    }
}

class MyThread extends Thread {
    private Account account;

    public MyThread(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        account.drawMoney(10000);
    }
}

class Account {
    private String id;
    private double money;
    //锁对象是唯一的，用final修饰
    private final Lock lock = new ReentrantLock();

    public Account() {
    }

    public Account(String id, double money) {
        this.id = id;
        this.money = money;
    }

    public void drawMoney(double money) {
        //上锁
        lock.lock();
        try {
            String name = Thread.currentThread().getName();
            //可能代码块里出现异常，导致锁无法解开，出现死锁，用try-catch-finally语句解决
            if (this.money >= money) {
                System.out.println(name + "准备取钱：" + money + "元");
                this.money -= money;
                System.out.println(name + "取钱成功，剩余：" + this.money + "元");
            } else
                System.out.println(name + "取钱失败，余额不足！");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //解锁
            lock.unlock();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
