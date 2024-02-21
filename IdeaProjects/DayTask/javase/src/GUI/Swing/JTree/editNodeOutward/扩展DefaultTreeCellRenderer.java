package GUI.Swing.JTree.editNodeOutward;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * 改变外观的第二种方式(常用)：使用继承了Default类的类(可自定义)。该类重写了getTreeCellRendererComponent()方法
 */
public class 扩展DefaultTreeCellRenderer {
    JFrame jf = new JFrame("根据不同结点定义图标");
    ImageIcon rootIcon = new ImageIcon("javase/src/GUI/Swing/img/tree/root.gif");
    ImageIcon databaseIcon = new ImageIcon("javase/src/GUI/Swing/img/tree/database.gif");
    ImageIcon tableIcon = new ImageIcon("javase/src/GUI/Swing/img/tree/table.gif");
    ImageIcon columnIcon = new ImageIcon("javase/src/GUI/Swing/img/tree/column.gif");
    ImageIcon indexIcon = new ImageIcon("javase/src/GUI/Swing/img/tree/index.gif");

    class NodeDate {
        public ImageIcon icon;
        public String name;

        public NodeDate(ImageIcon icon, String name) {
            this.icon = icon;
            this.name = name;
        }
    }

    DefaultMutableTreeNode root = new DefaultMutableTreeNode(new NodeDate(rootIcon, "数据库导航"));
    DefaultMutableTreeNode salaryDb = new DefaultMutableTreeNode(new NodeDate(databaseIcon, "公司工资数据库"));
    DefaultMutableTreeNode customerDb = new DefaultMutableTreeNode(new NodeDate(databaseIcon, "公司客户数据库"));
    DefaultMutableTreeNode employee = new DefaultMutableTreeNode(new NodeDate(tableIcon, "员工表"));
    DefaultMutableTreeNode attend = new DefaultMutableTreeNode(new NodeDate(tableIcon, "考勤表"));
    DefaultMutableTreeNode concat = new DefaultMutableTreeNode(new NodeDate(tableIcon, "联系方式表"));
    DefaultMutableTreeNode id = new DefaultMutableTreeNode(new NodeDate(indexIcon, "员工ID"));
    DefaultMutableTreeNode name = new DefaultMutableTreeNode(new NodeDate(columnIcon, "姓名"));
    DefaultMutableTreeNode gender = new DefaultMutableTreeNode(new NodeDate(columnIcon, "性别"));

    public void init() {
        root.add(salaryDb);
        root.add(customerDb);
        salaryDb.add(employee);
        salaryDb.add(attend);
        customerDb.add(concat);
        concat.add(id);
        concat.add(name);
        concat.add(gender);
        JTree tree = new JTree(root);

        //通过扩展的DefaultTreeRenderer类修改外观
        tree.setCellRenderer(new MyRenderer());

        jf.add(new JScrollPane(tree));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    //自定义类，继承DefaultTreeCellRenderer，完成结点的绘制
    private class MyRenderer extends DefaultTreeCellRenderer {  //此类间接继承了JLabel
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;   //获取当前结点
            NodeDate nodeDate = (NodeDate) node.getUserObject();  //获取当前结点实际传入的对象
            setText(nodeDate.name);
            setIcon(nodeDate.icon);
            return this;
        }
    }

    public static void main(String[] args) {
        new 扩展DefaultTreeCellRenderer().init();
    }
}
