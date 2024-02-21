package GUI.Swing;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MyBorder {
    JFrame jf = new JFrame("测试边框");

    public void init() {
        jf.setLayout(new GridLayout(2, 4));

        //创建border
        //创建BevelBorder，参数分别是：类型、高亮部分边框外部颜色、边框内部颜色、阴影部分边框外部颜色、边框内部颜色
        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.red, Color.green, Color.blue, Color.gray);
        jf.add(setBorder(bevelBorder, "BevelBorder"));

        //创建LineBorder，参数：边框颜色、边框像素
        Border lineBorder = BorderFactory.createLineBorder(Color.orange, 10);
        jf.add(setBorder(lineBorder, "LineBorder"));

        //创建EmptyBorder，参数：上边框像素、左边框像素、下边框像素、右边框像素
        Border emptyBorder = BorderFactory.createEmptyBorder(10, 5, 20, 10);
        jf.add(setBorder(emptyBorder, "EmptyBorder"));

        //创建EtchedBorder，参数：类型、高亮部分的颜色、阴影部分的颜色
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.red, Color.green);
        jf.add(setBorder(etchedBorder, "EtchedBorder"));

        //创建TitleBorder，参数：Border对象、边框的标题、标题的位置(两个参数)、标题的字体、标题的颜色
        TitledBorder titledBorder = new TitledBorder(new LineBorder(Color.orange, 10), "测试标题", TitledBorder.LEFT, TitledBorder.BOTTOM, new Font("StSong", Font.BOLD, 18), Color.blue);
        jf.add(setBorder(titledBorder, "TitleBorder"));

        //创建MatteBorder，参数：上边框像素、左边框像素、下边框像素、右边框像素、填充的颜色
        MatteBorder matteBorder = new MatteBorder(10, 5, 20, 10, Color.green);
        jf.add(setBorder(matteBorder, "MatteBorder"));

        //创建CompoundBorder，参数：两个Border：内边框、外边框
        CompoundBorder compoundBorder = new CompoundBorder(new LineBorder(Color.red, 10), titledBorder);
        jf.add(setBorder(compoundBorder, "CompoundBorder"));

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JPanel setBorder(Border border, String content) {
        JPanel jPanel = new JPanel();
        jPanel.add(new Label(content));
        jPanel.setBorder(border);
        return jPanel;
    }

    public static void main(String[] args) {
        new MyBorder().init();
    }
}
