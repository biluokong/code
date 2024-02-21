package 数据结构.逻辑结构.线性结构.栈;

public class Test {
    public static void main(String[] args) {
        /*MyArrayStack<Integer> stack = new MyArrayStack<>(5);
        stack.push(3);
        stack.push(9);
        stack.push(12);
        stack.push(8);
        stack.push(22);
        stack.push(22);
        int n = stack.getLength();
        for (int i = 0; i < n; i++) {
            System.out.println(stack.getTopValue());
            stack.pop();
        }
        stack.pop();
        stack.push(3);
        stack.push(9);
        stack.push(12);
        stack.destroy();
        stack.push(3);
        n = stack.getLength();
        for (int i = 0; i < n; i++) {
            System.out.println(stack.getTopValue());
            stack.pop();
        }*/
        MyLinkedStack<Integer> stack = new MyLinkedStack();
        stack.push(3);
        stack.push(4);
        stack.push(12);
        System.out.println(stack.getValue());
        System.out.println(stack.getLength());
        System.out.println(stack.isEmpty());
        stack.clear();
        while (stack.getNode() != null) {
            System.out.println(stack.getNode().getData());
            stack.pop();
        }
        stack.pop();
        System.out.println(stack.isEmpty());
        System.out.println(stack.getLength());
    }
}
