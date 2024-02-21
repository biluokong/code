package GUI.AWT;

import 面向对象抽象.day21.Keyboard;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 1、菜单组件MenuItem要放在菜单条组件MenuBar容器中
 * 2、菜单组件Menu可以放入各种MenuItem组件（包括Menu，它本身也继承了MenuItem）
 */
public class 菜单组件 {
    private Frame frame = new Frame("菜单组件");    //创建窗口
    private TextArea ta = new TextArea(6, 40);  //创建多行文本域
    private MenuBar bar = new MenuBar();    //创建菜单条
    private PopupMenu popupMenu = new PopupMenu();  //创建上下文菜单组件（右键菜单组件）
    //创建菜单组件
    Menu fileMenu = new Menu("文本");
    Menu editMenu = new Menu("编辑");
    Menu formatMenu = new Menu("格式");
    //菜单项组件
    MenuItem auto = new MenuItem("自动换行");
    MenuItem copy = new MenuItem("复制");
    MenuItem paste = new MenuItem("粘贴");
    MenuItem comment = new MenuItem("注释", new MenuShortcut(KeyEvent.VK_Q, true));
    MenuItem cancelComment = new MenuItem("取消注释");

    public 菜单组件() {
        init();
        frame.pack();
        frame.setVisible(true);
    }

    public void init() {
        comment.addActionListener(e -> ta.append("您点击了菜单项：" + e.getActionCommand() + "\n"));
        //组装格式菜单
        formatMenu.add(comment);
        formatMenu.add(cancelComment);
        //组装编辑菜单
        editMenu.add(auto);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(formatMenu);
        //组装菜单条
        bar.add(fileMenu);
        bar.add(editMenu);
        //组装右键菜单
        popupMenu.add(comment);
        popupMenu.add(cancelComment);
        popupMenu.add(copy);
        popupMenu.add(paste);
        frame.add(popupMenu);
        //给frame注册鼠标右击事件，显示右键菜单
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(frame, e.getX(), e.getY());
                }
            }
        });
        //把菜单条组装到frame中
        frame.setMenuBar(bar);
        frame.add(ta, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new 菜单组件();
    }
}
