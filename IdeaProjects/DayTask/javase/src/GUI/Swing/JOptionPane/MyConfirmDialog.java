package GUI.Swing.JOptionPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyConfirmDialog {
    JFrame jf = new JFrame("测试确认对话框");
    JTextArea jta = new JTextArea(6, 20);

    JButton btn = new JButton(new AbstractAction("弹出确认对话框") {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = jta.getText();
            //获取确认对话框的返回值，判断用户是否确认
            //默认对话框，只有‘确定’按钮
            //int result = JOptionPane.showConfirmDialog(jf, text, "确认对话框", JOptionPane.DEFAULT_OPTION);
            //YES或NO对话框
            //int result = JOptionPane.showConfirmDialog(jf, text, "确认对话框", JOptionPane.YES_NO_OPTION);
            //YES、NO或CANCEL
            int result = JOptionPane.showConfirmDialog(jf, text, "确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);

            if (result == JOptionPane.YES_OPTION)
                jta.append("\n用户点击了‘是’按钮");
            if (result == JOptionPane.NO_OPTION)
                jta.append("\n用户点击了‘否’按钮");
            if (result == JOptionPane.OK_OPTION)
                jta.append("\n用户点击了‘确认’按钮");
            if (result == JOptionPane.CANCEL_OPTION)
                jta.append("\n用户点击了‘取消’按钮");
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
        new MyConfirmDialog().init();
    }
}
