package 集合.day30;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*已知数组存放一批QQ号码，QQ号码最长为11位，最短为5位String[] strs =
    {"12345","67891","12347809933","98765432102","67891","12347809933"}。
    将该数组里面的所有qq号都存放在LinkedList中，将list中重复元素删除，
    将list中所有元素分别用迭代器和增强for循环打印出来。*/
public class Test02 {
    public static void main(String[] args) {
        String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"};
        List<String> list = new LinkedList<>();
        for (String str : strs) {
            list.add(str);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j)) && i != j) {
                    list.remove(j);
                }
            }
        }
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("=====================================");
        Iterator i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
