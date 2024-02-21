package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 使用Executor的工具类直接获得线程池对象
 *  问题：
 *      ● FixedThreadPool 和 SingleThreadPool：允许的请求队列长度为Integer.MAX_VALUE，可能堆积大量请求，导致OOM
 *      ● CachedThreadPool和ScheduledThreadPool：允许创建的线程数量为Integer.MAX_VALUE，可能创建大量线程，导致OOM
 */
public class TestExecutors {
    public static void main(String[] args) {
        //1、线程数量随着任务增加而增加，如果线程任务执行完毕且空闲了一段时间则会回收掉
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //2、创建固定线程数量的线程池：如果某个线程因为执行异常而结束，那么线程池会补充一个新线程替代它
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        //3、创建只有一个线程的线程池对象，如果该线程出现异常而结束，那么线程池会补充一个新线程
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        //4、创建一个线程池，可以实现在给定的延迟后运行任务，或者定期执行任务
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1000);
    }
}
