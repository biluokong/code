package GUI.AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class 事件处理机制 implements ActionListener {
    Frame frame = new Frame("事件处理机制");

    TextField tf = new TextField(30);
    Button ok1 = new Button("确定1");
    Button ok2 = new Button("确定2");
    Button ok3 = new Button("确定3");

    public 事件处理机制() {
        init();
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {

        //第一种注册监听方式：定义一个实现ActionListener接口的匿名内部类，来创建事件监听器
        ok1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.setText("Hello World ok1");
            }
        });

        //第二种注册监听的方式：定义一个实现ActionListener接口的内部类，来创建事件监听器
        MyListener ml = new MyListener();
        ok2.addActionListener(ml);

        //第三种注册监听的方式：直接本类实现ActionListener接口，将响应组件注册。
        ok3.addActionListener(this);

        frame.add(tf, BorderLayout.NORTH);
        Box box = Box.createHorizontalBox();
        box.add(ok1);
        box.add(ok2);
        box.add(ok3);
        frame.add(box);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tf.setText("Hello World ok3");
    }

    public class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tf.setText("Hello World ok2");
        }
    }

    public static void main(String[] args) {
        new 事件处理机制();
    }
}