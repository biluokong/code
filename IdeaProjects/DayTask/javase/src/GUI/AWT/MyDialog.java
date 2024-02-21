package GUI.AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dialog是widows的子类，是一个容器类，属于特殊组件，对话框是可以独立存在的顶级窗口，所以用法与窗口几乎一样。
 *  注意；对话框通常依赖于其它窗口，即通常需要有一个父窗口。
 *       对话框有非模式和模式之分。
 * Dialog有一个子类：FileDialog，用于打开或保存文件。(常用)
 */
public class MyDialog {
    public static void main(String[] args) {
        Frame frame = new Frame("myDialog");

        Dialog d1 = new Dialog(frame, "模式对话框", true);
        Dialog d2 = new Dialog(frame, "非模式对话框", false);

        d1.setBounds(20, 30, 300, 200);
        d2.setBounds(20, 30, 300, 200);

        Button b1 = new Button("打开模式对话框");
        Button b2 = new Button("打开非模式对话框");

        b1.addActionListener(e -> d1.setVisible(true));
        b2.addActionListener(e -> d2.setVisible(true));

        frame.add(b1, BorderLayout.NORTH);
        frame.add(b2);

        frame.pack();
        frame.setVisible(true);
    }
}
