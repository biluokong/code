package 数据结构.逻辑结构.线性结构.栈;

/**
 * 用数组实现栈结构
 * @param <E>
 */
public class MyArrayStack<E> {
    private E[] stack;
    private int maxSize;
    private int top;

    /**
     * 无参构造方法初始化一个容量大小为10的栈
     */
    public MyArrayStack() {
        maxSize = 10;
        stack = (E[]) new Object[10];
        top = 0;
    }

    /**
     * 有参构造方法初始化一个容量大小为maxSize的栈
     * @param maxSize
     */
    public MyArrayStack(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
            stack = (E[]) new Object[maxSize];
            top = 0;
            return;
        }
        System.out.println("创建栈失败，非法的容量大小！");
    }

    /**
     * 从栈顶中弹出一个元素，并返回此元素；若栈为空，则弹栈失败，返回null
     * @return
     */
    public E pop() {
        if (top != 0) {
            top--;
            return stack[top];
        }
        System.out.println("弹栈失败，栈中没有元素！");
        return null;
    }

    /**
     * 压入一个元素到栈中，若栈已满，则压栈失败
     * @param e
     */
    public void push(E e) {
        if (top < maxSize) {
            stack[top++] = e;
            return;
        }
        System.out.println("元素添加失败，栈已满！");
    }

    /**
     * 将栈的原容量扩大为maxSize+expandingSize
     * @param expandingSize
     */
    public void expansion(int expandingSize) {
        if (expandingSize > 0) {
            Object[] temp = new Object[maxSize + expandingSize];
            for (int i = 0; i < top; i++) {
                temp[i] = stack[i];
            }
            stack = (E[]) temp;
            return;
        }
        System.out.println("扩容失败，非法的扩容大小！");
    }

    /**
     * 获取栈顶元素，若栈中没有元素，则返回null
     * @return
     */
    public E getTopValue() {
        if (top != 0) {
            return stack[top - 1];
        }
        System.out.println("栈中没有数据！");
        return null;
    }

    /**
     * 判断栈是否为空栈
     * @return
     */
    public boolean isEmpty() {
        return top == 0 ? true : false;
    }

    /**
     * 清空栈中数据
     */
    public void clear() {
        top = 0;
    }

    /**
     * 销毁栈
     */
    public void destroy() {
        stack = null;
        top = 0;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getLength() {
        return top;
    }
}
