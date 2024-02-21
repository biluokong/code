package 团队.demo8;

public class Practice3 {
    private static int count = 0;
    public static void InOrder(Node bsTree, int k){
        if (bsTree != null){
            InOrder(bsTree.getLeft(), k);
            if (++count == k) {
                System.out.println(bsTree.getData());
                return;
            }
            InOrder(bsTree.getRight(), k);
        }
    }
}