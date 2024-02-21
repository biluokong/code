package javase基础封装继承和多态.day14;
//设计男人类，每个男人都有身份证号、姓名、性别、女人。
// 设计女人类，每个女人都有身份证号、姓名、性别、男人。
public class Man {
    private String idCard;
    private String name;
    private final boolean sex = true;
    private Woman woman;

    public Man() {
    }

    public Man(String idCard, String name, Woman woman) {
        this.idCard = idCard;
        this.name = name;
        this.woman = woman;
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

    public boolean isSex() {
        return sex;
    }

    public Woman getWoman() {
        return woman;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "Man{" +
                "idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + "男" +
                ", woman='" + woman + '\'' +
                '}';
    }
}



