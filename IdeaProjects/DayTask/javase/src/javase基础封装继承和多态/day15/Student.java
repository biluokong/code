package javase基础封装继承和多态.day15;

public class Student {
    private String name;
    private int age;
    private String address;
    private String zipCode;
    private String mobile;

    public Student() {
    }

    public Student(String name, int age, String address, String zipCode, String mobile) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.zipCode = zipCode;
        this.mobile = mobile;
    }

    public String getPostAddress() {
        return "地址：" + address + "\n邮政编码：" + zipCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("王五", 15, "广东省潮安区彩塘镇", "23424", "12344442323" );
        System.out.println(student.getPostAddress());
    }
}
