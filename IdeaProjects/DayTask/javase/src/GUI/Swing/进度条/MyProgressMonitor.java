package GUI.Swing.进度条;

import GUI.AWT.Test;

import javax.swing.*;

//当进度条跑满后，进度条对话框会自动退出
public class MyProgressMonitor {
    Timer timer;

    public void init() {
        //创建进度对话框
        ProgressMonitor monitor = new ProgressMonitor(null, "等待任务完成", "已完成", 0, 100);

        SimulateActivity simulateActivity = new SimulateActivity(monitor.getMaximum());
        new Thread(simulateActivity).start();

        timer = new Timer(200, e -> {
            monitor.setProgress(simulateActivity.getCurrent());
            //如果点击了取消下载，则停止定时任务
            if (monitor.isCanceled()) {
                timer.stop();
                monitor.close();
                System.exit(0);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new MyProgressMonitor().init();
    }

    private class SimulateActivity implements Runnable {
        private int amount; //任务总量
        private volatile int current; //当前任务完成量

        public SimulateActivity(int amount) {
            this.amount = amount;
        }

        @Override
        public void run() {
            try {
                while (current < amount) {
                    Thread.currentThread().sleep(50);
                    current++;
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public int getAmount() {
            return amount;
        }

        public int getCurrent() {
            return current;
        }
    }
}
