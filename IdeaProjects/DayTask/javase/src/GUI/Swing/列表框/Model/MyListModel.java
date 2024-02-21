package GUI.Swing.列表框.Model;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MyListModel extends AbstractListModel<BigDecimal> {
    private BigDecimal start;
    private BigDecimal end;
    private BigDecimal step;

    public MyListModel(BigDecimal start, BigDecimal end, BigDecimal step) {
        this.start = start;
        this.end = end;
        this.step = step;
    }

    @Override
    public int getSize() {
        //数量 = (end - start) / step + 1
        //divide方法，参数：除数、保留小数位数、约等于的规则；Math.floor方法：向下取整
        int floor = (int) Math.floor(end.subtract(start).divide(step, 2, RoundingMode.HALF_DOWN).doubleValue());
        return floor + 1;
    }

    @Override
    public BigDecimal getElementAt(int index) {
        //setScale方法：参数为保留小数位数和约等于的规则
        return new BigDecimal(index).multiply(step).add(start).setScale(2, RoundingMode.HALF_DOWN);
    }

    public BigDecimal getStart() {
        return start;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public BigDecimal getStep() {
        return step;
    }
}
