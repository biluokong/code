package GUI.Swing.列表框.Model;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MyComboBoxListModel extends MyListModel implements ComboBoxModel<BigDecimal> {
    private int selectedId; //当前选中条目的索引

    public MyComboBoxListModel(BigDecimal start, BigDecimal end, BigDecimal step) {
        super(start, end, step);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof BigDecimal) {
            selectedId = ((BigDecimal) anItem).subtract(getStart()).divide(getStep(), 2, RoundingMode.HALF_DOWN).intValue();
        }
    }

    @Override
    public Object getSelectedItem() {
        return new BigDecimal(selectedId).multiply(getStep()).add(getStart()).setScale(1, RoundingMode.HALF_DOWN);
    }
}
