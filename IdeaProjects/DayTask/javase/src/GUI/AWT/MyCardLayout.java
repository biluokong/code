package GUI.AWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCardLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("测试CardLayout");

        //创建一个Panel存放多张卡片，每个卡片组件要取上对应的名字
        Panel p1 = new Panel();
        CardLayout cardLayout = new CardLayout();
        p1.setLayout(cardLayout);
        String[] names = {"第1张", "第2张", "第3张", "第4张", "第5张"};
        for (int i = 0; i < 5; i++) {
            p1.add(names[i], new Button(names[i]));
        }
        frame.add(p1);  //放到frame的中间区域

        //创建一个监听器监听操作
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("上一张".equals(e.getActionCommand()))
                    cardLayout.previous(p1);
                if ("下一张".equals(e.getActionCommand()))
                    cardLayout.next(p1);
                if ("第三张".equals(e.getActionCommand()))
                    cardLayout.show(p1, "第3张");
                if ("第一张".equals(e.getActionCommand()))
                    cardLayout.first(p1);
                if ("最后一张".equals(e.getActionCommand()))
                    cardLayout.last(p1);
            }
        };

        //创建Panel存放相应操作按钮，并将按钮绑定到监听器上
        Panel p2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        addButton(new Button("上一张"), p2, listener);
        addButton(new Button("下一张"), p2, listener);
        addButton(new Button("第三张"), p2, listener);
        addButton(new Button("第一张"), p2, listener);
        addButton(new Button("最后一张"), p2, listener);
        frame.add(p2, BorderLayout.SOUTH);  //放到frame的南边区域

        frame.pack();
        frame.setVisible(true);
    }

    public static void addButton(Button button, Panel p,  ActionListener listener) {
        button.addActionListener(listener);
        p.add(button);
    }
}
