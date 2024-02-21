package 团队.demo10;

class BTNode {
    private int data;
    private BTNode left;
    private BTNode right;

    public int getData() {
        return data;
    }

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
    }
}

class BiTree {
    private BTNode root;

    public BTNode getRoot() {
        return root;
    }
}

class LinkQueue {
    public void enQueue(BTNode node) {
    }
    public BTNode deQueue() {
        return new BTNode();
    }
    public boolean isEmpty() {
        return true;
    }
}

public class Practice3 {
    int getDepthByMaxSum(BiTree T){
        LinkQueue q1 = new LinkQueue(), q2 = new LinkQueue();
        BTNode p = T.getRoot();
        int sum = 0, temp = 0, depth = 0, count = 0;
        q1.enQueue(p);
        while (!q1.isEmpty() || !q2.isEmpty()){
            temp = 0;
            count++;
            while (!q1.isEmpty()){
                p = q1.deQueue();
                temp += p.getData();
                if (p.getLeft() != null)
                    q2.enQueue(p.getLeft());
                if (p.getLeft() != null)
                    q2.enQueue(p.getRight());
            }
            if (temp > sum){
                sum = temp;
                depth = count;
            }
            temp = 0;
            count++;
            while (!q2.isEmpty()){
                p = q2.deQueue();
                temp += p.getData();
                if (p.getLeft() != null)
                    q1.enQueue(p.getLeft());
                if (p.getLeft() != null)
                    q1.enQueue(p.getRight());
            }
            if (temp > sum){
                sum = temp;
                depth = count;
            }
        }
        return depth;
    }
}
