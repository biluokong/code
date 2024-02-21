package 数组.day23;

import java.lang.reflect.Array;
import java.util.Scanner;

/*为某个酒店编写程序：酒店管理系统，模拟订房、退房、打印所有房间状态等功能。
	1、该系统的用户是：酒店前台。
	2、酒店使用一个二维数组来模拟。“Room[][] rooms;”
	3、酒店中的每一个房间应该是一个java对象：Room
	4、每一个房间Room应该有：房间编号、房间类型、房间是否空闲.
	5、系统应该对外提供的功能：
		可以预定房间：用户输入房间编号，订房。
		可以退房：用户输入房间编号，退房。
		可以查看所有房间的状态：用户输入某个指令应该可以查看所有房间状态。*/
class Test02 {
    public static void main(String[] args) {
        SimulationHotel hotel = new SimulationHotel();
        hotel.book("2003");
        hotel.book("1003");
        hotel.book("4002");
        hotel.checkOut("1003");
        hotel.checkOut("1002");
        hotel.examine();
    }
}

public class SimulationHotel {
    private Room[][] room;

    public SimulationHotel(Room[][] room) {
        this.room = room;
    }

    public SimulationHotel() {
        room = new Room[3][6];
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                room[i][j] = new Room();
                room[i][j].setNum((i + 1) + "00" + (j + 1));
                room[i][j].setFree(true);
                if (0 == i) {
                    room[i][j].setType("经济间");
                } else if (1 == i) {
                    room[i][j].setType("标准间");
                } else {
                    room[i][j].setType("豪华间");
                }
            }
        }
    }

    public void book(String num) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (num.equals(room[i][j].getNum()) && room[i][j].isFree()) {
                    room[i][j].setFree(false);
                    System.out.println("订房成功！您的房间号是：" + num);
                    return;
                }
            }
        }
        System.out.println("此编号房间不存在或已预订");
    }

    public void checkOut(String num) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (num.equals(room[i][j].getNum()) && !room[i][j].isFree()) {
                    room[i][j].setFree(true);
                    System.out.println(num + "房间退房成功！");
                    return;
                }
            }
        }
        System.out.println("此编号房间不存在或此房间没有人预订");
    }

    public void examine() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入指令：");
        String order = input.nextLine();
        if ("display".equals(order)) {
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[i].length; j++) {
                    System.out.print("房间编号：" + room[i][j].getNum());
                    System.out.print("  房间类型：" + room[i][j].getType());
                    System.out.println("  房间是否空闲:" + (room[i][j].isFree() ? "空闲" : "已订"));
                }
            }
        } else {
            System.out.println("指令不存在或错误");
        }
    }
}

class Room {
    private String num;
    private String type;
    private boolean free;

    public Room() {
    }

    public Room(String num, String type, boolean free) {
        this.num = num;
        this.type = type;
        this.free = free;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}