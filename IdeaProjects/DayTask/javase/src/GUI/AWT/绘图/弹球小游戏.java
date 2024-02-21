package GUI.AWT.绘图;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class 弹球小游戏 {
    private Frame frame = new Frame("弹球游戏");

    private final int TABLE_WIDTH = 300;    //桌面宽度
    private final int TABLE_HEIGHT = 400;    //桌面高度

    private final int RACKET_WIDTH = 60;    //球拍的宽
    private final int RACKET_HEIGHT = 30;    //球拍的高
    private final int BALL_SIZE = 16;   //小球的半径

    private int ballX = 120;    //小球X坐标
    private int ballY = 20;     //小球Y坐标
    private int speedX = 5;     //小球X坐标速度
    private int speedY = 10;    //小球Y坐标速度
    private int racketX = 120;  //球拍X坐标
    private final int racketY = 340;    //球拍Y坐标
    private boolean isOver = false;     //游戏是否结束的标志
    private Timer timer;    //定时器

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if (isOver) {   //游戏结束
                g.setColor(Color.blue);
                g.setFont(new Font("over", Font.BOLD, 30));
                g.drawString("游戏结束",50,200);
            } else {
                //绘制小球
                g.setColor(Color.red);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
                //绘制球拍
                g.setColor(Color.pink);
                g.fillRect(racketX, racketY, RACKET_WIDTH, RACKET_HEIGHT);
            }
        }
    }
    MyCanvas drawArea = new MyCanvas(); //创建绘画区域

    public 弹球小游戏() {
        init();
        frame.pack();
        frame.setVisible(true);
    }

    //组装视图和完成游戏逻辑的控制
    public void init() {
        //控制球拍坐标变化
        KeyListener key = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();   //获取当前按下的键
                if (keyCode == KeyEvent.VK_LEFT) {
                    if (racketX > 0)
                        racketX -= 10;
                }
                if (keyCode == KeyEvent.VK_RIGHT) {
                    if (racketX < (TABLE_WIDTH - RACKET_WIDTH))
                        racketX += 10;
                }
            }
        };
        frame.addKeyListener(key);
        drawArea.addKeyListener(key);

        //小球坐标的控制
        timer = new Timer(100, e -> {
            //根据边界条件控制小球的速度方向和游戏是否结束
            if (ballX <= 0 || ballX >= (TABLE_WIDTH - BALL_SIZE))
                speedX = -speedX;
            if (ballY <= 0 || ((ballY + BALL_SIZE >= racketY) && (ballX + BALL_SIZE / 2 >= racketX && ballX + BALL_SIZE / 2 <= racketX + RACKET_WIDTH)))
                speedY = -speedY;
            if (ballY + BALL_SIZE > racketY && (ballX + BALL_SIZE / 2 < racketX || ballX + BALL_SIZE / 2 > racketX + RACKET_WIDTH)) {
                timer.stop();
                isOver = true;
                drawArea.repaint();
            }
            //让坐标改变并重新绘制图像
            ballX += speedX;
            ballY += speedY;
            drawArea.repaint();
        });
        timer.start();

        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        frame.add(drawArea);
    }

    public static void main(String[] args) {
        new 弹球小游戏();
    }


}
