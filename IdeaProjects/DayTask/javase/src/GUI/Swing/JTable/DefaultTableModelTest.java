package GUI.Swing.JTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class DefaultTableModelTest {
    JFrame jf = new JFrame("简单表格");
    Object[] titles = {"姓名", "年龄", "性别"};
    Object[][] data = {
            {"李清照", 29, "女"},
            {"苏格拉底", 55, "男"},
            {"李白", 35, "男"},
            {"弄玉", 18, "女"},
            {"虎头", 2, "男"}
    };
    private Vector titlesV = new Vector();
    private Vector<Vector> dataV = new Vector<>();

    public void init() {
        for (int i = 0; i < titles.length; i++)
            titlesV.add(titles[i]);
        for (int i = 0; i < data.length; i++) {
            Vector t = new Vector();
            for (int i1 = 0; i1 < data[i].length; i1++)
                t.add(data[i][i1]);
            dataV.add(t);
        }

        DefaultTableModel model = new DefaultTableModel(dataV, titlesV);    //创建Model对象
        JTable jTable = new JTable(model);  //通过Model对象创建JTable对象

        JButton addRow = new JButton(new AbstractAction("添加一行") {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[] {"王五", 2, "男"});
            }
        });

        JButton addColum = new JButton(new AbstractAction("添加一列") {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addColumn("职业");
            }
        });

        JButton deleteRow = new JButton(new AbstractAction("删除一行") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTable.getSelectedRow();
                if (selectedRow == -1)
                    return;
                model.removeRow(selectedRow);
            }
        });

        JPanel jPanel = new JPanel();
        jPanel.add(addRow);
        jPanel.add(addColum);
        jPanel.add(deleteRow);
        jf.add(jPanel, BorderLayout.SOUTH);
        jf.add(new JScrollPane(jTable));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new DefaultTableModelTest().init();
    }
}
