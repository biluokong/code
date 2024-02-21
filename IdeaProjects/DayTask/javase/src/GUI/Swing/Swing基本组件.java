package GUI.Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing基本组件 implements ActionListener {
    JFrame f = new JFrame("Swing基本组件");

    //创建菜单相关的对象
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("文件");
    JMenu editMenu = new JMenu("编辑");
    JMenuItem anto = new JMenuItem("自动换行");
    JMenuItem copy = new JMenuItem("复制", new ImageIcon("javase/src/GUI/Swing/img/component/copy.png"));
    JMenuItem paste = new JMenuItem("粘贴", new ImageIcon("javase/src/GUI/Swing/img/component/paste.png"));
    JMenu formatMenu = new JMenu("格式");
    JMenuItem comment = new JMenuItem("注释");
    JMenuItem cancelComment = new JMenuItem("取消注释");

    JTextArea ta = new JTextArea(8, 20);    //文本域
    String[] colors = {"红色", "绿色", "蓝色"};
    JList<String> colorList = new JList<>(colors);    //列表框
    JComboBox<String> colorSelect = new JComboBox<>();  //下拉选择框

    //单选按钮，实现单选效果，需要放在一个组里
    ButtonGroup bg = new ButtonGroup(); //按钮组
    JRadioButton male = new JRadioButton("男", false);
    JRadioButton female = new JRadioButton("女", true);

    JCheckBox isMarried = new JCheckBox("是否已婚", true);    //复选框
    JTextField tf = new JTextField(40);
    JButton ok = new JButton("确定", new ImageIcon("javase/src/GUI/Swing/img/component/ok.png")); //可以传入一个图片的地址，Icon

    //右键菜单项
    JPopupMenu popupMenu = new JPopupMenu();
    ButtonGroup popupGroup = new ButtonGroup();
    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格");
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows 风格");
    JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("Windows 经典风格");
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格");

    public Swing基本组件() {
        init();
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        //组装底部
        JPanel dPanel = new JPanel();
        dPanel.add(tf);
        dPanel.add(ok);
        f.add(dPanel, BorderLayout.SOUTH);

        //组装中间关于选择的一行
        JPanel mPanel = new JPanel();
        colorSelect.addItem("红色");
        colorSelect.addItem("绿色");
        colorSelect.addItem("蓝色");
        mPanel.add(colorSelect);
        bg.add(male);
        bg.add(female);
        mPanel.add(male);
        mPanel.add(female);
        mPanel.add(isMarried);

        //组装左上部分的文本域和中间关于选择的部分
        Box leftMid = Box.createVerticalBox();
        leftMid.add(ta);
        leftMid.add(mPanel);

        //组装整个顶部
        Box top = Box.createHorizontalBox();
        top.add(leftMid);
        top.add(colorList);
        f.add(top);

        //组装顶部菜单
        comment.setToolTipText("将程序代码注释起来");    //鼠标悬停提示信息的设置
        formatMenu.add(comment);
        formatMenu.add(cancelComment);
        editMenu.add(anto);
        editMenu.addSeparator();    //添加分割线
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.addSeparator();
        editMenu.add(formatMenu);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        f.setJMenuBar(menuBar);

        //组装右键菜单
        addMenuItem(metalItem, popupGroup, popupMenu);
        addMenuItem(nimbusItem, popupGroup, popupMenu);
        addMenuItem(windowsItem, popupGroup, popupMenu);
        addMenuItem(windowsClassicItem, popupGroup, popupMenu);
        addMenuItem(motifItem, popupGroup, popupMenu);
        ta.setComponentPopupMenu(popupMenu);    //不需要再监听鼠标右键了
    }

    public static void main(String[] args) {
        new Swing基本组件();
    }

    public void addMenuItem(JMenuItem item, ButtonGroup group, JPopupMenu menu) {
        group.add(item);
        item.addActionListener(this);
        menu.add(item);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if ("Metal 风格".equals(e.getActionCommand()))
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            if ("Nimbus 风格".equals(e.getActionCommand()))
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            if ("Windows 风格".equals(e.getActionCommand()))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            if ("Windows 经典风格".equals(e.getActionCommand()))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            if ("Motif 风格".equals(e.getActionCommand()))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            SwingUtilities.updateComponentTreeUI(f.getContentPane());   //刷新包含JFrame的顶层容器
            SwingUtilities.updateComponentTreeUI(menuBar);
            SwingUtilities.updateComponentTreeUI(popupMenu);
        } catch (UnsupportedLookAndFeelException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (InstantiationException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }
}
