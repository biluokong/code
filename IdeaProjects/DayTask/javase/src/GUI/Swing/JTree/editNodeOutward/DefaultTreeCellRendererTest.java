package GUI.Swing.JTree.editNodeOutward;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * 第一种修改外观的方式：此方法改外观不够灵活，会对树中所有结点执行相同的操作
 */
public class DefaultTreeCellRendererTest {
    JFrame jf = new JFrame("测试DefaultTreeCellRenderer");

    public void init() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
        DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
        DefaultMutableTreeNode guangXi = new DefaultMutableTreeNode("广西");
        DefaultMutableTreeNode foShan = new DefaultMutableTreeNode("佛山");
        DefaultMutableTreeNode shanTou = new DefaultMutableTreeNode("汕头");
        DefaultMutableTreeNode guiLin = new DefaultMutableTreeNode("桂林");
        DefaultMutableTreeNode nanNing = new DefaultMutableTreeNode("南宁");
        root.add(guangdong);
        root.add(guangXi);
        guangdong.add(foShan);
        guangdong.add(shanTou);
        guangXi.add(guiLin);
        guangXi.add(nanNing);
        JTree tree = new JTree(root);

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        renderer.setBackgroundNonSelectionColor(Color.white); //未选中结点的背景颜色
        renderer.setBackgroundSelectionColor(Color.gray);   //选中结点的背景颜色
        renderer.setBorderSelectionColor(Color.blue);   //选中结点边框的颜色
        renderer.setClosedIcon(new ImageIcon("javase/src/GUI/Swing/img/tree/close.gif"));   //处于折叠状态下的非叶子结点的图标
        renderer.setFont(new Font("StSong", Font.BOLD, 16));    //结点文本的字体
        renderer.setLeafIcon(new ImageIcon("javase/src/GUI/Swing/img/tree/leaf.png"));  //叶子结点的图标
        renderer.setOpenIcon(new ImageIcon("javase/src/GUI/Swing/img/tree/open.gif"));  //处于展开状态下非叶子结点的图标
        renderer.setTextNonSelectionColor(Color.red); //非选中状态下的文本颜色
        renderer.setTextSelectionColor(Color.blue);  //选中状态下的文本颜色
        tree.setCellRenderer(renderer);

        jf.add(new JScrollPane(tree));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultTreeCellRendererTest().init();
    }
}
