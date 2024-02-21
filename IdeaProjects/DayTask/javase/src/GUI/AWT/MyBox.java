package GUI.AWT;

import javax.swing.*;
import java.awt.*;

/**
 * 1、BoxLayout布局可以水平排列和垂直排列。
 * 2、Box容器默认采用BoxLayout布局方式。(常用)
 */
public class MyBox {
    public static void main(String[] args) {
        Frame frame = new Frame("myBox");

        Box box1 = Box.createHorizontalBox();   //水平排列的box容器
        box1.add(new Button("水平按钮1"));
        box1.add(Box.createHorizontalGlue());   //水平分割
        box1.add(new Button("水平按钮2"));

        Box box2 = Box.createVerticalBox();     //垂直排列的box容器
        box2.add(Box.createVerticalStrut(20));  //高度恒为20的垂直分割
        box2.add(new Button("垂直按钮1"));
        box2.add(Box.createVerticalGlue()); //垂直分割
        box2.add(new Button("垂直按钮2"));

        frame.add(box1, BorderLayout.NORTH);
        frame.add(box2);

        frame.pack();
        frame.setVisible(true);
    }
}
