package 数据结构.逻辑结构.非线性结构.树形结构.二叉树;

import 数据结构.逻辑结构.线性结构.栈.MyLinkedStack;
import 数据结构.逻辑结构.线性结构.队列.MyLinkedQueue;

public class BinaryTree<E> {
    private BiNode node;

    /**
     * 无参构造创建一个二叉树，并将传入的数据放入根结点中
     * @param e
     */
    BinaryTree(E e) {
        node = new BiNode(e);
    }

    /**
     * 无参构造创建一个空二叉树
     */
    BinaryTree() {
        node = new BiNode();
    }

    /**
     * 有参构造方法创建一个二叉树，并将传入的二叉树的数据复制到创建的二叉树中
     * @param node
     */
    BinaryTree(BiNode node) {
        this.node = new BiNode();
        copy(node, this.node);
    }

    public void add(E e) {

    }

    /**
     * 先序递归复制一个二叉树
     * @param node
     */
    public static void copy(BiNode node, BiNode newNode) {
        if (node == null) {
            newNode = null;
            return;
        }
        BiNode temp = new BiNode(node.getData());
        copy(node.getLeftChild(), newNode.getLeftChild());
        copy(node.getRightChild(), newNode.getRightChild());
    }

    /**
     * 获得当前树的深度
     * 若是空树，则树的深度为0；
     * 若非空树，假设递归计算左子树的深度为m，递归计算右子树的深度为n，则二叉树的深度则为m与n的较大者加1
     * @return
     */
    public int getDepth() {
        return depth(node);
    }

    /**
     * 递归方法获得一个二叉树的深度
     * @param node
     * @return
     */
    public static int depth(BiNode node) {
        if (node == null) {
            return 0;
        }
        int m = 0, n = 0;
        m = depth(node.getLeftChild());
        n = depth(node.getRightChild());
        return (m > n) ? ++m : ++n;
    }

    /**
     * 获得当前树的总结点数
     * @return
     */
    public int getNodeCount() {
        return nodeCount(node);
    }

    /**
     * 递归获得一个二叉树的总结点数
     * 若是空树，则树的总结点数为0；
     * 若非空树，则其总结点个数为左子树的结点个数+右子树的结点个数+1(根结点)
     * @param node
     * @return
     */
    public static int nodeCount(BiNode node) {
        if (node == null) {
            return 0;
        }
        return nodeCount(node.getLeftChild()) + nodeCount(node.getRightChild()) + 1;
    }

    /**
     * 递归获得一个二叉树的总叶子树
     * 若是空树，则树的总叶子结点数为0；
     * 若非空树，则其总叶子结点数为左子树的叶子结点个数+右子树的叶子结点个数
     * @param node
     * @return
     */
    public static int leafCount(BiNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 1;
        }
        return leafCount(node.getLeftChild()) + leafCount(node.getRightChild());
    }

    /**
     * 递归方法先序遍历
     * @param node
     */
     public static void recursivePreOrderTraverse(BiNode node) {
        if (node == null) {
            return;
        }
        visit(node);   //访问根结点
        recursivePreOrderTraverse(node.getLeftChild());     //递归遍历左子树
        recursivePreOrderTraverse(node.getRightChild());    //递归遍历右子树
    }

    /**
     * 递归方法后序遍历
     * @param node
     */
    public static void recursiveInorderTraverse(BiNode node) {
        if (node == null) {
            return;
        }
        recursiveInorderTraverse(node.getLeftChild());
        visit(node);
        recursiveInorderTraverse(node.getRightChild());
    }

    /**
     * 递归方法后序遍历
     * @param node
     */
    public void recursivePostOrderTraverse(BiNode node) {
        if (node == null) {
            return;
        }
        recursivePostOrderTraverse(node.getLeftChild());
        recursivePostOrderTraverse(node.getRightChild());
        visit(node);
    }

    /**
     * 栈表示方法的中序遍历
     * @param node
     */
    public void InOrderTraverse(BiNode node) {
        BiNode temp = node;
        MyLinkedStack<BiNode> stack = new MyLinkedStack();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.getLeftChild();
            }
            System.out.println(stack.getValue().getData());
            stack.pop();
            temp = temp.getRightChild();
        }
    }

    /**
     * 用队列实现二叉树层次循环，也可以用栈实现
     * @param node
     */
    public void levelOrderTraverse(BiNode node) {
        BiNode temp = node;
        MyLinkedQueue<BiNode> queue = new MyLinkedQueue();
        queue.enQueue(temp);    //根结点入队
        while (!queue.isEmpty()) {  //队不为空，则循环
            System.out.println(queue.getHead().getData());
            queue.deQueue();    //出队结点temp
            if (temp.getLeftChild() != null) {  //当有左孩子时，将其进队
                queue.enQueue(temp.getLeftChild());
            }
            if (temp.getRightChild() != null) { //当有右孩子时，将其进队
                queue.enQueue(temp.getRightChild());
            }
        }
    }

    private static void visit(BiNode node) {

    }
}
