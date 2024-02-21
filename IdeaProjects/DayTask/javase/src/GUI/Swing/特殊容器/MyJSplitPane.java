package GUI.Swing.特殊容器;

import javax.swing.*;
import java.awt.*;

public class MyJSplitPane {
    Book[] books = {new Book("java自学宝典", new ImageIcon("javase/src/GUI/Swing/img/container/java.png"),
            "国内关于Java编程最全面的图书。"), new Book("轻量级是JAVAEE企业应用实战",
            new ImageIcon("javase/src/GUI/Swing/img/container/ee.png"), "SSM整合开发的经典图书"),
            new Book("Android基础教程", new ImageIcon("javase/src/GUI/Swing/img/container/android.png"),
                    "全面介绍Android平台应用程序\n开发的各方面知识")};
    JFrame jf = new JFrame("测试JSplitPane");

    //这个列表最终显示的结果是Book类中的toString方法返回的字符串
    JList<Book> bookJList = new JList<>(books);
    JLabel bookCover = new JLabel();
    JTextArea bookDesc = new JTextArea();

    //组装视图
    public void init() {
        //设置组件大小
        bookJList.setPreferredSize(new Dimension(150, 400));
        bookCover.setPreferredSize(new Dimension(220, 270));
        bookDesc.setPreferredSize(new Dimension(220, 130));

        //为JList条目设置选中监听器
        bookJList.addListSelectionListener(e -> {
            //获取当前选中的项目
            Book book = bookJList.getSelectedValue();
            //把书籍的图片用bookCover展示
            bookCover.setIcon(book.getIcon());
            //把书籍的描述用bookDesc展示
            bookDesc.setText(book.getDesc());
        });

        //组装左边
        JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bookCover, new JScrollPane(bookDesc));
        left.setOneTouchExpandable(true);   //设置一触即展的效果

        //组装整体
        JSplitPane hole = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, bookJList);
        hole.setContinuousLayout(true);     //设置支持连续布局
        hole.setDividerSize(10);

        jf.add(hole);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new MyJSplitPane().init();
    }
}

class Book {
    private String name;
    private Icon icon;
    private String desc;

    public Book(String name, Icon icon, String desc) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

