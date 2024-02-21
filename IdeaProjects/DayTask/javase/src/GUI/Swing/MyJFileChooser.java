package GUI.Swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyJFileChooser extends JPanel{
    JFrame jf = new JFrame("图片查看器");
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("文件");
    BufferedImage image;
    JMenuItem open = new JMenuItem(new AbstractAction("打开") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //显示文件选择器，参数：默认打开路径（.代表当前路径）
            JFileChooser chooser = new JFileChooser(".");
            chooser.showOpenDialog(jf); //让用户选择打开的文件

            //获取用户选择的文件路径
            File file = chooser.getSelectedFile();

            //进行展示
            try {
                image = ImageIO.read(file);
                MyJFileChooser.this.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });
    JMenuItem save = new JMenuItem(new AbstractAction("另存为") {
        @Override
        public void actionPerformed(ActionEvent e) {
            //显示文件选择器，参数：默认打开路径（.代表当前路径）
            JFileChooser chooser = new JFileChooser(".");
            chooser.showSaveDialog(jf); //让用户选择打开的文件

            //获取用户选择的文件路径
            File file = chooser.getSelectedFile();

            //进行保存
            try {
                ImageIO.write(image, "jpg", file);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    });

    public void init() {
        menu.add(open);
        menu.add(save);
        menuBar.add(menu);
        jf.setJMenuBar(menuBar);
        setPreferredSize(new Dimension(740, 500));
        jf.add(this);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        new MyJFileChooser().init();
    }
}
