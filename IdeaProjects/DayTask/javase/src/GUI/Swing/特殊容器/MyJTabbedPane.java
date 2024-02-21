package GUI.Swing.特殊容器;

import javax.swing.*;

public class MyJTabbedPane {
   JFrame jf = new JFrame("测试JTabbedPanel");
   JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.LEFT, JTabbedPane.SCROLL_TAB_LAYOUT);

    public void init() {
        //添加组件到标签面板
        tabbedPane.addTab("用户管理", new ImageIcon("javase/src/GUI/Swing/img/container/open.gif"),
                new JList<String>(new String[] {"用户1", "用户2", "用户3"}), "用户管理人员");
        tabbedPane.addTab("商品管理", new JList<String>(new String[] {"商品1", "商品2", "商品3"}));
        tabbedPane.addTab("订单管理", new ImageIcon("javase/src/GUI/Swing/img/container/open.gif"),
                new JList<String>(new String[] {"订单1", "订单2", "订单3"}), "订单信息");

        //进行标签面板的设置
        tabbedPane.setEnabledAt(0, false);  //不启用此索引处的标签页面
        tabbedPane.setSelectedIndex(1); //设置默认打开的标签页面

        //对标签面板进行监听
        tabbedPane.addChangeListener(e -> {
            //获取当前索引
            int index = tabbedPane.getSelectedIndex();
            JOptionPane.showMessageDialog(jf, "当前选中了第" + (index + 1) + "标签");
        });

        jf.add(tabbedPane);
        jf.setBounds(400, 400, 400, 400);   //设置窗口的位置和大小
        jf.setResizable(false); //固定窗口大小

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new MyJTabbedPane().init();
    }
}
