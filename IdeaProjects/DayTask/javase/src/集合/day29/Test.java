package 集合.day29;

public class Test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        list.delete(1);
        list.delete(4);
        list.delete(10);
        list.setDate(2, 12);
        list.setDate(6, 23);
        list.setDate(9, 30);
        list.print();
    }
}