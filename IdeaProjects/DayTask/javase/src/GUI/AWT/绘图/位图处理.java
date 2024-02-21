package GUI.AWT.绘图;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class 位图处理 extends Canvas implements ActionListener {
    private Frame frame = new Frame("简单手绘");

    //定义画图区的宽高
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;

    //定义一个右键菜单，用于设置画笔的颜色
    private PopupMenu colors = new PopupMenu();
    private MenuItem red = new MenuItem("红色");
    private MenuItem green = new MenuItem("绿色");
    private MenuItem blue = new MenuItem("蓝色");

    //定义变量保存当前画笔颜色
    private Color forceColor = Color.black;

    //创建一个BufferedImage位图对象
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);

    //通过位图获得关联的Graphics对象
    Graphics g = image.getGraphics();

    //记录鼠标拖动过程中上一次位置的坐标
    private int preX = -1;
    private int preY = -1;

    public 位图处理() {
        init();
        setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {
        //监听右键菜单条目
        addMenuItem(red);
        addMenuItem(green);
        addMenuItem(blue);

        //把colorsMenu设置给绘图区域
        add(colors);
        addMouseListener(new MouseAdapter() {
            @Override   //当鼠标按键被释放时调用
            public void mouseReleased(MouseEvent e) {
                //监听右键
                boolean popupTrigger = e.isPopupTrigger();
                if (popupTrigger)
                    colors.show(位图处理.this, e.getX(), e.getY());

                //鼠标按键释放时，重置preX和preY
                preX = -1;
                preY = -1;
            }
        });

        //设置位图的背景为白色
        g.setColor(Color.white);
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);

        //监听鼠标移动，完成线条的绘图
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (preX > 0 && preY > 0) { //说明鼠标拖动了
                    g.setColor(forceColor);
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                //修正preX和preY的值
                preX = e.getX();
                preY = e.getY();
                位图处理.this.repaint();
            }
        });
    }

    public void addMenuItem(MenuItem i) {
        i.addActionListener(this);
        colors.add(i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if ("红色".equals(actionCommand))
            forceColor = Color.RED;
        if ("绿色".equals(actionCommand))
            forceColor = Color.GREEN;
        if ("蓝色".equals(actionCommand))
            forceColor = Color.BLUE;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        new 位图处理();
    }
}
