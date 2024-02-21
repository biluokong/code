package GUI.AWT.绘图;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class 五子棋 implements ActionListener {
    private JFrame frame = new JFrame("五子棋游戏");
    private final int TABLE_WIDTH = 535;
    private final int TABLE_HEIGHT = 536;
    private final int BOARD_SIZE = 15;  //纵向和横向最多可以下多少棋子
    private final int RATE = TABLE_WIDTH / BOARD_SIZE;  //每个棋子占用棋盘的比率

    //棋子在x和y轴对于边界的偏移量
    private final int X_OFFSET = 5;
    private final int Y_OFFSET = 6;

    //四个BufferedImage对象，分别记录四张图片
    BufferedImage table;
    BufferedImage black;
    BufferedImage white;
    BufferedImage selected;

    //二维数组，记录棋子。值为0-没有棋子，1-白棋，2-黑棋
    int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    //红色选择框在数组中的索引
    int selected_X = -1;
    int selected_Y = -1;

    //画布
    private class ChessBoard extends JPanel {
        @Override
        public void paint(Graphics g) {
            g.drawImage(table, 0,0, null);  //绘制棋盘
            if (selected_X > 0 && selected_Y > 0) { //绘制选择框
                g.drawImage(selected, selected_X * RATE + X_OFFSET, selected_Y * RATE + X_OFFSET, null);
            }

            //绘制棋子
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == 2)
                        g.drawImage(black, j * RATE + X_OFFSET, i * RATE + Y_OFFSET, null);
                    if (board[i][j] == 1)
                        g.drawImage(white, j * RATE + X_OFFSET, i * RATE + Y_OFFSET, null);
                }
            }

        }
    }
    ChessBoard chessBoard = new ChessBoard();

    int board_type =  0;    //记录当前棋子的颜色
    Panel p = new Panel();
    Button whiteB = new Button("白棋");
    Button blackB = new Button("黑棋");
    Button deleteB = new Button("删除");

    public 五子棋() {
        init();
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {
        whiteB.addActionListener(this);
        blackB.addActionListener(this);
        deleteB.addActionListener(this);
        p.add(whiteB);
        p.add(blackB);
        p.add(deleteB);
        frame.add(p, BorderLayout.SOUTH);

        //将图片加载到内存中
        try {
            table = ImageIO.read(new File("javase/src/GUI/AWT/绘图/img/board.jpg"));
            white = ImageIO.read(new File("javase/src/GUI/AWT/绘图/img/white.gif"));
            black = ImageIO.read(new File("javase/src/GUI/AWT/绘图/img/black.gif"));
            selected = ImageIO.read(new File("javase/src/GUI/AWT/绘图/img/selected.gif"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //处理鼠标移动
        chessBoard.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                //将鼠标当前坐标转换为数组索引
                selected_X = (e.getX() - X_OFFSET) / RATE;
                selected_Y = (e.getY() - Y_OFFSET) / RATE;
                chessBoard.repaint();
            }
        });

        //处理鼠标点击事件和鼠标移出窗口事件
        chessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int xPos = (e.getX() - X_OFFSET) / RATE;
                int yPos = (e.getY() - X_OFFSET) / RATE;
                if (board[yPos][xPos] == 0) {
                    board[yPos][xPos] = board_type;
                    chessBoard.repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                selected_X = -1;
                selected_Y = -1;
                chessBoard.repaint();
            }
        });

        chessBoard.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        frame.add(chessBoard);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("白棋".equals(e.getActionCommand())) {
            board_type = 1;
            //刷新按钮的颜色
            refreshBtnColor(Color.green, Color.gray, Color.gray);
        }
        if ("黑棋".equals(e.getActionCommand())) {
            board_type = 2;
            refreshBtnColor(Color.gray, Color.green, Color.gray);
        }
        if ("删除".equals(e.getActionCommand())) {
            board_type = 0;
            refreshBtnColor(Color.gray, Color.gray, Color.green);
        }
    }

    public void refreshBtnColor(Color whiteBColor, Color blackBColor, Color deleteBColor) {
        whiteB.setBackground(whiteBColor);
        blackB.setBackground(blackBColor);
        deleteB.setBackground(deleteBColor);
    }

    public static void main(String[] args) {
        new 五子棋();
    }
}
