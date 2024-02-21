package 集合.day30;

import java.util.*;
import java.util.concurrent.Callable;

/*分别用Comparable和Comparator两个接口对下列四位同学的成绩做降序排序，如果成绩一样，
    那在成绩排序的基础上按照年龄由小到大排序。
    姓名（String）年龄（int）分数（float）
    liusan			20				90.0F
    lisi				22				90.0F
    wangwu			20				99.0F
    sunliu			22				100.0F
    编写一个Student类用来实现Comparable<Student>接口,
    并在其中重写CompareTo(Student o)方法　
    在主函数中使用Comparable 与 Comparetor分别对ArrayList进行排序.*/
public class Test03 {
    public static void main(String[] args) {
        Collection<Student> treeSet = new TreeSet<>();
        List<Student> array = new ArrayList<>(4);
        array.add(new Student("刘三", 20, 90F));
        array.add(new Student("李四", 22, 90F));
        array.add(new Student("王五", 20, 99F));
        array.add(new Student("孙刘", 22, 100F));
        treeSet.addAll(array);
        Collections.sort(array);
        for (Student student : array) {
            System.out.println(student);
        }
        System.out.println("=====================================");
        for (Student student : treeSet) {
            System.out.println(student);
        }
        Comparator<Student> comparator = new StudentComparator();
        array.sort(comparator);
        System.out.println("=====================================");
        for (Student student : array) {
            System.out.println(student);
        }
        array.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getFraction() == o2.getFraction()) {
                    return o2.getAge() - o1.getAge();
                }
                return (int) (o2.getFraction() - o1.getFraction());
            }
        });
        System.out.println("=====================================");
        for (Student student : array) {
            System.out.println(student);
        }
    }
}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getFraction() == o2.getFraction()) {
            return o1.getAge() - o2.getAge();
        }
        return (int) (o1.getFraction() - o2.getFraction());
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private float fraction;

    public Student() {
    }

    public Student(String name, int age, float fraction) {
        this.name = name;
        this.age = age;
        this.fraction = fraction;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", fraction=" + fraction +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.fraction == o.fraction) {
            return this.age - o.age;
        }
        return (int) (o.fraction - this.fraction);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getFraction() {
        return fraction;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
    }
}
