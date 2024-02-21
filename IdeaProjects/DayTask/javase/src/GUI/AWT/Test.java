package GUI.AWT;

import java.awt.*;

/**
 * 1、Frame组件依附于Windows窗口，其它组件依附于Panel或Frame组件，而Panel组件又依附于Frame组件。
 * 2、在BorderLayout中往同一个区域添加组件时会被覆盖；不指定添加区域，默认中间。
 */
public class Test {
    public static void main(String[] args) {
        Frame frame = new Frame("这是演示");

        frame.setLayout(new BorderLayout(30, 40));

        frame.add(new Button("north"), BorderLayout.NORTH);
        frame.add(new Button("south"), BorderLayout.SOUTH);
        frame.add(new Button("east"), BorderLayout.EAST);
        frame.add(new Button("west"), BorderLayout.WEST);
        frame.add(new Button("center"), BorderLayout.CENTER);

        frame.add(new TextField("hkltt"));

        frame.pack();

        frame.setBounds(100, 500, 500, 300);
        frame.setVisible(true);
    }
}
