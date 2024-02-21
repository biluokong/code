package 多线程;

import java.util.concurrent.*;

public class TestExecutor {
    public static void main(String[] args) throws Exception{
        //1、创建线程池对象
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 6, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //2、添加任务给任务线程池处理
        Runnable target = new MyRunnable(); //添加Runnable任务
        Future<String> f1 = pool.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "  正在执行此任务");
            return "Callable任务";
        });//添加Callable任务
        System.out.println(f1.get());

        //核心线程处理这3个任务
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        //队列中存放新的未执行任务，最多5个
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);

        //当核心线程都在忙，且队列已满时，创建临时对象
        pool.execute(target);
        pool.execute(target);

        //当核心线程和临时线程都在忙，且任务队列已满时，（默认的）拒绝策略(ThreadPoolExecutor.AbortPolicy())被触发
//        pool.execute(target);

        //关闭线程池（开发中一般不使用）
        //pool.shutdownNow(); //立即关闭，不论任务是否完成，可能会丢失任务
        pool.shutdown();    //等待全部任务执行完毕后再关闭（建议使用的）
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "  输出了--》" + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + "  即将进入休眠");
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
