package 操作系统;

import java.util.*;

public class Test5 {
    private static int start;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int partNum = input.nextInt();   // 分区占用数量0-4之间
        TreeMap<Integer, Integer> assignedPart = new TreeMap<>(); // 已分配的分区的起始地址和大小
        for (int i = 0; i < partNum; i++)
            assignedPart.put(input.nextInt(), input.nextInt());
        int[] space = new int[3];    // 进程申请的空间大小
        for (int i = 0; i < 3; i++)
            space[i] = input.nextInt();
        String algorithm = input.next();    // 所选内存空间分配算法
        allocation(assignedPart, new ArrayList<>(), space, algorithm);
    }

    /**
     *
     * @param assignedPart 已分配的分区
     * @param freePart 空闲分区
     * @param space 请求分配的空间
     * @param algorithm 选择的算法：NEXT（按地址从小到大）、BEST（按分区大小从小到大）、WORST（与BEST相反）
     */
    private static void allocation(TreeMap<Integer, Integer> assignedPart, List<int[]> freePart, int[] space, String algorithm) {
        for (int i = 0; i < 3; i++) {
            int temp = i, address = -1;
            start = 0;
            assignedPart.forEach((a, s) -> {    // 更新空闲分区集合
                if (a - start > 0 && freePart.add(new int[]{start, a - start}));
                start = a + s;
            });
            if (start < 1024 && freePart.add(new int[]{start, 1024 - start}));
            if (!"NEXT".equals(algorithm))
                freePart.sort((x, y) -> "BEST".equals(algorithm) ? x[1] - y[1] : y[1] - x[1]);
            for (int[] part : freePart) {
                if (part[1] >= space[temp] && assignedPart.put((address = part[0]), space[temp]) == null)
                    break;
            }
            System.out.print((address != -1 ? address : false) + " ");
            freePart.clear();   // 清空空闲分区集合
        }
    }
}