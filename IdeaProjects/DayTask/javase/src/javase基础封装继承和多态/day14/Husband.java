package javase基础封装继承和多态.day14;
/*
定义丈夫类 Husband 和妻子类 Wife，
        丈夫类的属性包括：身份证号，姓名，出生日期，妻子。
        妻子类的属性包括：身份证号，姓名，出生日期，丈夫。
        分别给这两个类提供构造方法（无参数构造方法和有参数构造方法都要提供），
        编写测试程序，创建丈夫对象，然后再创建妻子对象，丈夫对象关联妻子对象，
        妻子对象关联丈夫对象，要求能够输出这个“丈夫对象”的妻子的名字，
        或者能够输出这个“妻子对象”的丈夫的名字。要求能够画出程序执行过程的内存图。
        并且要求在程序中演示出空指针异常的效果。
*/
public class Husband {
    private String idCard;
    private String name;
    private String birthDate;
    private Wife wife;

    public Husband() {
    }

    public Husband(String idCard, String name, String birthDate, Wife wife) {
        this.idCard = idCard;
        this.name = name;
        this.birthDate = birthDate;
        this.wife = wife;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return wife.getName() + "的丈夫是" + name;
    }
}
