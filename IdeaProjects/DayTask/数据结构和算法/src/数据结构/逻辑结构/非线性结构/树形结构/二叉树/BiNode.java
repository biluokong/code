package 数据结构.逻辑结构.非线性结构.树形结构.二叉树;

public class BiNode {
    private Object data;
    private BiNode leftChild, rightChild;

    public BiNode() {
    }

    public BiNode(Object data) {
        this.data = data;
    }

    public BiNode(BiNode leftChild, BiNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BiNode(BiNode leftChild) {
        this.leftChild = leftChild;
    }

    public BiNode(Object data, BiNode leftChild) {
        this.data = data;
        this.leftChild = leftChild;
    }

    public BiNode(Object data, BiNode leftChild, BiNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Object getData() {
        return data;
    }

    public BiNode setData(Object data) {
        this.data = data;
        return this;
    }

    public BiNode getLeftChild() {
        return leftChild;
    }

    public BiNode setLeftChild(BiNode leftChild) {
        this.leftChild = leftChild;
        return this;
    }

    public BiNode getRightChild() {
        return rightChild;
    }

    public BiNode setRightChild(BiNode rightChild) {
        this.rightChild = rightChild;
        return this;
    }
}
