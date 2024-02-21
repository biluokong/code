package GUI.Swing.列表框;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class Test {
    JFrame jf = new JFrame("测试列表框");
    String[] books = {"java自学宝典", "轻量级javaEE企业应用实战", "Android基础教程", "jQuery实战教程", "SpringBoot企业级开发"};

    //创建 布局选择按钮 所在面板
    JPanel layoutPanel = new JPanel();
    ButtonGroup layoutGroup = new ButtonGroup();

    //创建 选择模式按钮 所在面板
    JPanel selectModePanel = new JPanel();
    ButtonGroup selectModeGroup = new ButtonGroup();

    JTextArea favourite = new JTextArea(4, 40);
    JList<String> bookList = new JList<>(books);
    JComboBox<String> bookSelector = new JComboBox<>(books);    //这里还可以传入vector

    public void init() {
        addLayoutButton(new JRadioButton("纵向滚动"), JList.VERTICAL);
        addLayoutButton(new JRadioButton("纵向换行"), JList.VERTICAL_WRAP);
        addLayoutButton(new JRadioButton("横向滚动"), JList.HORIZONTAL_WRAP);

        addSelectModelButton(new JRadioButton("无限制"), ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addSelectModelButton(new JRadioButton("单选"), ListSelectionModel.SINGLE_SELECTION);
        addSelectModelButton(new JRadioButton("单范围"), ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        bookList.setVisibleRowCount(3); //设置可视条目数
        bookList.setSelectionInterval(2, 4);    //设置某索引范围的选项默认选中

        bookList.addListSelectionListener(e -> {
            List<String> list = bookList.getSelectedValuesList();
            favourite.setText("");
            for (String s : list) {
                favourite.append(s + "\n");
            }
        });

        Box left = Box.createVerticalBox();
        left.add(new JScrollPane(bookList));
        left.add(layoutPanel);
        left.add(selectModePanel);

        bookSelector.setEditable(true); //设置为可编辑
        bookSelector.setMaximumRowCount(4); //设置可视条目数

        bookSelector.addItemListener(e -> {
            Object item = bookSelector.getSelectedItem();
            favourite.setText(item.toString());
        });

        Box top = Box.createHorizontalBox();
        top.add(left);
        JPanel bookSelectPanel = new JPanel();
        bookSelectPanel.add(bookSelector);
        top.add(bookSelectPanel);

        JLabel label = new JLabel("您最喜欢的图书");
        Box down = Box.createVerticalBox();
        down.add(label);
        down.add(favourite);


        jf.add(top);
        jf.add(down, BorderLayout.SOUTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public void addLayoutButton(JRadioButton button, int layoutType) {
        layoutPanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选项布局"));
        layoutPanel.add(button);
        if (layoutGroup.getButtonCount() == 0) {
            //让第一个按钮默认选中
            button.setSelected(true);
        }
        layoutGroup.add(button);
        button.addActionListener(e -> bookList.setLayoutOrientation(layoutType));

    }

    public void addSelectModelButton(JRadioButton button, int selectModelType) {
        selectModePanel.setBorder(new TitledBorder(new EtchedBorder(), "确定选择模式"));
        selectModePanel.add(button);
        if (selectModeGroup.getButtonCount() == 0) {
            button.setSelected(true);   //让第一个按钮默认选中
            bookList.setSelectionMode(selectModelType);
        }
        selectModeGroup.add(button);
        button.addActionListener(e -> bookList.setSelectionMode(selectModelType));
    }

    public static void main(String[] args) {
        new Test().init();
    }
}
