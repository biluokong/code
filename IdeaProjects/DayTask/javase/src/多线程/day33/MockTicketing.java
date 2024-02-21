package 多线程.day33;

import java.util.ArrayList;

public class  MockTicketing implements Runnable {
    private ArrayList<Tick> ticks;

    public MockTicketing() {
        ticks = new ArrayList(200);
        for (int i = 0; i < 200; i++) {
            ticks.add(new Tick(i + 1));
        }
    }

    public void saleTicket() throws TicketsAreSoldOutException {
        if (ticks.size() == 0) {
            throw new TicketsAreSoldOutException();
        }
        System.out.println(Thread.currentThread().getName() + "已售第" + ticks.get(0).i + "张票");
        ticks.remove(0);
    }

    @Override
    public void run() {

        for (int i = 0; i < ticks.size(); i++) {
            synchronized (this) {
                try {
                    saleTicket();
                } catch (TicketsAreSoldOutException e) {
                    e.printStackTrace();
                }
            }
            i = 0;
        }

    }
}

class Tick {
    int i;

    public Tick(int i) {
        this.i = i;
    }
}

class TicketsAreSoldOutException extends Exception {
    public TicketsAreSoldOutException() {
    }

    @Override
    public String getMessage() {
        return "票已售空！";
    }
}