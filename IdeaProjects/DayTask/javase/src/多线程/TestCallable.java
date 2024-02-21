package 多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1、创建Callable任务对象
        /*Callable<String> cal = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("副线程执行了--》" + i + "次");
            }
            return "hello world";
        };*/

        //2、将Callable对象交给FutureTask包装
        //FutureTask<String> f1 = new FutureTask<>(cal);

        //3、交给Thread的处理并启动线程
        /*Thread t1 = new Thread(f1);
        t1.start();*/

        /*for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行了--》" + i + "次");
        }*/

        //4、获得任务对象的执行结果
        //get方法会等待call方法运行结束，才会获取返回值
        //System.out.println(f1.get());

        //简化过程
        FutureTask<String> f1 = new FutureTask<>(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("副线程执行了--》" + i + "次");
            }
            return "hello world";
        });
        new Thread(f1).start();
        System.out.println(f1.get());
    }
}
