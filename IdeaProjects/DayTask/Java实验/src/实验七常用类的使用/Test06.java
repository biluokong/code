package 实验七常用类的使用;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test06 {
    public static void main(String[] args) {
        //创建一个保存时间为当前时间加上100天后的时间的Date对象
        Date date = new Date(System.currentTimeMillis() + 100 * 24 * 60 * 60 * 1000L);
        //创建一个DateFormat对象，并设置日期格式为yyyy年MM月dd日星期u HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日星期u HH:mm:ss");
        //以此DateFormat对象格式化date对象，并输出到控制台
        System.out.println(sdf.format(date));

        /*long day = 24 * 60 * 60 * 1000;
        String s = "";
        int flag = 0, count = 0;
        while (s.indexOf("06月30日") == -1) {
            flag++;
            Date date = new Date(System.currentTimeMillis() + day * flag);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日星期u HH:mm:ss");
            s = sdf.format(date);
            if (s.indexOf("星期3") != -1 || s.indexOf("星期4") != -1 || s.indexOf("星期5") != -1) {
                count++;
            }
            System.out.println(s);
        }
        System.out.println(count);*/
    }
}