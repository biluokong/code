package com.bjpowernode.javase.ThtreadSava;

public class Test02 {
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

class Account02 {
    private String id;
    private double money;

    public Account02(String id, double money) {
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

    /**
     * 若将synchronized加到方法名中，则锁固定为this（共享对象固定为this）
     * 锁住的内容为此方法
     * 缺点：
     *     这种方式不灵活，且整个方法都包括了，可能扩大同步的范围，造成效率低下
     *优点；
     *     代码少，若固定用this，建议用这种方式
     * @param money
     */
    public synchronized void withdraw(double money) {
        double money1 = this.money;
        double money2 = money1 - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setMoney(money2);
    }
}

class AccountThread02 extends Thread {

    private Account02 account;

    public AccountThread02(Account02 account) {
        this.account = account;
    }

    public void run() {
        double money = 5000;
        account.withdraw(money);
        System.out.println(Thread.currentThread().getName() + "对" + account.getId() + "取款" + money + "成功，余额" + account.getMoney());
    }
}
