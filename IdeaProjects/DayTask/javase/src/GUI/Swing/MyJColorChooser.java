package GUI.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyJColorChooser {
    JFrame jf = new JFrame("颜色选择器");
    JTextArea jta = new JTextArea("我爱中华", 6, 30);
    JButton btn = new JButton(new AbstractAction("改变文本框背景颜色") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //弹出颜色选择器，参数：父窗口、窗口名称、默认颜色
            Color result = JColorChooser.showDialog(jf, "颜色选择器", Color.white);
            //修改背景文本框颜色
            jta.setBackground(result);
        }
    });

    public void init() {
        jf.add(jta);
        jf.add(btn, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyJColorChooser().init();
    }
}
