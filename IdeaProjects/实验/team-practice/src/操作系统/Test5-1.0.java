package 操作系统;

import java.util.*;

// 不能解决key重复的问题
class Main {
    private static int start = 0, temp = 0, address = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int partNum = input.nextInt();
        TreeMap<Integer, Integer> assignedPart = new TreeMap<>();
        for (int i = 0; i < partNum; i++)
            assignedPart.put(input.nextInt(), input.nextInt());
        int[] space = new int[3];
        for (int i = 0; i < 3; i++)
            space[i] = input.nextInt();
        String algorithm = input.next();
        if ("BEST".equals(algorithm)) {
            TreeMap<Integer, Integer> freePart = new TreeMap<>();
            allocation(assignedPart, freePart, space, false);
        } else if ("NEXT".equals(algorithm)) {
            LinkedHashMap<Integer, Integer> freePart = new LinkedHashMap<>();
            allocation(assignedPart, freePart, space, true);
        } else if ("WORST".equals(algorithm)) {
            TreeMap<Integer, Integer> freePart = new TreeMap<>((x, y) -> y - x);
            allocation(assignedPart, freePart, space, false);
        }
    }

    private static void allocation(TreeMap<Integer, Integer> assignedPart, Map<Integer, Integer> freePart, int[] space, boolean next) {
        for (int i = 0; i < 3; i++) {
            temp = i;
            start = 0;
            assignedPart.forEach((a, s) -> {
                if (a - start > 0) {
                    if (next)
                        freePart.put(start, a - start);
                    else
                        freePart.put(a - start, start);
                }
                start = a + s;
            });
            if (start < 1024 && ((next && freePart.put(start, 1024 - start) == null) || !next && freePart.put(1024 - start, start) == null));
            freePart.forEach((a, s) -> {
                if (temp == -1)
                    return;
                if ((next && freePart.get(address = a) >= space[temp] && assignedPart.put(a, space[temp]) == null)
                        || (!next && a >= space[temp] && (address = s) != -1 && assignedPart.put(s, space[temp]) == null)) {
                    System.out.print(address + " ");
                    temp = -1;
                }
            });
            if (temp != -1)
                System.out.print(false + " ");
            freePart.clear();
        }
    }
}