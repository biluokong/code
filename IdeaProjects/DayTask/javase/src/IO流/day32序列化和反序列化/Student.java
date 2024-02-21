package IO流.day32序列化和反序列化;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 4865930854316903441L;
    private String ID;
    private String name;
    private String birthday;
    private char sex;
    private String mailbox;


    public Student() {
    }

    public Student(String ID, String name, String birthday, char sex, String mailbox) {
        this.ID = ID;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.mailbox = mailbox;
    }

    @Override
    public String toString() {
        return "学号：" + ID + "\n" +
                "姓名：" + name + "\n" +
                "生日：" + birthday + "\n" +
                "性别：" + sex + "\n" +
                "邮箱：" + mailbox;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }
}
