package GUI.Swing.JTable;

import javax.swing.*;
import javax.swing.table.TableColumn;

public class Test {
    JFrame jf = new JFrame("简单表格");
    Object[] titles = {"姓名", "年龄", "性别"};
    Object[][] data = {
            {"李清照", 29, "女"},
            {"苏格拉底", 55, "男"},
            {"李白", 35, "男"},
            {"弄玉", 18, "女"},
            {"虎头", 2, "男"}
    };

    public void init() {
        JTable jTable = new JTable(data, titles);

        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //设置为单选
        TableColumn column_1 = jTable.getColumn(titles[0]); //根据列名获得一列
        column_1.setMinWidth(40);   //设置列的最小宽度
        column_1.setMaxWidth(50);   //设置列的最大宽度

        jf.add(new JScrollPane(jTable));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Test().init();
    }
}
