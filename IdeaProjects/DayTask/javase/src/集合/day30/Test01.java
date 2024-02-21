package 集合.day30;

import java.util.*;

/*产生10个1-100的随机数，并放到一个数组中，
     把数组中大于等于10的数字放到一个list集合中，
     并打印到控制台。*/
public class Test01 {
    public static void main(String[] args) {
        int[] a = new int[10];
        List<Integer> array = new ArrayList<>();
        Collection<Integer> hash = new HashSet<>();
        Collection<Integer> tree = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            a[i] = new Random().nextInt(100) + 1;
            if (a[i] > 10) {
                array.add(a[i]);
                hash.add(a[i]);
                tree.add(a[i]);
            }
        }
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n==================================");
        Iterator i = array.listIterator(2);

        while (i.hasNext()) {
            System.out.print(i.next() + " ");
            i.remove();
        }
        System.out.println("\n==================================");
        for (Integer integer : hash) {
            System.out.print(integer + " ");
        }
        System.out.println("\n==================================");
        for (Integer integer : tree) {
            System.out.print(integer + " ");
        }
    }
}
