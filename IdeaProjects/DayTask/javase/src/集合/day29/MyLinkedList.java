package 集合.day29;

public class MyLinkedList {
    Node first;

    public MyLinkedList() {
        first = null;
    }

    public void add(Object date) {
        if (first == null) {
            first = new Node(date);
            System.out.println("添加数据成功");
            return;
        }
        Node temp = first;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(new Node(date));
        System.out.println("添加数据成功");
    }

    public Node find(Object date) {
        if (first == null) {
            System.out.println("链表为空");
            return null;
        }
        if (date.equals(first.getData())) {
            System.out.println("找到了相关数据");
            return first;
        }
        Node flag = first;
        Node temp = first;
        while (!date.equals(temp.getData()) && temp != null) {
            flag = temp;
            temp = temp.getNext();
        }
        if (temp == null) {
            System.out.println("没找到相关数据");
            return null;
        } else {
            System.out.println("找到了相关数据");
            return flag;
        }
    }

    public void delete(Object date) {
        Node temp = find(date);
        if (null == temp) {
            System.out.println("没有删除数据！");
            return;
        }
        if (first == temp) {
            first = first.getNext();
            System.out.println("数据已删除！");
            return;
        }
        temp.setNext(temp.getNext().getNext());
        System.out.println("数据已删除");
    }

    public void setDate(Object date1, Object date2) {
        Node temp = find(date1);
        if (null == temp) {
            System.out.println("修改失败，无此数据");
            return;
        }
        if (first == temp) {
            first.setData(date2);
            System.out.println("修改成功");
            return;
        }
        temp.getNext().setData(date2);
        System.out.println("修改成功");
    }

    public void print() {
        Node temp = first;
        int i = 1;
        while (temp != null) {
            System.out.println(i++ + " : " + temp.getData());
            temp = temp.getNext();
        }
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }
}
