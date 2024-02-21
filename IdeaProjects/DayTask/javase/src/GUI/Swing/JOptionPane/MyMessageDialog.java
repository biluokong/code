package GUI.Swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyMessageDialog {
    JFrame jf = new JFrame("测试消息对话框");
    JTextArea jta = new JTextArea(6, 20);

    JButton btn = new JButton(new AbstractAction("弹出消息对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = jta.getText();
            //参数：int messageType，用于指定消息对话框的类型，有错误消息、警告消息、问题消息......
            //错误消息
            //JOptionPane.showMessageDialog(jf, text, "消息对话框", JOptionPane.ERROR_MESSAGE);

            //普通消息
            //JOptionPane.showMessageDialog(jf, text, "消息对话框", JOptionPane.INFORMATION_MESSAGE);

            //警告消息
            //JOptionPane.showMessageDialog(jf, text, "消息对话框", JOptionPane.WARNING_MESSAGE);

            //问题消息
            //JOptionPane.showMessageDialog(jf, text, "消息对话框", JOptionPane.QUESTION_MESSAGE);

            //最基本消息，无图标
            JOptionPane.showMessageDialog(jf, text, "消息对话框", JOptionPane.PLAIN_MESSAGE, new ImageIcon("javase/src/GUI/Swing/img/component/pre.png"));
        }
    });

    public void init() {
        jf.add(jta);
        jf.add(btn, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new MyMessageDialog().init();
    }
}
