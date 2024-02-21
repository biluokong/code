package GUI.Swing.列表框;

import javax.swing.*;
import java.awt.*;

/**
 * 强制储存的DefaultListModel和DefaultComboBoxModel
 */
public class DefaultListModelAndDefaultComboBoxModel {
    JFrame jf = new JFrame("测试DefaultModel类型");
    JTextField bookName = new JTextField(20);
    JButton remove = new JButton("删除选中图书");
    JButton add = new JButton("添加指定图书");
    JList bookList;
    DefaultListModel<String> model = new DefaultListModel<>();

    public void init() {
        model.addElement("java自学宝典");
        model.addElement("轻量级JavaEE企业应用实战");
        model.addElement("Android基础教程");
        model.addElement("JQuery实战教程");
        bookList = new JList(model);

        bookList.setVisibleRowCount(4);
        //设置为单选
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jf.add(new JScrollPane(bookList));

        add.addActionListener(e -> {
            String name = bookName.getText();
            if (!name.trim().equals(""))
                model.addElement(name);
        });

        remove.addActionListener(e -> {
            int selectedIndex = bookList.getSelectedIndex();
            if (selectedIndex >= 0)
                model.remove(selectedIndex);
        });

        JPanel jPanel = new JPanel();
        jPanel.add(bookName);
        jPanel.add(add);
        jPanel.add(remove);
        jf.add(jPanel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultListModelAndDefaultComboBoxModel().init();
    }
}
