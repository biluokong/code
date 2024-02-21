package 集合.day30;

import java.lang.reflect.Array;
import java.util.*;

/*Map<Integer,String> map = new HashMap<Integer, String>();
map.put(1, "张三丰");
map.put(2, "周芷若");
map.put(3, "汪峰");
map.put(4, "灭绝师太");
要求：
	1.遍历集合，并将序号与对应人名打印。
	2.向该map集合中插入一个编码为5姓名为郭靖的信息
	3.移除该map中的编号为1的信息
	4.将map集合中编号为2的姓名信息修改为"周林"*/
public class Test04 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");
        Set<Integer> treeSet = map.keySet();
//        Collection<String> array = map.values();
        for (Integer integer : treeSet){
            System.out.println(integer + " : " + map.get(integer));
        }
        /*for (String s : array) {
            System.out.println(s);
        }*/
        map.put(5, "郭靖");
        map.remove(1);
        map.replace(2, "周林");
        for (Integer integer : treeSet) {
            System.out.println(integer + " : " + map.get(integer));
        }
    }
}
