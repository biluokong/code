package GUI.Swing.JTable;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

/**
 * （自定义）扩展AbstractTableModel
 */
public class JTableModelTest {
    JFrame jf = new JFrame("扩展TableModel");
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

        MyTableModel myTableModel = new MyTableModel();
        //JTable jTable = new JTable(dataV, titlesV);   //通过集合对象创建表格
        JTable jTable = new JTable(myTableModel); //通过Model对象创建表格

        JButton btn = new JButton(new AbstractAction("获取选中行数据") {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedColumn = jTable.getSelectedColumn();
                int selectedRow = jTable.getSelectedRow();
                System.out.println("行索引：" + selectedRow + "，列索引：" + selectedColumn);
                System.out.println("数据：" + myTableModel.getValueAt(selectedRow, selectedColumn));
            }
        });

        jf.add(btn, BorderLayout.SOUTH);
        jf.add(new JScrollPane(jTable));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    private class MyTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return dataV.size();
        }

        @Override
        public int getColumnCount() {
            return titlesV.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return dataV.get(rowIndex).get(columnIndex);
        }

        @Override
        public String getColumnName(int column) {
            return (String) titlesV.get(column);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    }

    public static void main(String[] args) {
        new JTableModelTest().init();
    }
}
