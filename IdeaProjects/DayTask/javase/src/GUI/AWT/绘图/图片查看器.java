package GUI.AWT.绘图;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class 图片查看器 extends Canvas {
    private Frame frame = new Frame("图片查看器");
    MenuBar bar = new MenuBar();
    Menu menu = new Menu("文件");
    MenuItem open = new MenuItem("打开");
    MenuItem save = new MenuItem("另存为");

    //声明BufferedImage对象，记录本地储存在内存中的图片
    BufferedImage image;

    public 图片查看器() {
        init();
        frame.setBounds(200, 200, 740, 508);
        frame.setVisible(true);
    }

    public void init() {
        open.addActionListener(e -> {
            //打开文件对话框，获取图片
            FileDialog fileDialog = new FileDialog(frame, "打开图片", FileDialog.LOAD);
            fileDialog.setVisible(true);

            //获取图片绝对路径，并传递给image对象
            String dir = fileDialog.getDirectory(); //图片路径
            String file = fileDialog.getFile(); //图片名字
            try {
                image = ImageIO.read(new File(dir, file));
                图片查看器.this.repaint();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });

        save.addActionListener(e -> {
            FileDialog fileDialog = new FileDialog(frame, "保存图片", FileDialog.SAVE);
            fileDialog.setVisible(true);
            String dir = fileDialog.getDirectory(); //图片路径
            String file = fileDialog.getFile(); //图片名字
            try {
                ImageIO.write(image, "JPG", new File(dir, file));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        menu.add(open);
        menu.add(save);
        bar.add(menu);
        frame.setMenuBar(bar);
        frame.add(this);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        new 图片查看器();
    }
}
