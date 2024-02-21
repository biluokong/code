package GUI.AWT;

import javax.swing.*;
import java.awt.*;

public class Awt常用组件 {
    private Frame frame = new Frame("awt常用组件");
    private TextArea ta = new TextArea(5, 20);  //多行文本域
    private Choice color = new Choice();    //下拉选择框

    private CheckboxGroup cbg = new CheckboxGroup();    //能将多个复选框组件组合为一组，形成单选框组件
    private Checkbox male = new Checkbox("男", cbg, true);   //复选框，true代表默认选中
    private Checkbox female = new Checkbox("女", cbg, false);   //复选框

    private Checkbox isMarried = new Checkbox("是否已婚？");

    private TextField tf = new TextField(50);   //单行文本框
    private Button ok = new Button("确认");

    private List colorList = new List(6, true); //列表框，true代表可以多选，否则只能单选

    /**
     * 组装界面
     */
    public void init() {
        //从底往上
        //组装底部
        Box dBox = Box.createHorizontalBox();
        dBox.add(tf);
        dBox.add(ok);
        frame.add(dBox, BorderLayout.SOUTH);

        //组装选择部分
        color.add("红色");
        color.add("蓝色");
        color.add("绿色");
        Box cBox = Box.createHorizontalBox();
        cBox.add(color);
        cBox.add(male);
        cBox.add(female);
        cBox.add(isMarried);

        //组装多行文本域和选择部分
        Box leftTop = Box.createVerticalBox();
        leftTop.add(ta);
        leftTop.add(cBox);

        //组装leftTop和列表框
        colorList.add("红色");
        colorList.add("蓝色");
        colorList.add("绿色");
        Box top = Box.createHorizontalBox();
        top.add(leftTop);
        top.add(colorList);

        frame.add(top);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Awt常用组件().init();
    }
}
