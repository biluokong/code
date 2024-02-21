package 实验十图像用户界面设计;

import javax.swing.*;
import java.awt.*;

public class Test01 {
    public static void main(String[] args) {
        //创建一个面板，并设置其颜色和大小
        JPanel jPanel = new JPanel();   //创建一个面板
        jPanel.setBackground(Color.yellow);    //设置面板的背景颜色
        jPanel.setSize(300, 35);    //设置面板的大小

        //创建一个按钮，并设置其文本为“Press me”，并将其添加到面板中，并设置其位置居中
        JButton jButton = new JButton("Press me");  //创建一个按钮
        //将按钮添加到面板中并设置其位置居中
        jPanel.add(jButton, BorderLayout.CENTER);

        //创建一个窗体，并将面板添加到窗体中，并设置窗体的标题、大小、位置、背景色和布局方式
        JFrame jFrame = new JFrame();   //创建一个窗体
        jFrame.add(jPanel, BorderLayout.SOUTH);             //将面板添加到窗体中
        jFrame.setTitle("Frame with Panel");    //设置窗体的标题
        jFrame.setSize(300, 200);    //设置窗体的大小
        jFrame.setLocation(100, 100);    //设置窗体的位置

        jFrame.getContentPane().setBackground(Color.cyan);   //设置窗体的背景颜色为蓝绿色cyan

        //让窗体显示在屏幕上
        jFrame.setVisible(true);
    }
}
