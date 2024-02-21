package 数据结构.逻辑结构.线性结构.串;

public class CharNode {
    private char[] piece;
    private int maxSize;
    private CharNode next;

    public CharNode(int maxSize, char[] piece) {
        if (maxSize >= piece.length) {
            this.maxSize = maxSize;
            piece = new char[maxSize];
            for (int i = 0; i < piece.length; i++) {
                this.piece[i] = piece[i];
            }
        }
        System.out.println("方法的容量大小！");
    }

    public CharNode(int maxSize, CharNode next) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            piece = new char[maxSize];
            this.next = next;
            return;
        }
        System.out.println("非法的容量大小！");
    }

    public CharNode(int maxSize, char[] piece, CharNode next) {
        if (maxSize >= piece.length) {
            this.maxSize = maxSize;
            piece = new char[maxSize];
            for (int i = 0; i < piece.length; i++) {
                this.piece[i] = piece[i];
            }
            this.next = next;
            return;
        }
        System.out.println("方法的容量大小！");
    }

    public CharNode(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            piece = new char[maxSize];
            return;
        }
        System.out.println("非法的容量大小！");
    }

    public CharNode(char[] piece) {
        this.piece = piece;
    }

    public CharNode(char[] piece, CharNode next) {
        this.piece = piece;
        this.next = next;
    }

    public CharNode(CharNode next) {
        this.next = next;
    }

    public char[] getPiece() {
        return piece;
    }

    public CharNode setPiece(char[] piece) {
        this.piece = piece;
        return this;
    }

    public CharNode getNext() {
        return next;
    }

    public CharNode setNext(CharNode next) {
        this.next = next;
        return this;
    }
}
