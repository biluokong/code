package GUI.Swing.列表框;

import GUI.Swing.列表框.Model.MyComboBoxListModel;
import GUI.Swing.列表框.Model.MyListModel;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 不强制储存的ListModel和ComboBoxModel
 */
public class ListModelAndComboBoxModel {
    JFrame jf = new JFrame("测试ListModel和ComboBoxModel");
    JList<BigDecimal> jList;
    JComboBox<BigDecimal> jComboBox;
    JLabel label;
    JTextField jTextField;

    public void init() {
        jList = new JList<>(new MyListModel(new BigDecimal(1), new BigDecimal(21), new BigDecimal(2)));
        jComboBox = new JComboBox<>(new MyComboBoxListModel(new BigDecimal(0.1), new BigDecimal(1.2), new BigDecimal(0.1)));
        label = new JLabel("你选择的是：");
        jTextField = new JTextField(15);

        jList.setVisibleRowCount(4);
        jList.setSelectionInterval(2, 4);

        //设置列表中每个单元格的大小
        jList.setFixedCellWidth(90);
        jList.setFixedCellHeight(30);

        jList.addListSelectionListener(e -> {
            List<BigDecimal> selectedValuesList = jList.getSelectedValuesList();
            jTextField.setText("");
            for (BigDecimal item : selectedValuesList) {
                jTextField.setText(jTextField.getText() + item + "、");
            }
        });

        jComboBox.setMaximumRowCount(4);
        jComboBox.addItemListener(e -> {
            Object selectedItem = jComboBox.getSelectedItem();
            //setToolTopText方法：设置当光标停留时显示的信息
            //jTextField.setToolTipText(selectedItem.toString());
            jTextField.setText(selectedItem.toString());
        });

        Box hBox = Box.createHorizontalBox();
        hBox.add(new JScrollPane(jList));

        JPanel jPanel = new JPanel();
        jPanel.add(jComboBox);
        hBox.add(jPanel);
        jf.add(hBox);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(label);
        bottomPanel.add(jTextField);
        jf.add(bottomPanel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ListModelAndComboBoxModel().init();
    }
}
