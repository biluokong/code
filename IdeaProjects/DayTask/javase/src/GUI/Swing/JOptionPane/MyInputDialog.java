package GUI.Swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyInputDialog {
    JFrame jf = new JFrame("测试输入对话框");
    JTextArea jta = new JTextArea(6, 20);

    JButton btn = new JButton(new AbstractAction("弹出输入对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = jta.getText();
            String result = JOptionPane.showInputDialog(jf, "请填写您的电话号码", "输入对话框", JOptionPane.INFORMATION_MESSAGE);
            jta.append(result + "\n");
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
        new MyInputDialog().init();
    }
}
