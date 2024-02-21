package com.bjpowernode.javase.实验十二图形用户界面设计;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorTest implements ActionListener {


    static JFrame frame = new JFrame("计算器");

    public static void main(String[] args) {
        new CalculatorTest();
    }

    public CalculatorTest() {
        frame.setSize(435, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        addButton();
        addTextField();
        frame.setVisible(true);
    }

    static public void addButton() {
        for (int i = 1; i < 8; i += 3) {
            for (int j = i; j < i + 3; j++) {
                JButton button = new JButton(j + "");
                if (1 == i) {
                    button.setBounds((j - i) * 100 + 10, 200, 100, 50);
                } else if (4 == i) {
                    button.setBounds((j - i) * 100 + 10, 150, 100, 50);
                } else {
                    button.setBounds((j - i) * 100 + 10, 100, 100, 50);
                }
                button.setActionCommand(j + "");
                button.setFont(new Font("宋体", Font.PLAIN, 24));
                frame.add(button);
            }
        }
        JButton[] button = {new JButton("÷"), new JButton("×"), new JButton("－"),
                new JButton("＝"), new JButton("＋"), new JButton("CE"), new JButton("0")};
        button[0].setBounds(310, 100, 100, 50);
        button[0].setActionCommand("÷");
        button[1].setBounds(310, 150, 100, 50);
        button[1].setActionCommand("×");
        button[2].setBounds(310, 200, 100, 50);
        button[2].setActionCommand("－");
        button[3].setBounds(310, 250, 100, 50);
        button[3].setActionCommand("＝");
        button[4].setBounds(210, 250, 100, 50);
        button[4].setActionCommand("＋");
        button[5].setBounds(110, 250, 100, 50);
        button[5].setActionCommand("CE");
        button[6].setBounds(10, 250, 100, 50);
        button[6].setActionCommand("0");
        for (JButton b : button) {
            b.setFont(new Font("宋体", Font.PLAIN, 24));
            frame.add(b);
        }
    }

    static JTextField textField1 = new JTextField();
    static JTextField textField2 = new JTextField();

    static public void addTextField() {

        textField1.setBounds(10, 0, 400, 50);
        textField2.setBounds(10, 50, 400, 50);
        textField1.setFont(new Font("宋体", Font.PLAIN, 25));
        textField2.setFont(new Font("宋体", Font.PLAIN, 25));
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField1.setHorizontalAlignment(JTextField.LEFT);
        textField2.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(textField1);
        frame.add(textField2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        System.out.println(action);
        StringBuffer str = new StringBuffer();
        if ("＝".equals(action)) {
            textField1.setText(new String(str));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } finally {
                textField1.setText("");
                str = str.replace(0, str.length(), "");
            }
        } else if ("CE".equals(action)) {
            if (str.length() != 0) {
                str = str.deleteCharAt(str.length() - 1);
                textField1.setText(new String(str));
            }
        } else {
            str = str.append(action);
            textField1.setText(new String(str));
        }
    }
}
