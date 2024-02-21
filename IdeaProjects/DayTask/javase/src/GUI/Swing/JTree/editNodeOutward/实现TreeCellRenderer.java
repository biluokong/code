package GUI.Swing.JTree.editNodeOutward;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class 实现TreeCellRenderer {
    JFrame jf = new JFrame("定制树的结点");
    DefaultMutableTreeNode friends = new DefaultMutableTreeNode("我的好友");
    DefaultMutableTreeNode qingZhao = new DefaultMutableTreeNode("李清照");
    DefaultMutableTreeNode suGe = new DefaultMutableTreeNode("苏格拉底");
    DefaultMutableTreeNode liBai = new DefaultMutableTreeNode("李白");
    DefaultMutableTreeNode nongYu = new DefaultMutableTreeNode("弄玉");
    DefaultMutableTreeNode huTou = new DefaultMutableTreeNode("虎头");

    public void init() {
        friends.add(qingZhao);
        friends.add(suGe);
        friends.add(liBai);
        friends.add(nongYu);
        friends.add(huTou);
        JTree tree = new JTree(friends);

        //设置结点绘制器
        tree.setCellRenderer(new MyRenderer());

        jf.add(new JScrollPane(tree));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    //自定义类，实现TreeCellRenderer接口
    private class MyRenderer extends JPanel implements TreeCellRenderer {
        private ImageIcon icon;
        private String name;
        private Color background;
        private Color foreground;

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            this.icon = new ImageIcon("javase/src/GUI/Swing/img/tree/" + value +".gif");
            this.name = value.toString();
            this.background = selected ? Color.cyan : Color.white;
            this.foreground = selected ? Color.blue : Color.black;
            return this;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(80, 80);
        }

        @Override
        public void paint(Graphics g) {
            int width = this.icon.getIconWidth();
            int height = this.icon.getIconHeight();

            g.setColor(background);
            g.fillRect(0,0, getWidth(), getHeight());
            g.drawImage(this.icon.getImage(), getWidth() / 2 - width / 2, 10, null);
            g.setColor(foreground);
            g.setFont(new Font("StSong", Font.BOLD, 18));
            g.drawString(this.name, getWidth() / 2 - this.name.length() * 20 / 2, height + 20);
        }
    }

    public static void main(String[] args) {
        new 实现TreeCellRenderer().init();
    }
}
