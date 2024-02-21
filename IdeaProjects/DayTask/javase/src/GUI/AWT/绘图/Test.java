package GUI.AWT.绘图;

import javax.swing.*;
import java.awt.*;

public class Test {
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";
    private String shape = "";
    private Frame frame = new Frame("测试绘图");
    Button bRect = new Button("绘制矩形");
    Button bOval = new Button("绘制椭圆");
    MyCanvas canvas = new MyCanvas();   //创建画布对象

    public Test() {
        init();
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * 自定义类，继承Canvas（画布）类，重写paint(Graphics g)方法完成画图
     */
    private class MyCanvas extends Canvas {

        @Override   //paint方法，绘制组件的外观；组件第一次使用时，自动调用此方法
        public void paint(Graphics g) {
            if (RECT_SHAPE.equals(shape)) { //绘制矩形
                g.setColor(Color.CYAN); //设置画笔颜色
                g.drawRect(100, 100, 150, 100);
            }
            if (OVAL_SHAPE.equals(shape)) { //绘制椭圆
                g.setColor(Color.blue);
                g.drawOval(100, 100, 150, 100);
            }
        }
    }
    public void init() {
        //监听
        bRect.addActionListener(e -> {
            shape = RECT_SHAPE;    //修改标记值
            //repaint方法会内部调用update方法，隐藏组件；而update方法内部又会调用paint方法并清除组件内的所有内容
            canvas.repaint();
        });

        bOval.addActionListener(e -> {
            shape = OVAL_SHAPE;
            canvas.repaint();
        });

        //设置画布的大小
        canvas.setPreferredSize(new Dimension(300, 300));

        Box box = Box.createHorizontalBox();
        box.add(bRect);
        box.add(bOval);
        frame.add(box, BorderLayout.SOUTH);
        frame.add(canvas);
    }

    public static void main(String[] args) {
        new Test();
    }
}
