package 反射机制.模拟通用框架;

public class ReflectDemo {
    public static void main(String[] args) {
        Student s = new Student("李四", "1234");
        MybatisUtil.save(s);

        Teacher t = new Teacher("王五", "2343434");
        MybatisUtil.save(t);
    }
}
