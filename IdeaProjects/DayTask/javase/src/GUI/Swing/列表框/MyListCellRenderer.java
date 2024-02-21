package GUI.Swing.列表框;

import javax.swing.*;
import java.awt.*;

/**
 * 利用ListCellRenderer改变列表外观
 */
public class MyListCellRenderer {
    private JFrame mainWin = new JFrame("好友列表");
    private String[] friends = {"李清照", "苏格拉底", "李白", "弄玉", "虎头"};
    JList<String> friendsList = new JList<>(friends);

    private class MyRenderer extends JPanel implements ListCellRenderer {
        private String name;    //名称
        private ImageIcon icon;  //头像
        private Color backGround;   //背景色
        private Color forceGround;  //前景色：文字的颜色

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            this.name = value.toString();
            this.icon = new ImageIcon("javase/src/GUI/Swing/img/list/" + name + ".gif");
            this.backGround = isSelected ? list.getSelectionBackground() : list.getBackground();
            this.forceGround = isSelected ? list.getSelectionForeground() : list.getForeground();
            return this;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(60, 80);
        }

        @Override
        public void paint(Graphics g) {
            int width = icon.getImage().getWidth(null);
            int height = icon.getImage().getHeight(null);

            //填充背景矩形
            g.setColor(backGround);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            //绘制头像
            g.drawImage(icon.getImage(), (this.getWidth() - width) / 2, 10, null);

            //绘制昵称
            g.setColor(forceGround);
            g.setFont(new Font("StSong", Font.BOLD, 18));
            g.drawString(this.name, this.getWidth() / 2 - this.name.length() * 20 / 2, 10 + height + 20);

        }
    }

    public void init() {
        friendsList.setCellRenderer(new MyRenderer());
        mainWin.add(friendsList);

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new MyListCellRenderer().init();
    }
}
