package com.bjpowernode.javase.ThtreadSava;

public class Test01 {
    public static void main(String[] args) {
        //此处写synchronized无效


        Account02 account = new Account02("act11111", 10000);
        Thread t1 = new AccountThread02(account);
        Thread t2 = new AccountThread02(account);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class Account {
    private String id;
    private double money;

    public Account(String id, double money) {
        this.id = id;
        this.money = money;
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

    public void withdraw(double money) {
        /**
         * synchronized可以写在这,括号内填你想要线程同步的线程的同一个共享对象
         * 以保证你想要进行线程同步的线程实现多线程排队，不想要的继续进行线程异步来实现多线程并发
         *
         * 括号内还可以填：
         * ①共享对象里面的对象
         *     因为它也共享了，并且也是唯一的（内存地址唯一），效果一样
         * ②字符串常量，如“abd”
         *     因为它在字符串常量池中，内存地址是唯一的
         *     不过，若填字符串长量，会让所有线程都进行线程同步，即使两个线程共享的对象不一样
         *     填这个没什么实际意义，建议不要填这个
         *
         * 在这里写synchronized只会让synchronized()语句块内的语句进行线程同步
         * run()里面的输出语句不受影响，所以输出内容的顺序可能不同
         *
         * synchronized代码块内的代码越少，效率越高
         */
//        synchronized ("abc") {
            double money1 = this.money;
            double money2 = money1 - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setMoney(money2);
//        }
    }
}

class AccountThread extends Thread {

    private Account02 account;

    public AccountThread(Account02 account) {
        this.account = account;
    }

    public void run() {
        double money = 5000;
        /**
         * synchronized也可以写在这，括号内填不同线程共享的对象
         * 在这里写synchronized会让所有有同一个共享对象的本类线程对象都实现多线程同步
         * 并且由于包含了输出语句，所有输出内容顺序是排好队的
         */
        synchronized (this.account) {
            account.withdraw(money);
            System.out.println(Thread.currentThread().getName() + "对" + account.getId() + "取款" + money + "成功，余额" + account.getMoney());
        }
    }
}
