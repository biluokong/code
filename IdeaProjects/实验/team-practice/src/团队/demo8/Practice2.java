package 团队.demo8;

public class Practice2 {
    public static void PreOrder(Node node){
        if (node != null){
            visit(node);
            PreOrder(node.getLeft());
            PreOrder(node.getRight());
        }
    }

    public static void visit(Node node) {

    }
}
