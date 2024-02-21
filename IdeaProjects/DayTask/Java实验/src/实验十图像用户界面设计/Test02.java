package 实验十图像用户界面设计;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test02 extends JFrame {
    private JButton button1 = new JButton("窗口1");    // 创建按钮1
    private JButton button2 = new JButton("窗口2");    // 创建按钮2

    /**
     * 构造方法，设置窗口的标题，大小，位置、组件和布局
     */
    public Test02() {
        // 设置窗口的标题、大小和位置
        this.setTitle("FlowLayout测试");
        setSize(400, 300);
        setLocation(100, 100);

        // 设置组件和布局
        setLayout(new FlowLayout());
        add(button1);
        add(button2);

        // 设置按钮的监听器，鼠标点击时触发事件
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建窗口1
                JFrame jFrame = new JFrame();   //创建一个窗体
                jFrame.add(new JLabel("窗口1"), BorderLayout.NORTH);     //将标签添加到窗体中
                jFrame.setTitle("Frame1");    //设置窗体的标题
                jFrame.setSize(300, 200);    //设置窗体的大小

                //让窗体显示在屏幕上
                jFrame.setVisible(true);
            }
        });

        button2.addActionListener(e ->  {
            // 创建窗口1
            JFrame jFrame = new JFrame();   //创建一个窗体
            jFrame.add(new JLabel("窗口2"), BorderLayout.NORTH);     //将标签添加到窗体中
            jFrame.setTitle("Frame2");    //设置窗体的标题
            jFrame.setSize(300, 200);    //设置窗体的大小

            //让窗体显示在屏幕上
            jFrame.setVisible(true);
        });
    }

    /**
     * main方法，显示窗口，进行测试
     */
    public static void main(String[] args) {
        //显示窗口
        Test02 frame = new Test02();
        frame.setVisible(true);
    }
}
