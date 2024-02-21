package 多线程;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduleExecutorService {
    public static void main(String[] args) {
        //1、创建ScheduleExecutorService线程池，做定时器
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);

        //2、开启定时任务
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-->执行了一次A");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println(10 / 0);
            }
        }, 0, 2, TimeUnit.SECONDS);

        //A任务不会影响B任务，不论任务A是延时了(sleep了)，还是出现异常了
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-->执行了一次B");
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
