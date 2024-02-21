package GUI.AWT;

import java.awt.*;
import java.awt.event.*;

public class 常用事件监听器 {
    public static void main(String[] args) {
        Frame frame = new Frame("常用事件监听器");

        TextField tf = new TextField(30);
        Choice names = new Choice();
        names.add("张三");
        names.add("李四");
        names.add("王五");

        //监听文本框内容的变化：TextListener
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                System.out.println("文本框内容为：" + tf.getText());
            }
        });

        //监听下拉选择框条目的变化：ItemListener
        names.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("当前选中的条目为：" + e.getItem());
            }
        });

        //监听frame容器中组件的添加：ContainerListener
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                System.out.println("frame中添加了：" + e.getChild());
            }

            @Override
            public void componentRemoved(ContainerEvent e) {

            }
        });

        //监听用户点击×的动作：WindowListener 不过由于其需重载的方法太大，所以我们用它的适配器：WindowAdapter
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前程序
                System.exit(0);
            }
        });

        frame.add(tf, BorderLayout.NORTH);
        frame.add(names);
        frame.pack();
        frame.setVisible(true);
    }
}
