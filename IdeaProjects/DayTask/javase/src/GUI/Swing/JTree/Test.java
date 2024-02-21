package GUI.Swing.JTree;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Test {
    JFrame jf = new JFrame("简单Swing树");

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
        tree.setPreferredSize(new Dimension(204, 360));

        JTextArea eventTxt = new JTextArea(5, 20);

        //tree.putClientProperty("JTree.lineStyle", "None");  //让结点之间没有连接线
        //tree.putClientProperty("JTree.lineStyle", "Horizontal");  //让结点之间只有水平分割线

        //设置选择模式
        TreeSelectionModel selectionModel = tree.getSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);  //单选

        //监听结点选中的事件
        tree.addTreeSelectionListener(e -> {
            TreePath newLeadSelectionPath = e.getNewLeadSelectionPath();
            eventTxt.append(newLeadSelectionPath.toString() + "\n");
        });

        //实现树的结点的编辑功能
        tree.setEditable(true); //让树可以编辑，默认状态下树是不可编辑的。
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();    //获取tree的model数据对象

        //添加兄弟结点的功能
        JButton addSiblingBtn = new JButton(new AbstractAction("添加兄弟结点") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //1、获取当前选中结点
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode == null)
                    return;

                //2、获取当前结点的父结点
                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
                if (parentNode == null)
                    return;

                //3、创建新结点
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新结点");

                //4、通过父结点来添加新结点
                int index = parentNode.getIndex(selectedNode);  //获取当前结点在父结点下的索引
                model.insertNodeInto(newNode, parentNode, index);   //将新结点插入到父结点下当前索引后面处

                //5、定位到当前新结点
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                tree.scrollPathToVisible(treePath); //滚动到新结点处

                //6、重绘tree
                tree.updateUI();
            }
        });

        //添加子结点的功能
        JButton addChildBtn = new JButton(new AbstractAction("添加子结点") {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode == null)
                    return;
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新结点");
                selectedNode.add(newNode);
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                tree.scrollPathToVisible(treePath);
                tree.updateUI();
            }
        });

        //删除结点的功能
        JButton deleteBtn = new JButton(new AbstractAction("删除结点") {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode != null && selectedNode.getParent() != null)
                    model.removeNodeFromParent(selectedNode);
            }
        });

        //编辑结点名称的功能
        JButton editBtn = new JButton(new AbstractAction("编辑结点") {
            @Override
            public void actionPerformed(ActionEvent e) {
                TreePath selectionPath = tree.getSelectionPath();   //获取选中结点的路径
                if (selectionPath != null)
                    tree.startEditingAtPath(selectionPath); //设置该路径处的结点可以编辑
            }
        });

        Box box = Box.createHorizontalBox();
        box.add(new JScrollPane(tree));
        box.add(eventTxt);
        jf.add(box);
        JPanel button = new JPanel();
        button.add(addSiblingBtn);
        button.add(addChildBtn);
        button.add(deleteBtn);
        button.add(editBtn);
        jf.add(button, BorderLayout.SOUTH);

        System.out.println(guangdong.getNextSibling());    //获得此结点的下一个兄弟结点
        System.out.println(guangdong.getParent());  //获得此结点的父结点
        System.out.println(guangdong.isLeaf()); //判断此结点是否是叶子结点
        System.out.println(guangdong.isRoot()); //判断此结点是否是根结点

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test().init();
    }
}
