package GUI.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyJTooBar {
    JFrame jf = new JFrame("MyJTooBar");
    JTextArea jt = new JTextArea(6, 35);
    JToolBar jToolBar = new JToolBar("播放工具条", SwingConstants.HORIZONTAL);

    //创建Action对象，用于充当工具条JToolBar的选项(直接传入的话，内部自动创建适合的按钮组件，imageIcon作为按钮图标，但name不会作为按钮的名称)。
    Action pre = new AbstractAction("上一曲", new ImageIcon("javase/src/GUI/Swing/img/component/pre.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jt.append("上一曲。\n");
        }
    };
    Action pause = new AbstractAction("暂停", new ImageIcon("javase/src/GUI/Swing/img/component/pause.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jt.append("暂停播放。\n");
        }
    };
    Action next = new AbstractAction("下一曲", new ImageIcon("javase/src/GUI/Swing/img/component/next.png")) {
        @Override
        public void actionPerformed(ActionEvent e) {
            jt.append("下一曲。\n");
        }
    };

    //组装视图
    public void init() {
        //这样不能添加名称
        /*jToolBar.add(pre);
        jToolBar.addSeparator();
        jToolBar.add(pause);
        jToolBar.addSeparator();
        jToolBar.add(next);*/

        //把名称也添加上可以用Action对象来创建相应的Button对象
        jToolBar.add(new JButton(pre));
        jToolBar.addSeparator();
        jToolBar.add(new JButton(pause));
        jToolBar.addSeparator();
        jToolBar.add(new JButton(next));

        //让工具条可以拖动
        jToolBar.setFloatable(true);

        jf.add(jToolBar, BorderLayout.NORTH);

        //文本框默认不支持滚动条，那么怎么让其支持滚动条呢？
        //答：将一个组件设置到JScrollPane中就可以了
        JScrollPane jScrollPane = new JScrollPane(jt);
        //jf.add(jt);
        jf.add(jScrollPane);

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyJTooBar().init();
    }
}
