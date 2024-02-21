package GUI.Swing.进度条;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Swing采用了MVC的原则
 */
public class MyJProgressBar {
    JFrame jf = new JFrame("测试进度条");
    JCheckBox indeterminate = new JCheckBox(new AbstractAction("不确定进度条") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //获取复选框的选中状态
            boolean selected = indeterminate.isSelected();
            bar.setIndeterminate(selected); //设置进度条为不确定进度条
            bar.setStringPainted(!selected);    //设置进度条为确定进度条
        }
    });
    JCheckBox noBorder = new JCheckBox(new AbstractAction("不绘制边框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean selected = noBorder.isSelected();
            bar.setBorderPainted(!selected);
        }
    });

    //创建进度条
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);

    //获取进度条内置的数据模型对象
    BoundedRangeModel model = bar.getModel();

    public void init() {
        Box left = Box.createVerticalBox();
        left.add(indeterminate);
        left.add(noBorder);

        bar.setStringPainted(true);
        bar.setBorderPainted(true);

        Box total = Box.createHorizontalBox();
        total.add(left);
        total.add(bar);

        jf.add(total);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

        //开启子线程，模拟耗时操作
        SimulateActivity simulateActivity = new SimulateActivity(bar.getMaximum());
        new Thread(simulateActivity).start();

        //设置一个定时任务，来获取当前任务完成的进度
        Timer timer = new Timer(20, e -> {
            //获取当前任务对象的完成进度，设置给进度条
            int current = simulateActivity.getCurrent();
            System.out.println(current);
            //bar.setValue(current);    //使用进度条对象修改数据
            model.setValue(current);    //使用进度条对象的数据模型对象来修改数据
        });
        timer.start();

        //静态进度条的进度变化
        /*bar*/model.addChangeListener(e -> {    //可以通过进度条对象和进度条对象的数据对象来监听
            if (model.getValue() == model.getMaximum())
                timer.stop();
        });
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

    public static void main(String[] args) {
        new MyJProgressBar().init();
    }
}
