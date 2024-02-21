package 多线程;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        //1、创建Timer对象
        Timer timer = new Timer();

        //2、调用方法，处理定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-->执行一次A");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(10 / 0);
            }
        }, 0, 2000);
        //B任务会受到A任务影响，有sleep时会延时后才执行；若A任务出现异常，会让B任务无法被执行到
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-->执行一次B");
            }
        }, 0, 2000);
    }
}
