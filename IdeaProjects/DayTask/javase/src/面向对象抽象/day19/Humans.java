package 面向对象抽象.day19;

public class Humans {
    private String name;
    private int age;
    private String sex;

    public Humans() {
    }

    public Humans(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void ill() {
        System.out.println(name + "," + sex + "," + age + "岁生病了");
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
